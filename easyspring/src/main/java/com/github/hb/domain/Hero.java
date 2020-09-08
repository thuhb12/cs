package com.github.hb.domain;

import lombok.Data;

@Data
public class Hero {
    private String name;
    private String outfit;

    public void say() {
        System.out.println(name + " buy " + outfit);
    }
}
