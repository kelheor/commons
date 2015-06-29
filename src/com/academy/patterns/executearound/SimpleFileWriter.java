package com.academy.patterns.executearound;

import java.io.FileWriter;

/**
 * Created by keos on 29.06.15.
 */
public class SimpleFileWriter {

    public SimpleFileWriter(String filename, FileWriterAction writerAction)  {
        try(FileWriter writer = new FileWriter(filename)) {
            writerAction.write(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
