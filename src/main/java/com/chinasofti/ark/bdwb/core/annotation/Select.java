package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 当参数类型为select时，使用注解用来填充具体选项值.
 *
 * <pre>
 *   &#064;Select(value = {&#064;Option("one"), &#064;Option("two"), &#064;Option("three")}
 *   &#064;Parameter
 *   private String option;
 * </pre>
 *
 * <p>
 * 一般的，该注解需要在组件中配合{@code @Option}、{@code @Parameter}注解，只有在参数中才会生效,
 * 前端使用指定的选项渲染下拉列表
 * </p>
 *
 * @author White
 * @see Option
 * @see Parameter
 * @since 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Select {

  /**
   * 返回选项的数组.
   *
   * <pre>
   *   &#064;Select({&#064;Option("value")})
   * </pre>
   *
   * @return 选项的数组
   */
  Option[] value();
}
