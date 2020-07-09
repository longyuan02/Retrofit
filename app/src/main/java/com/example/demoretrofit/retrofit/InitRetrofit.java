package com.example.demoretrofit.retrofit;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.Arrays;

/*注解实现类*/
public class InitRetrofit {
    public static void initValue(Activity activity) {
        /*获取实例*/
        Class<?> clazz = activity.getClass();
        Intent intent = activity.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            /*判断属性是否为注解*/
            if (f.isAnnotationPresent(getValue.class)) {
                //得到注解属性
                getValue getValue = f.getAnnotation(getValue.class);
                //获取注解key
                String key = TextUtils.isEmpty(getValue.value()) ? f.getName() : getValue.value();
                //判断是否为包含key
                if (bundle.containsKey(key)) {
                    Object object = bundle.get(key);
                    /* 处理数组*/
                    Class<?> componentType = f.getType().getComponentType();
                    if (f.getType().isArray() && Parcelable.class.isAssignableFrom(componentType)) {
                        Object[] objects = (Object[]) object;
                        Object[] objects1 = Arrays.copyOf(objects, objects.length, (Class<? extends Object[]>) f.getType().getComponentType());
                        object = objects1;
                    }
                    //打开私有访问权限
                    f.setAccessible(true);
                    try {
                        //将值赋给属性
                        f.set(activity, object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }


                }


            }
        }


    }

}
