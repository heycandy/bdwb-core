package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明该参数是否为输入，数据输入类型.
 *
 * <pre>
 *   &#064;Directive
 *   public void demo(&#064;Input dataSet: DataSet)
 * </pre>
 *
 * <p>
 * 一般的，该注解需要在组件中配合一个{@code @Directive}注解，只有在指令函数参数中才会生效,
 * 在指令方法中有多个输入的可以配合该注解通过名称来和输入数据进行绑定
 * </p>
 *
 * @author White
 * @see Directive
 * @since 1.0
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Input {

  /**
   * 返回输入名称，默认为"".
   *
   * <pre>
   *   &#064;Directive
   *   public void demo(&#064;Input dataSet: DataSet)
   * </pre>
   *
   * <pre>
   *   &#064;Directive
   *   public void demo(&#064;Input(name = "in0") in0: DataSet, &#064;Input(name = "in1") in1:
   * DataSet)
   * </pre>
   *
   * @return 输入名称
   */
  String name() default "in";

  /**
   * 返回输入描述，它可能是该输入的类型，结构以及简要说明，默认为"".
   *
   * <pre>
   *   &#064;Directive
   *   public void demo(&#064;Input(desc = "desc") dataSet: DataSet)
   * </pre>
   *
   * @return 输入描述
   */
  String desc() default "";

}
