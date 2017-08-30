package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明该方法为指令，该指令方法会被注册到所在组件命名目录下，被外部调用.
 *
 * <pre>
 *   &#064;Directive(name= "name", desc = "desc", params = {})
 * </pre>
 *
 * @author White
 * @since 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Directive {

  /**
   * 返回指令名称，它描述指令被注册时使用的名称，默认为"".
   *
   * <pre>
   *   &#064;Directive(name = "name")
   * </pre>
   *
   * 当名称没有被指定而使用默认值时，会使用被注释方法的方法名作为该指令名称
   *
   * @return 指令名称
   */
  String name() default "";

  /**
   * 返回指令描述，它可能该指令的功能，使用以及简要说明，默认为"".
   *
   * <pre>
   *   &#064;Directive(desc = "desc")
   * </pre>
   *
   * @return 指令描述
   */
  String desc() default "";

  String engine() default "";

  /**
   * 返回参数名称集合，它描述了该指令所需用到某些参数，默认为"".
   *
   * <pre>
   *   &#064;Directive(name = "name")
   * </pre>
   *
   * <p>
   * 从此版本开始，一个组件可能包含多个指令动作，每个指令所需参数肯定是不完全一致的，
   * 所以需要通过这个元素通过参数名来关联所需的参数，用于前端正确的渲染该指令的参数属性面板
   * </p>
   *
   * @return 参数名称集合
   */
  String[] params() default "";
}
