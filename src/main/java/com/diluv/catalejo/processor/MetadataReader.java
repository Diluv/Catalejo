package com.diluv.catalejo.processor;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * This interface is used to define an object that can process a file within the context of
 * this library, and read metadata from it.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public interface MetadataReader {
    
    /**
     * Called when a file is being processed. This allows for metadata for the file to be
     * learned, and stored for later use.
     * 
     * @param metadata A map to contain all of the metadata that has been learned about the
     *        passed file. The key is the name of the data, and should be consistent. The value
     *        can be an arbitrary object, however objects that can be serialized make for the
     *        best experience.
     * @param file The file to process. This file should always exist, and should not be
     *        modified directly by the read process.
     */
    default void readFileMetadata (Map<String, Object> metadata, File file) {
        
    }
    
    /**
     * Called when the file is an archive, and for every file contained within. This allows
     * multiple readers to process the contents of an archive without iterating through the
     * entries independently.
     * 
     * @param metadata A map to contain all of the metadata that has been learned about the
     *        passed file. The key is the name of the data, and should be consistent. The value
     *        can be an arbitrary object, however objects that can be serialized make for the
     *        best experience.
     * @param file The file to parent archive file. Metadata can be read from this as well,
     *        however this method is called for every archived file so keep that in mind. This
     *        should always exist, and should not bet modified directly by the read process.
     * @param entry The current entry being read. This is the intended file to read. It should
     *        always exist, and should not be modified directly by the read process.
     */
    default void readArchiveMetadata (Map<String, Object> metadata, ZipFile file, ZipEntry entry) {
        
    }
}
