package com.diluv.catalejo.processor;

import java.io.*;
import java.util.*;

/**
 * This interface is used to define an object that can process a file within the context of
 * this library, and read metadata from it. Both direct implementation and functional
 * interfaces are supported.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public interface MetadataReader {
    
    /**
     * Called when a file is being processed. This allows for metadata for the file to be learned,
     * and stored for later use.
     * 
     * @param metadata A map to contain all of the metadata that has been learned about the
     *        passed file. The key is the name of the data, and should be consistent. The value
     *        can be an arbitrary object, however objects that can be serialized make for the
     *        best experience.
     * @param file The file to process. This file should always exist, and should not be
     *        modified directly by the process.
     */
    void readFileMetadata (Map<String, Object> metadata, File file);
}
