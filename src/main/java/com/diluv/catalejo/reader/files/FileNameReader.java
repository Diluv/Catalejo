package com.diluv.catalejo.reader.files;

import java.io.File;
import java.util.Map;

import com.diluv.catalejo.reader.MetadataReader;

/**
 * A meta reader for reading the name of a file. Does the name of the file, and the extension.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class FileNameReader implements MetadataReader {

    @Override
    public void readFile (Map<String, Object> metadata, File file, byte[] bytes) {

        final String name = file.getName();

        metadata.put("FileName", name);
        metadata.put("Extension", this.getExtension(name));
    }

    /**
     * Gets the extension of a file from the file name.
     *
     * @param fileName The file name.
     * @return The extension for the file. N/A means it has no extension.
     */
    private String getExtension (String fileName) {

        final int lastPeriodIndex = fileName.lastIndexOf('.');
        final int lastSlashIndex = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
        return lastPeriodIndex > lastSlashIndex ? fileName.substring(lastPeriodIndex + 1) : "N/A";
    }
}
