package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明该参数顺序位置，在前端渲染参数属性面板使用.
 *
 * <pre>
 *   &#064;Order
 *   &#064;Parameter
 *   private String name;
 * </pre>
 *
 * 一般的，在不指定顺序位置时，参数属性面板渲染顺序按字段声明顺序
 *
 * @author White
 * @see Parameter
 * @since 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {

  /**
   * 返回排序值，默认为0.
   *
   * <pre>
   *   &#064;Order(0)
   * </pre>
   *
   * @return 排序值
   */
  int value() default 0;
}
