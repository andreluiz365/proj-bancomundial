package com.github.maikoncanuto.core.annotations;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@InterceptorBinding
@Target({TYPE})
@Retention(RUNTIME)
public @interface Audit {
}
