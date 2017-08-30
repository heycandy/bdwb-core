package com.chinasofti.ark.bdwb.core.component;

/**
 * Created by White on 2017/8/23.
 */
public class ComponentContext {

  private ComponentConf conf;

  public ComponentContext() {
    this(new ComponentConf());
  }

  public ComponentContext(ComponentConf conf) {
    this.conf = conf;
  }

  public ComponentConf getConf() {
    return conf;
  }
}
