package com.chinasofti.ark.bdwb.core.stage;

import com.google.common.collect.ForwardingListIterator;

import com.chinasofti.ark.bdwb.core.node.Node;
import com.chinasofti.ark.bdwb.core.node.NodeContext;

import java.util.ListIterator;

/**
 * Created by White on 2017/8/23.
 */
public class StageExecutor extends ForwardingListIterator<Node> {

  Stage stage;
  private ListIterator<Node> delegate;

  public StageExecutor(Stage stage) {
    this(stage, 0);
  }

  public StageExecutor(Stage stage, int index) {
    this.stage = stage;
    this.delegate = this.stage.listIterator(index);
  }

  public static StageExecutor newExecutor(Stage stage) {
    return StageExecutor.newExecutor(stage, 0);
  }

  public static StageExecutor newExecutor(Stage stage, int index) {
    return new StageExecutor(stage, index);
  }

  @Override
  protected ListIterator<Node> delegate() {
    return this.delegate;
  }

  protected ListIterator<NodeContext.NodeMidWare> midWares() {
    return this.stage.context.nodeMidWares.listIterator();
  }

  private void call(
      final ListIterator<NodeContext.NodeMidWare> midWares, final NodeContext.NodeCallback next) {
    Node prevNode = null;
    Throwable err = null;
    if (super.hasPrevious()) {
      prevNode = this.stage.get(super.nextIndex() - 1);
      err = prevNode.err();
    }

    Node nextNode = null;
    if (super.hasNext()) {
      nextNode = this.stage.get(super.nextIndex());
    }

    midWares.next().call(prevNode, nextNode, next, err);
  }

  private void invoke(
      final ListIterator<NodeContext.NodeMidWare> midWares,
      final NodeContext.NodeCallback next, final boolean step) {
    next.call();

    if (super.hasNext()) {
      if (midWares.hasNext()) {
        this.call(midWares, () -> this.invoke(midWares, () -> {
        }, step));
      } else if (!step) {
        this.run();
      }

    }

  }

  private void invoke(final boolean step) {
    this.invoke(this.midWares(), super.next().executor()::run, step);
  }

  public StageExecutor step() {
    this.invoke(true);

    return this;
  }

  public void run() {
    this.invoke(false);

  }

}
