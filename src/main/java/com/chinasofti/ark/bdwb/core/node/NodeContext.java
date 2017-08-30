package com.chinasofti.ark.bdwb.core.node;

import com.chinasofti.ark.bdwb.core.stage.StageContext;

import java.util.Map;

/**
 * Created by White on 2017/8/23.
 */
public class NodeContext {

  public StageContext stageContext;
  private NodeConf conf;

  public NodeContext() {
    this(new NodeConf());
  }

  public NodeContext(NodeConf conf) {
    this(conf, new StageContext());
  }

  public NodeContext(NodeConf conf, StageContext stageContext) {
    this.conf = conf;
    this.stageContext = stageContext;
  }

  public String getId() {
    return this.conf.getId();
  }


  public String getName() {
    return this.conf.getName();
  }

  public NodeConf getConf() {
    return conf;
  }

  public NodeBuilder newBuilder() {
    return this.newBuilder(this);
  }

  public NodeBuilder newBuilder(NodeContext context) {
    return new NodeBuilder(context);
  }

  public enum NODE_CYCLE {
    NODE_CYCLE_ALL,
    NODE_CYCLE_INIT,
    NODE_CYCLE_CONFIGURE,
    NODE_CYCLE_EXECUTE,
    NODE_CYCLE_EXCEPTION,
    NODE_CYCLE_FINISH
  }

  public interface NodeMidWare {

    void call(Node prevNode, Node nextNode, NodeCallback next, Throwable err);

  }

  public interface NodeHook {

    void call(Node node, NODE_CYCLE curr, NodeCallback next, Throwable err);
  }

  public interface NodeCallback {

    void call();
  }

  public class NodeBuilder {

    private Node node;

    public NodeBuilder() {
      this(new NodeConf());
    }

    public NodeBuilder(NodeConf conf) {
      this(new NodeContext(conf));
    }

    public NodeBuilder(NodeContext context) {
      this.node = new Node(context);
    }

    public NodeBuilder id(String id) {
      this.node.context.getConf().setId(id);

      return this;
    }

    public NodeBuilder name(String name) {
      this.node.context.getConf().setName(name);

      return this;
    }

    public NodeBuilder parameter(String name, String value) {
      this.node.parameter(name, value);

      return this;
    }

    public NodeBuilder parameter(Map<String, String> set) {
      for (String name : set.keySet()) {
        this.parameter(name, set.get(name));
      }

      return this;
    }

    public Node build() {
      return this.node;
    }
  }
}
