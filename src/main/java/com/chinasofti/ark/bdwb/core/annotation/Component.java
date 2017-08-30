package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明该类为组件，如果没有此注解便不会扫描该类中任何内容.
 *
 * <pre>
 *   &#064;Component(name= "namespace", desc = "description", version = "1.0", author = "White",
 * email = "baiyu@chinasofti.com")
 *    public &#064;class Demo {
 *        ...
 *    }
 * </pre>
 *
 * @author White
 * @since 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

  /**
   * 返回组件命名，它描述组件中所包含指令在某个命名下，默认为"default".
   *
   * <pre>
   *   &#064;Component(name = "namespace")
   *    public &#064;class Component {
   *        ...
   *    }
   * </pre>
   *
   * <p>这个元素在场景执行，组件可视化列表中会被使用到</p>
   * 比如数据源指令会有两个“read”&amp;“write”，使用数据源组件时，那么就有“namespace.read”&amp;“namespace.read”的之分<br>
   * 比如在显示组件列表，使用命名空间来对组件进行默认分类，渲染组件结构树
   *
   * @return 组件命名
   */
  String name() default "default";

  /**
   * 返回组件描述，它可能包含描述组件的功能，使用以及简要说明，默认为"".
   *
   * <pre>
   *   &#064;Component(desc = "description")
   * </pre>
   *
   * @return 组件描述
   */
  String desc() default "";

  /**
   * 返回组件版本，默认为"".
   *
   * <pre>
   *   &#064;Component(version = "1.0")
   * </pre>
   *
   * @return 组件版本
   */
  String version() default "";

  /**
   * 返回作者姓名，默认为"".
   *
   * <pre>
   *   &#064;Component(author = "White")
   * </pre>
   *
   * @return 作者姓名
   */
  String author() default "";

  /**
   * 返回作者邮箱，默认为"".
   *
   * <pre>
   *   &#064;Component(email = "baiyu@chinasofti.com")
   * </pre>
   *
   * @return 作者邮箱
   */
  String email() default "";

}
