package com.diluv.catalejo.reader.files;

import java.io.File;
import java.util.Map;

import com.diluv.catalejo.reader.MetadataReader;

/**
 * A meta reader for reading the size of a file. Reads both the raw bytes, and the human
 * readable size.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class FileSizeReader implements MetadataReader {

    @Override
    public void readFile (Map<String, Object> metadata, File file, byte[] bytes) {

        final long size = file.length();

        metadata.put("Bytes", size);
        metadata.put("Size", getReadableFileSize(size));
    }

    /**
     * Gets a human readable file size from a byte size.
     *
     * @param bytes The size in bytes.
     * @return A human readable file size.
     */
    private static String getReadableFileSize (long bytes) {

        final int unit = 1024;

        if (bytes < unit) {
            return bytes + " B";
        }

        final int exp = (int) (Math.log(bytes) / Math.log(unit));
        final String pre = "KMGTPE".charAt(exp - 1) + "i";
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}
