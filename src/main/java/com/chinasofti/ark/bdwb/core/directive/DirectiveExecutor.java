package com.chinasofti.ark.bdwb.core.directive;

/**
 * Created by White on 2017/8/24.
 */
public class DirectiveExecutor {

  private Directive directive;

  private DirectiveExecutor(Directive directive) {
    this.directive = directive;
  }

  public static DirectiveExecutor newExecutor(Directive directive) {
    return new DirectiveExecutor(directive);
  }

  public void run() {
    directive.run();
  }
}
