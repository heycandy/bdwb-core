package com.chinasofti.ark.bdwb.core.node;

import com.chinasofti.ark.bdwb.core.directive.Directive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by White on 2017/8/23.
 */
public class Node {

  private final Logger logger = LoggerFactory.getLogger(Node.class);

  public NodeContext context;
  public Directive directive;
  public Throwable err;

  public Node() {
    this(new NodeConf());
  }

  public Node(NodeConf conf) {
    this(new NodeContext(conf));
  }

  public Node(NodeContext context) {
    this.context = context;
  }

  void init() {
    logger.info("init." + this);
  }

  void configure() {
    logger.info("configure." + this);
  }

  void execute() {
    logger.info("execute." + this);
    this.directive.executor().run();
  }

  void exception(Throwable err) {
    logger.error("exception." + this);
    this.err = err;
  }

  void finish() {
    logger.info("finish." + this);
  }

  public Node directive(Directive directive) {
    this.directive = directive;

    return this;
  }

  public Node parameter(String name, String value) {

    return this;
  }

  public Throwable err() {
    return this.err;
  }

  public NodeExecutor executor() {
    return NodeExecutor.newBuilder(this);
  }

  @Override
  public String toString() {
    return "Node{" +
           "id='" + context.getId() + '\'' +
           ", name='" + context.getName() + '\'' +
           '}';
  }
}
