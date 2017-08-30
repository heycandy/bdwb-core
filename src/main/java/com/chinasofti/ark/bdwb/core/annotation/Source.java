package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明该组件为数据源，用以区分数据源组件和其他组件.
 *
 * <pre>
 *   &#064;Source
 *   &#064;Component
 *    public &#064;class Source {
 *        ...
 *    }
 * </pre>
 *
 * <p>
 * 一般的，该注解需要在组件中配合{@code @Component}注解
 * </p>
 *
 * @author White
 * @see Component
 * @since 1.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Source {

  /**
   * 返回是否可读，默认为true.
   *
   * <pre>
   *   &#064;Source(readable = true)
   * </pre>
   *
   * @return 是否可读
   */
  boolean readable() default true;

  /**
   * 返回是否可写，默认为true.
   *
   * <pre>
   *   &#064;Source(writeable = true)
   * </pre>
   *
   * @return 是否可写
   */
  boolean writeable() default true;
}
