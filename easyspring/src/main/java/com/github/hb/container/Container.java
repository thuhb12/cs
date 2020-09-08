package com.github.hb.container;


import java.util.Set;

public interface Container {
    public <T> T getBean(Class<T> clazz);
    public <T> T getBeanByName(String name);
    public Object registerBean(Object bean);
    public Object registerBean(Class<?> clazz);
    public Object registerBean(String name, Object bean);
    public void remove(Class<?> clazz);
    public void removeByName(String name);
    public Set<String> getBeanNames();
    public void initWired();
}
