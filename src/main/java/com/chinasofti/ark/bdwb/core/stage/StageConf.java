package com.chinasofti.ark.bdwb.core.stage;

import java.util.HashMap;

/**
 * Created by White on 2017/8/23.
 */
public class StageConf extends HashMap<String, Object> {

  private String id;
  private String name;

  public StageConf() {
  }

  public StageConf(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public StageConf setId(String id) {
    this.id = id;

    return this;
  }

  public String getName() {
    return name;
  }

  public StageConf setName(String name) {
    this.name = name;

    return this;
  }

  public String getString(String key) {
    return super.get(key).toString();
  }

  public Integer getInt(String key) {
    return Integer.valueOf(this.getString(key));
  }

  public String[] getArray(String key) {
    return this.getString(key).split(",");
  }

  public <T> T getObject(String key) {
    return (T) super.get(key);
  }
}
