package com.chinasofti.ark.bdwb.core.directive;

/**
 * Created by White on 2017/8/24.
 */
public class DirectiveContext {

  private DirectiveConf conf;

  public DirectiveContext() {
    this(new DirectiveConf());
  }

  public DirectiveContext(DirectiveConf conf) {
    this.conf = conf;
  }

  public String getId() {
    return this.getConf().getId();
  }

  public String getName() {
    return this.getConf().getName();
  }

  public DirectiveConf getConf() {
    return this.conf;
  }

  public DirectiveBuilder newBuilder() {
    return this.newBuilder(this);
  }

  public DirectiveBuilder newBuilder(DirectiveContext context) {
    return new DirectiveBuilder(context);
  }

  public static class DirectiveBuilder {

    private Directive directive;

    public DirectiveBuilder() {
      this(new DirectiveConf());
    }

    public DirectiveBuilder(DirectiveConf conf) {
      this(new DirectiveContext(conf));
    }

    public DirectiveBuilder(DirectiveContext context) {
      this.directive = new Directive(context);
    }

    public DirectiveBuilder id(String id) {
      this.directive.context.getConf().setId(id);

      return this;
    }

    public DirectiveBuilder name(String name) {
      this.directive.context.getConf().setName(name);

      return this;
    }

    public Directive build() {
      return this.directive;
    }
  }
}
