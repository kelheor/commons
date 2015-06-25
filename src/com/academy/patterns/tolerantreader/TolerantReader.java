package com.academy.patterns.tolerantreader;

import com.academy.utils.TransferUtil;

import java.util.HashMap;

/**
 * Created by keos on 25.06.15.
 */
public class TolerantReader {

    public static byte[] serializeV1(ProtocolV1 protocolV1) throws Exception {
        HashMap<String, String> data = new HashMap<>();
        data.put("dataV1", protocolV1.getDataV1());
        return TransferUtil.serialize(data);
    }

    public static byte[] serializeV2(ProtocolV2 protocolV2) throws Exception {
        HashMap<String, String> data = new HashMap<>();
        data.put("dataV1", protocolV2.getDataV1());
        data.put("dataV2", protocolV2.getDataV2());
        return TransferUtil.serialize(data);
    }

    public static ProtocolV1 deserializeV1(byte[] protocolV1) throws Exception {
        HashMap<String, String> data = (HashMap<String, String>) TransferUtil.deserialize(protocolV1);
        return new ProtocolV1(data.get("dataV1"));
    }

    public static ProtocolV1 deserializeV2(byte[] protocolV2) throws Exception {
        HashMap<String, String> data = (HashMap<String, String>) TransferUtil.deserialize(protocolV2);
        return new ProtocolV2(data.get("dataV1"), data.get("dataV2"));
    }
}
