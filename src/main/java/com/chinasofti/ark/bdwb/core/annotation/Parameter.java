package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明该字段为参数属性，在运行时，这些参数的值会被自动装配好.
 *
 * <pre>
 *   &#064;Parameter
 *   private String name;
 * </pre>
 *
 * @author White
 * @since 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Parameter {

  /**
   * 返回名称，默认为"".
   *
   * <pre>
   *   &#064;Parameter(name = "name")
   * </pre>
   *
   * @return 名称
   */
  String name() default "";

  /**
   * 返回描述，它可能包含描述参数的作用，规则以及简要说明，默认为"".
   *
   * <pre>
   *   &#064;Parameter(desc = "desc")
   * </pre>
   *
   * @return 描述
   */
  String desc() default "";

  /**
   * 返回默认值，默认为"".
   *
   * <pre>
   *   &#064;Parameter(value = "value")
   * </pre>
   *
   * @return 默认值
   */
  String value() default "";

  /**
   * 返回参数类型，默认为"text".
   *
   * <pre>
   *   &#064;Parameter(type = "type")
   * </pre>
   *
   * @return 参数类型
   */
  String type() default "text";

}
