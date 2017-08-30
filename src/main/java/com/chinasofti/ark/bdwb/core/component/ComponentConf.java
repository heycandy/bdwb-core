package com.chinasofti.ark.bdwb.core.component;

import java.util.HashMap;

/**
 * Created by White on 2017/8/23.
 */
public class ComponentConf extends HashMap<String, Object> {

  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public ComponentConf setId(String id) {
    this.id = id;

    return this;
  }

  public String getName() {
    return name;
  }

  public ComponentConf setName(String name) {
    this.name = name;

    return this;
  }

  public String getString(String key) {
    return super.get(key).toString();
  }

  public Integer getInt(String key) {
    return Integer.valueOf(this.getString(key));
  }

}
