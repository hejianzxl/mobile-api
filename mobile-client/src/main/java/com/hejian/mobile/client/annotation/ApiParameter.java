package com.hejian.mobile.client.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiParameter
{
  boolean required();
  
  boolean rsaEncrypted() default false;
  
  String name();
  
  String defaultValue() default "";
  
  String verifyRegex() default "";
  
  String verifyMsg() default "";
  
  String desc();
}
