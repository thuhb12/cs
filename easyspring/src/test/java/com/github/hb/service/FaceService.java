package com.github.hb.service;

import com.github.hb.AutoWired;
import com.github.hb.lol.Lol;

public class FaceService {

    @AutoWired
    private Lol lol;

    public void buy(String name, int money){
        lol.work();
        System.out.println(name + "买了" + money + "毛钱特效，装逼成功!");
    }
}
