package org.mobile.api.util.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiGroup
{
  int minCode();
  
  int maxCode();
  // api名称
  String name();
  // code 描述对象
  Class codeDefine();

  String owner() default "";
}

