package com.github.hb.container;

import com.github.hb.annotation.AutoWired;
import com.github.hb.utils.ReflectUtil;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class SampleContainer implements Container {
    private Map<String, Object> beans;
    private Map<String, String> beanKeys;

    public SampleContainer() {
        this.beans = new ConcurrentHashMap<String, Object>();
        this.beanKeys = new ConcurrentHashMap<String, String>();
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        String name = clazz.getName();
        Object object = beans.get(name);
        if (null != object) {
            return (T) object;
        }
        return null;
    }

    @Override
    public <T> T getBeanByName(String name) {
        String className = beanKeys.get(name);
        Object object = beans.get(name);
        if (null != object) {
            return (T) object;
        }
        return null;
    }

    @Override
    public Object registerBean(Object bean) {
        String name = bean.getClass().getName();
        beanKeys.put(name, name);
        beans.put(name, bean);
        return bean;
    }

    @Override
    public Object registerBean(Class<?> clazz) {
        try {
            String name = clazz.getName();
            beanKeys.put(name, name);
            Object bean = ReflectUtil.newInstance(clazz);
            beans.put(name, bean);
            return bean;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object registerBean(String name, Object bean) {
        String className = bean.getClass().getName();
        beanKeys.put(name, className);
        beans.put(className, bean);
        return bean;
    }

    @Override
    public void remove(Class<?> clazz) {
        String className = clazz.getName();
        if (null != className && !className.equals("")) {
            beanKeys.remove(className);
            beans.remove(className);
        }
    }

    @Override
    public void removeByName(String name) {
        String className = beanKeys.get(name);
        if (null != className && !className.equals("")) {
            beanKeys.remove(name);
            beans.remove(className);
        }
    }

    @Override
    public Set<String> getBeanNames() {
        return beanKeys.keySet();
    }

    @Override
    public void initWired() {
        Iterator<Entry<String, Object>> it = beans.entrySet().iterator();
        Map<String, Object> start = new ConcurrentHashMap<String, Object>();
        Map<String, Object> target = new ConcurrentHashMap<String, Object>();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            Object object = entry.getValue();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                register(field, start);
            }
//            injection(object);
        }
        while (start.size() > 0) {
            for (Map.Entry<String, Object> entry : start.entrySet()) {
                Object object = entry.getValue();
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field field : fields) {
                    register(field, target);
                }
            }
            start = target;
            target = new ConcurrentHashMap<String, Object>();
        }

        Iterator<Entry<String, Object>> t = beans.entrySet().iterator();
        while (t.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) t.next();
            setReferenceGraph(entry.getValue());
        }
    }

    private void setReferenceGraph(Object object) {
        Set<String> path = new HashSet<String>();
        dfs(object, path);
    }

    private void dfs(Object object, Set<String> path) {
        Field[] fields = object.getClass().getDeclaredFields();
        path.add(object.getClass().getName());
        for (Field field : fields) {
            AutoWired autoWired = field.getAnnotation(AutoWired.class);
            if (autoWired == null) {
                continue;
            }
            Class<?> clazz = autoWired.value();
            if (clazz == Class.class) {
                clazz = field.getType();
            }
            String className = clazz.getName();
            if (path.contains(className)) {
                continue;
            }
            Object autoWiredField = beans.get(className);

            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            try {
                field.set(object, autoWiredField);
            } catch (SecurityException e) {

            } catch (IllegalAccessException e) {

            }
            field.setAccessible(accessible);
            dfs(autoWiredField, path);
        }
        path.remove(object.getClass().getName());
    }

    private void register(Field field, Map<String, Object> target) {
        AutoWired autoWired = field.getAnnotation(AutoWired.class);
        if (autoWired == null) {
            return;
        }
        String name = autoWired.name();
        Class<?> clazz = autoWired.value();
        if (clazz == Class.class) {
            clazz = field.getType();
        }
        if(name.equals("")){
            name = clazz.getName();
        }
        String className = beanKeys.get(name);
        if (className != null && className.equals("")) {
            return;
        }
        Object object = this.getBean(clazz);
        if (null == object) {
            object = registerBean(clazz);
            registerBean(name, object);
            target.put(clazz.getName(), object);
        }
    }

//    public void injection(Object object) {
//        // 所有字段
//        try {
//            Field[] fields = object.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                // 需要注入的字段
//                AutoWired autoWired = field.getAnnotation(AutoWired.class);
//                if (null != autoWired) {
//
//                    // 要注入的字段
//                    Object autoWiredField = null;
//
//                    String name = autoWired.name();
//                    if(!name.equals("")){
//                        String className = beanKeys.get(name);
//                        if(null != className && !className.equals("")){
//                            autoWiredField = beans.get(className);
//                        }
//                        if (null == autoWiredField) {
//                            throw new RuntimeException("Unable to load " + name);
//                        }
//                    } else {
//                        if(autoWired.value() == Class.class){
//                            autoWiredField = recursiveAssembly(field.getType());
//                        } else {
//                            // 指定装配的类
//                            autoWiredField = this.getBean(autoWired.value());
//                            if (null == autoWiredField) {
//                                autoWiredField = recursiveAssembly(autoWired.value());
//                            }
//                        }
//                    }
//
//                    if (null == autoWiredField) {
//                        throw new RuntimeException("Unable to load " + field.getType().getCanonicalName());
//                    }
//
//                    boolean accessible = field.isAccessible();
//                    field.setAccessible(true);
//                    field.set(object, autoWiredField);
//                    field.setAccessible(accessible);
//                }
//            }
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private Object recursiveAssembly(Class<?> clazz) {
//        if(null != clazz){
//            return this.registerBean(clazz);
//        }
//        return null;
//    }
}
