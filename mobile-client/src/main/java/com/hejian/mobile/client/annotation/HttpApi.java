package com.hejian.mobile.client.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.hejian.mobile.client.define.SecurityType;

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpApi
{
  String name();
  
  String desc();
  
  String detail() default "";
  
  SecurityType security();
  
  //ApiOpenState state() default ApiOpenState.OPEN_TO_CLIENT;
  
  String owner() default "";
  
  String transfer() default "http";
}