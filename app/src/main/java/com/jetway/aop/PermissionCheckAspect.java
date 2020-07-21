package com.jetway.aop;

import android.content.Context;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 文件名：com.jetway.aop
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/21
 */
@Aspect
public class PermissionCheckAspect {
    private static final String TAG = "PermissionCheckAspect";

    @Pointcut("execution(@com.jetway.aop.permissionCheck * *(..))")
    public void CheckPermissionBehavior() {

    }

    @Around("CheckPermissionBehavior()")
    public Object checkPermission(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        permissionCheck annotation = signature.getMethod().getAnnotation(permissionCheck.class);
        String permission = annotation.value();
        Context context = (Context) joinPoint.getThis();

        Object o = null;
        if (PermissionManager.getInnerInstance().checkPermission(context, permission)) {
            o = joinPoint.proceed();
            Log.i(TAG, "有权限");
        } else {
            Log.i(TAG, "没有权限，不给用");
        }

        return o;
    }
}
