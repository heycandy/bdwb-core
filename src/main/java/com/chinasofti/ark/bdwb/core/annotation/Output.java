package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明指令是否有输出，数据输出的类型.
 *
 * <pre>
 *   &#064;Output
 *   &#064;Directive
 *   public void demo(&#064;Input dataSet: DataSet)
 * </pre>
 *
 * <p>
 * 一般的，该注解需要在组件中配合一个{@code @Directive}注解，只有给指令函数使用才会生效
 * </p>
 *
 * @author White
 * @see Directive
 * @since 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Output {

  /**
   * 返回名称，默认为"out".
   *
   * <pre>
   *   &#064;Output
   *   &#064;Directive
   *   public void demo(&#064;Input dataSet: DataSet)
   * </pre>
   *
   * <pre>
   *   &#064;Output(name = "out")
   *   &#064;Directive
   *   public void demo(&#064;Input(name = "in0") in0: DataSet, &#064;Input(name = "in1") in1:
   * DataSet)
   * </pre>
   *
   * @return 名称
   */
  String name() default "out";

  /**
   * 返回描述，它可能是该输入的类型，结构以及简要说明，默认为"".
   *
   * <pre>
   *   &#064;Directive
   *   public void demo(&#064;Input(desc = "desc") dataSet: DataSet)
   * </pre>
   *
   * @return 描述
   */
  String desc() default "";

}
