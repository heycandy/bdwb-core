package com.chinasofti.ark.bdwb.core.stage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.chinasofti.ark.bdwb.core.directive.Directive;
import com.chinasofti.ark.bdwb.core.directive.DirectiveConf;
import com.chinasofti.ark.bdwb.core.directive.DirectiveContext;
import com.chinasofti.ark.bdwb.core.node.Node;
import com.chinasofti.ark.bdwb.core.node.NodeConf;
import com.chinasofti.ark.bdwb.core.node.NodeContext;

import java.util.List;
import java.util.Map;

/**
 * Created by White on 2017/8/23.
 */
public class StageContext {

  public List<NodeContext.NodeMidWare> nodeMidWares;
  public Map<NodeContext.NODE_CYCLE, List<NodeContext.NodeHook>> nodeHooks;
  private StageConf conf;

  public StageContext() {
    this(new StageConf());
  }

  public StageContext(StageConf conf) {
    this.conf = conf;

    this.nodeMidWares = Lists.newArrayList();
    this.nodeHooks = Maps.newHashMap();
    for (NodeContext.NODE_CYCLE cycle : NodeContext.NODE_CYCLE.values()) {
      this.nodeHooks.put(cycle, Lists.newArrayList());
    }
  }

  public StageConf getConf() {
    return conf;
  }

  public StageContext use(NodeContext.NodeMidWare midWare) {
    this.nodeMidWares.add(midWare);

    return this;
  }

  public StageContext use(NodeContext.NodeHook hook, NodeContext.NODE_CYCLE cycle) {
    this.nodeHooks.get(cycle).add(hook);

    return this;
  }

  public StageBuilder newBuilder() {
    return this.newBuilder(this);
  }

  public StageBuilder newBuilder(StageContext context) {
    return new StageBuilder(context);
  }

  public class StageBuilder {

    private Stage stage;

    private StageBuilder() {
      this(new StageConf());
    }

    private StageBuilder(StageConf conf) {
      this(new StageContext(conf));
    }

    private StageBuilder(StageContext context) {
      this.stage = new Stage(context);
    }

    public StageBuilder addNode(String name) {
      NodeConf conf = new NodeConf();
      NodeContext context = new NodeContext(conf, stage.context);
      Node node = context.newBuilder().name(name).build();

      return this.addNode(node);
    }

    public StageBuilder addNode(Node node) {
      this.stage.add(node);

      return this;
    }

    public StageBuilder directive(String name) {
      DirectiveConf conf = new DirectiveConf();
      DirectiveContext context = new DirectiveContext(conf);
      Directive directive = context.newBuilder().name(name).build();

      return this.directive(directive);
    }

    public StageBuilder directive(Directive directive) {
      this.stage.get().directive(directive);

      return this;
    }

    public StageBuilder parameter(String name, String value) {
      this.stage.get().parameter(name, value);

      return this;
    }

    public StageBuilder parameter(Map<String, String> set) {
      for (String name : set.keySet()) {
        this.parameter(name, set.get(name));
      }

      return this;
    }

    public StageBuilder channel(String name) {

      return this;
    }

    public StageBuilder use(NodeContext.NodeMidWare midWare) {
      this.stage.context.use(midWare);

      return this;
    }

    public StageBuilder use(NodeContext.NodeHook hook, NodeContext.NODE_CYCLE cycle) {
      this.stage.context.use(hook, cycle);

      return this;
    }

    public Stage build() {
      return this.stage;
    }
  }

}

