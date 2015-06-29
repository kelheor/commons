package com.academy.patterns.executearound;

import java.io.FileWriter;

/**
 * Created by keos on 29.06.15.
 */
public interface FileWriterAction {
    void write(FileWriter fileWriter) throws Exception;
}
