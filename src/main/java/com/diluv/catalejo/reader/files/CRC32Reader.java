package com.diluv.catalejo.reader.files;

import java.io.File;
import java.util.Map;
import java.util.zip.CRC32;

import com.diluv.catalejo.reader.MetadataReader;

public class CRC32Reader implements MetadataReader {

    @Override
    public void readFile (Map<String, Object> data, File file, byte[] bytes) {

        final CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        data.put("CRC32", Long.toHexString(crc32.getValue()));
    }
}
