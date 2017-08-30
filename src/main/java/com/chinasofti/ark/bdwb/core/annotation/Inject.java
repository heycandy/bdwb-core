package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明该字段需要自动注入实例对象使用，或者注入对应名称实例.
 *
 * <pre>
 *   &#064;Inject
 *   private ComponentContext context;
 * </pre>
 *
 * <pre>
 *   &#064;Inject(name = "named")
 *   private ComponentConf conf;
 * </pre>
 *
 * @author White
 * @since 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

  /**
   * 返回实例名称，默认为"".
   *
   * <pre>
   *   &#064;Inject(name = "named")
   * </pre>
   *
   * 当名称没有被指定而使用默认值时，查找相同字段类型的实例进行注入
   *
   * @return 实例名称
   */

  String name() default "";

}
