package com.chinasofti.ark.bdwb.core.directive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by White on 2017/8/24.
 */
public class Directive {

  private final Logger logger = LoggerFactory.getLogger(Directive.class);

  public DirectiveContext context;

  public Directive() {
    this(new DirectiveConf());
  }

  public Directive(DirectiveConf conf) {
    this(new DirectiveContext(conf));
  }

  public Directive(DirectiveContext context) {
    this.context = context;
  }

  public void run() {
    logger.info("run." + this);
  }

  public DirectiveExecutor executor() {
    return DirectiveExecutor.newExecutor(this);
  }

  @Override
  public String toString() {
    return "Directive{" +
           "id=" + context.getId() +
           "name=" + context.getName() +
           '}';
  }
}
