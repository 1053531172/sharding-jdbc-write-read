package com.chendb.sharding.aspect;

import com.chendb.sharding.annotation.MasterSelect;
import org.apache.shardingsphere.api.hint.HintManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 强制路由到主库反射处理
 * @Author chendengbin
 * @Date 2022/6/1 19:56
 * @Version 1.0
 **/
@Aspect
@Component
public class MasterSelectAspect {

    @Pointcut(value = "execution(* com.chendb.sharding.service.*.*(..))")
    public void masterSelectPointCutService(){}

    @Around(value = "masterSelectPointCutService()")
    public Object setMasterSelect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object object = null;
        Throwable throwable = null;
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        if (methodSignature.getMethod().isAnnotationPresent(MasterSelect.class)) {
            HintManager.getInstance().setMasterRouteOnly();
        }

        try {
            object = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throwable = e;
        } finally {
            HintManager.clear();
            if (throwable != null) {
                throw  throwable;
            }
        }

        return object;
    }
}
