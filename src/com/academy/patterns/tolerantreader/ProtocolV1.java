package com.academy.patterns.tolerantreader;

import java.io.Serializable;

/**
 * Created by keos on 25.06.15.
 */
public class ProtocolV1 implements Serializable {

    private String dataV1;

    public ProtocolV1(String dataV1) {
        this.dataV1 = dataV1;
    }

    public String getDataV1() {
        return dataV1;
    }
}
