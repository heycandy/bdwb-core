package com.chinasofti.ark.bdwb.core.node;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by White on 2017/8/24.
 */
public class NodeExecutor {

  public Node node;

  public NodeExecutor(Node node) {
    this.node = node;
  }

  public static NodeExecutor newBuilder(Node node) {
    return new NodeExecutor(node);
  }

  private ListIterator<NodeContext.NodeHook> hooks(NodeContext.NODE_CYCLE cycle) {
    List<NodeContext.NodeHook> allHooks =
        this.node.context.stageContext.nodeHooks.get(NodeContext.NODE_CYCLE.NODE_CYCLE_ALL);

    List<NodeContext.NodeHook> hooks = Lists.newArrayList(allHooks);
    hooks.addAll(this.node.context.stageContext.nodeHooks.get(cycle));

    return hooks.listIterator();
  }

  private void call(
      final ListIterator<NodeContext.NodeHook> hooks, final NodeContext.NODE_CYCLE cycle,
      final NodeContext.NodeCallback next) {
    if (hooks.hasNext()) {
      hooks.next().call(
          this.node, cycle, () -> this.call(hooks, cycle, next), this.node.err());
    } else {
      next.call();
    }
  }

  private void invoke(NodeContext.NODE_CYCLE cycle, NodeContext.NodeCallback next) {
    this.call(this.hooks(cycle), cycle, next);
  }


  public void run() {
    try {
      this.invoke(NodeContext.NODE_CYCLE.NODE_CYCLE_INIT, this.node::init);
      this.invoke(NodeContext.NODE_CYCLE.NODE_CYCLE_CONFIGURE, this.node::configure);
      this.invoke(NodeContext.NODE_CYCLE.NODE_CYCLE_EXECUTE, this.node::execute);
    } catch (final Throwable err) {
      this.invoke(NodeContext.NODE_CYCLE.NODE_CYCLE_EXCEPTION, () -> this.node.exception(err));
    } finally {
      this.invoke(NodeContext.NODE_CYCLE.NODE_CYCLE_FINISH, this.node::finish);
    }

  }


}
