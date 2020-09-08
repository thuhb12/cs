package com.github.hb;

import com.github.hb.domain.Hero;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.github.hb.domain.Hero");

        Constructor cons = clazz.getDeclaredConstructor((Class[])null);
        Hero hero = (Hero) cons.newInstance();

        Method setBrand = clazz.getMethod("setName", String.class);
        setBrand.invoke(hero, "小鱼人");
        Method setColor = clazz.getMethod("setOutfit", String.class);
        setColor.invoke(hero, "爆裂魔杖");

        hero.say();
    }
}
