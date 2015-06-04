package com.academy.utils;

import java.io.*;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Утилиты трансфера объектов
 *
 * @author rnazirov
 */
public class TransferUtil {


    /**
     * Сериализация и сжатие объекта
     *
     * @param object Объект
     * @return data Данные
     * @throws Exception
     */
    public static byte[] serializeAndCompress(Object object) throws Exception {
        return compress(serialize(object));
    }

    /**
     * Распаковка и десериализация объекта
     *
     * @param data Данные
     * @return Объект
     * @throws Exception
     */
    public static Object decompressAndDecerialize(byte[] data) throws Exception {
        return deserialize(decompress(data));
    }

    /**
     * Сериализация объекта
     *
     * @param object Сериализуемые данные
     * @return data Сериализованные данные
     * @throws Exception Ошибка сериализации данных
     */
    public static byte[] serialize(Object object) throws Exception {
        ByteArrayOutputStream bos = null;
        ObjectOutput out = null;
        try {

            // Сериализация
            bos = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bos);

            out.writeObject(object);
            byte[] data = bos.toByteArray();

            out.close();
            bos.close();

            return data;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * Сжатие объекта
     *
     * @param data Сжимаемые данные
     * @return object Сжатые данные
     * @throws Exception Ошибка сжатия данных
     */
    public static byte[] compress(byte[] data) throws Exception {
        ByteArrayOutputStream bos = null;
        GZIPOutputStream gos = null;
        try {

            // Сжатие
            bos = new ByteArrayOutputStream();
            gos = new GZIPOutputStream(bos);

            gos.write(data);

           gos.close();
            bos.close();

            return bos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Десериализация объекта
     *
     * @param data Сериализованные данные
     * @return object Объект
     * @throws Exception Ошибка десериализации данных
     */
    public static Object deserialize(byte[] data) throws Exception {
        ByteArrayInputStream bis = null;
        ObjectInput in = null;
        try {

            // Десериализация
            bis = new ByteArrayInputStream(data);
            in = new ObjectInputStream(bis);

            Object object = in.readObject();

            in.close();
            bis.close();

            return object;

        } catch (Exception e) {
            //LOG.error("Ошибка десериализации объекта: " + e.getMessage(), e);
            throw e;
        }
    }

    public static HashMap<ZipEntry, ByteArrayOutputStream> unzip(int bufferSize, String zipExtension,
                                                                 ByteArrayOutputStream zippedFileOS) {
        try {

            ZipInputStream inputStream = new ZipInputStream(
                    new BufferedInputStream(new ByteArrayInputStream(
                            zippedFileOS.toByteArray())));

            ZipEntry entry;

            HashMap<ZipEntry, ByteArrayOutputStream> result = new HashMap<ZipEntry, ByteArrayOutputStream>();
            while ((entry = inputStream.getNextEntry()) != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.out.println("\tExtracting entry: " + entry);
                int count;
                byte data[] = new byte[bufferSize];

                if (!entry.isDirectory()) {
                    BufferedOutputStream out = new BufferedOutputStream(
                            outputStream, bufferSize);
                    while ((count = inputStream.read(data, 0, bufferSize)) != -1) {
                        out.write(data, 0, count);
                    }
                    out.flush();
                    out.close();
                    // recursively unzip files
                    if (entry.getName().toLowerCase().endsWith(zipExtension)) {
                        result.putAll(unzip(bufferSize, zipExtension, outputStream));
                    } else {
                        result.put(entry, outputStream);
                    }
                }

                outputStream.close();
            }
            inputStream.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Распаковка объекта
     *
     * @param compressedData Сжатые данные
     * @return data Распакованные данные
     * @throws Exception Ошибка сжатия данных
     */
    public static byte[] decompress(byte[] compressedData) throws Exception {
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        GZIPInputStream gis = null;
        try {

            // Распаковка
            bos = new ByteArrayOutputStream();
            bis = new ByteArrayInputStream(compressedData);
            gis = new GZIPInputStream(bis);
            byte[] buffer = new byte[4096];
            int n;
            while ((n = gis.read(buffer)) >= 0) {
                bos.write(buffer, 0, n);
            }

            gis.close();
            bos.close();
            bis.close();

            return bos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }


    }


}
