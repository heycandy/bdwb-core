package com.chinasofti.ark.bdwb.core.stage;

import com.chinasofti.ark.bdwb.core.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by White on 2017/8/23.
 */
public class Stage extends ArrayList<Node> {

  public StageContext context;

  public Stage() {
    this(new StageConf());
  }

  public Stage(StageConf conf) {
    this(new StageContext(conf));
  }

  public Stage(StageContext context) {
    this.context = context;
  }

  public Stage(StageContext context, List<Node> collection) {
    super(collection);

    this.context = context;
  }

  public Stage subStage(int toIndex) {
    return this.subStage(0, toIndex);
  }

  public Stage subStage(int fromIndex, int toIndex) {
    return new Stage(this.context, super.subList(fromIndex, toIndex));
  }

  public StageExecutor executor() {
    return StageExecutor.newExecutor(this);
  }

  public StageExecutor executor(int index) {
    return StageExecutor.newExecutor(this, index);
  }

  public Node get() {
    return super.get(super.size() - 1);
  }

  @Override
  public String toString() {
    return "Stage{" +
           "id=" + context.getConf().getId() +
           "name=" + context.getConf().getName() +
           '}';
  }
}
