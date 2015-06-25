package com.academy.patterns.tolerantreader;

/**
 * Created by keos on 25.06.15.
 */
public class ProtocolV2 extends ProtocolV1 {

    private String dataV2;

    public ProtocolV2(String dataV1) {
        super(dataV1);
    }

    public ProtocolV2(String dataV1, String dataV2) {
        super(dataV1);
        this.dataV2 = dataV2;
    }

    public String getDataV2() {
        return dataV2;
    }
}
