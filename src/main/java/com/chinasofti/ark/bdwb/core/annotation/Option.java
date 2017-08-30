package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明Select类型参数的选项.
 *
 * <pre>
 *   &#064;Select(value = {&#064;Option("one"), &#064;Option("two"), &#064;Option("three")}
 *   &#064;Parameter
 *   private String option;
 * </pre>
 *
 * <p>
 * 一般的，该注解需要在组件中配合{@code @Select}、{@code @Parameter}注解，只有在参数中才会生效,
 * 前端使用指定的选项渲染下拉列表
 * </p>
 *
 * @author White
 * @see Select
 * @see Parameter
 * @since 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Option {

  /**
   * 返回选项名称，默认为"".
   *
   * <pre>
   *   &#064;Option(name = "name")
   * </pre>
   *
   * @return 选项名称
   */
  String name() default "";

  /**
   * 返回选项描述，默认为"".
   *
   * <pre>
   *   &#064;Option(desc = "desc")
   * </pre>
   *
   * @return 选项描述
   */
  String desc() default "";

  /**
   * 返回选项值，默认为"".
   *
   * <pre>
   *   &#064;Option(value = "value")
   * </pre>
   *
   * @return 选项值
   */
  String value();
}
