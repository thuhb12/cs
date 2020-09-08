package com.github.hb.lol;

import com.github.hb.annotation.AutoWired;
import com.github.hb.service.FaceService;

public class Lol {

    @AutoWired
    private FaceService faceService;

    public void work() {
        faceService.buy("剑圣", 5);
    }

    public FaceService getFaceService() {
        return faceService;
    }

}
