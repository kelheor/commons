package com.academy.patterns.tolerantreader;

/**
 * Created by keos on 25.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Tolerant reader позволяет при изменении схемы коммуникаций не поломаться существующим читателям
        // При этом в данном примере мы вместо того, чтобы сериализовать объекты, сериализуем свойства в hashMapе
        // Таким образом, даже если нам придет более новый объект, старые методы отработают и получат нужные данные

        try {
            ProtocolV2 protocolV2 = new ProtocolV2("data1", "data2");
            byte[] data = TolerantReader.serializeV2(protocolV2);
            ProtocolV1 protocolV1 = TolerantReader.deserializeV1(data);
            System.out.println(protocolV1.getDataV1());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
