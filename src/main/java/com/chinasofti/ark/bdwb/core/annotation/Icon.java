package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明一个组件或者指令所使用的图标，用于前台渲染使用.
 *
 * <pre>
 *   &#064;Icon("icon.png")
 *   &#064;Component
 *    public class Demo {
 *        ...
 *    }
 * </pre>
 *
 * <pre>
 *   &#064;Icon("icon.png")
 *   &#064;Directive
 *    public void demo() {
 *        ...
 *    }
 * </pre>
 *
 * 一般的，该注解需要在组件中配合一个{@code @Component}注解或者{@code @Directive}注解
 *
 * @author White
 * @see Component
 * @see Directive
 * @since 1.0
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Icon {

  /**
   * 返回资源地址，使用classpath相对路径.
   *
   * <pre>
   *   &#064;Icon("icon/icon.png")
   * </pre>
   *
   * @return 资源地址
   */
  String value();
}
