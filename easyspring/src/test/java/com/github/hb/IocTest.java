package com.github.hb;

import com.github.hb.container.Container;
import com.github.hb.container.SampleContainer;
import com.github.hb.lol.A;
import com.github.hb.lol.Lol;
import com.github.hb.lol.Lol2;
import com.github.hb.lol.Lol3;
import com.github.hb.service.FaceService2;

public class IocTest {
    private static Container container = new SampleContainer();

    public static void baseTest() {
         container.registerBean(A.class);

         container.initWired();

         A a = container.getBean(A.class);
    }

    public static void iocClassTest(){
        container.registerBean(Lol2.class);
        // 初始化注入
        container.initWired();

        Lol2 lol = container.getBean(Lol2.class);
        lol.work();
    }

    public static void iocNameTest(){
        container.registerBean("face", new FaceService2());
        container.registerBean(Lol3.class);
        // 初始化注入
        container.initWired();

        Lol3 lol = container.getBean(Lol3.class);
        lol.work();
    }

    public static void main(String[] args) {
		baseTest();
//		iocClassTest();
//        iocNameTest();
    }
}
