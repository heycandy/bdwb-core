package com.chinasofti.ark.bdwb.core.component;

/**
 * Created by White on 2017/8/28.
 */
public class Component {

  public ComponentContext context;

  public Component() {
    this(new ComponentConf());
  }

  public Component(ComponentConf conf) {
    this(new ComponentContext(conf));
  }

  public Component(ComponentContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return "Component{" +
           "id=" + context.getConf().getId() +
           "name=" + context.getConf().getName() +
           '}';
  }
}
