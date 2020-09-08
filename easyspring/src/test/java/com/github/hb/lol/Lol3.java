package com.github.hb.lol;

import com.github.hb.AutoWired;
import com.github.hb.service.FaceService2;

public class Lol3 {

    @AutoWired(name="face")
    private FaceService2 faceService;

    public void work() {
        faceService.buy("瞎子", 5);
    }

    public FaceService2 getFaceService() {
        return faceService;
    }

}
