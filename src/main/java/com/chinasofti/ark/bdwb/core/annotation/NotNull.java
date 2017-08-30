package com.chinasofti.ark.bdwb.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指明该参数不能空，在对组件参数校验时使用，默认可为空.
 *
 * <pre>
 *   &#064;NotNull
 *   &#064;Parameter
 *   private String name;
 * </pre>
 *
 * @author White
 * @see Parameter
 * @since 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {

}
