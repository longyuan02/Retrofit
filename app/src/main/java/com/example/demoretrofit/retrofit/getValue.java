package com.example.demoretrofit.retrofit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*元注解
* 作用在类属性
* 生效在运行时*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface getValue {
    /*设置默认值 value为空时 返回""*/
    String value() default "";
}
