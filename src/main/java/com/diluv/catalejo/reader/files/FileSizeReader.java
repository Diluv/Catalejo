package com.diluv.catalejo.reader.files;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.diluv.catalejo.reader.MetadataReader;

/**
 * A meta reader for reading the size of a file. Reads both the raw bytes, and
 * the human readable size.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class FileSizeReader implements MetadataReader {

    @Override
    public void readFile (Map<String, Object> metadata, File file, byte[] bytes) throws Exception {

        final long size = file.length();

        metadata.put("Bytes", size);
        metadata.put("Size", FileUtils.byteCountToDisplaySize(size));
    }
}
