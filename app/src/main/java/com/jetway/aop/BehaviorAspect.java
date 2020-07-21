package com.jetway.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名：com.jetway.aop
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/3/10
 * 切面
 * 你想要切下来的蛋糕
 */
@Aspect
public class BehaviorAspect {
    private static final String TAG = "BehaviorAspect";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 如何切蛋糕，切成什么样的形状
     * 切点
     */
    @Pointcut("execution(@com.jetway.aop.BehaviorTrace * *(..))")
    public void annoBehavior() {

    }


    /**
     * 切面
     * 蛋糕按照切点切下来之后   怎么吃
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("annoBehavior()")
    public Object dealPonint(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        BehaviorTrace behaviorTrace = methodSignature.getMethod().getAnnotation(BehaviorTrace.class);
        String contentType = behaviorTrace.value();
        int type = behaviorTrace.type();
        Log.i(TAG, contentType + "使用时间：   " + simpleDateFormat.format(new Date()));
        long beagin = System.currentTimeMillis();
        //方法执行时
        Object object = null;
        try {
            object = point.proceed();
        } catch (Exception e) {
        }

        if (type == 1) {
            //方法执行完成
            Log.i(TAG, "摇一摇消耗时间：  " + (System.currentTimeMillis() - beagin) + "ms");
        } else if (type == 2) {
            //方法执行完成
            Log.i(TAG, "语音消耗时间：  " + (System.currentTimeMillis() - beagin) + "ms");
        } else if (type == 3) {
            //方法执行完成
            Log.i(TAG, "文字消耗时间：  " + (System.currentTimeMillis() - beagin) + "ms");
        }


        return object;

    }
}
