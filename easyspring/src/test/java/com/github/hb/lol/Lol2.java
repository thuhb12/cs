package com.github.hb.lol;

import com.github.hb.AutoWired;
import com.github.hb.service.FaceService2;

public class Lol2 {

    @AutoWired(value = FaceService2.class)
    private FaceService2 faceService;

    public void work() {
        faceService.buy("德玛", 5);
    }

    public FaceService2 getFaceService() {
        return faceService;
    }

}
