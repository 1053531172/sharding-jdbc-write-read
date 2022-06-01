package com.chendb.sharding.annotation;

import java.lang.annotation.*;

/**
 * 强制路由到主库查询
 * @Author chendengbin
 * @Date 2022/6/1 19:54
 * @Version 1.0
 **/
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MasterSelect {
}
