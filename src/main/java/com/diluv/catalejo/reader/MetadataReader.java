package com.diluv.catalejo.reader;

import java.io.File;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * This interface is used to define an object that can process a file within the
 * context of this library, and read metadata from it.
 *
 * @author Tyler Hancock (Darkhax)
 */
public interface MetadataReader {

    /**
     * Called when a file is being processed. This allows for metadata for the
     * file to be learned, and stored for later use.
     *
     * @param metadata A map to contain all of the metadata that has been
     *        learned about the passed file. The key is the name of the data,
     *        and should be consistent. The value can be an arbitrary object,
     *        however objects that can be serialized make for the best
     *        experience.
     * @param file The file to process. This file should always exist, and
     *        should not be modified directly by the read process.
     * @param bytes An array of the file's bytes. This is intended to be read
     *        only, and provide a way to learn metadata from the bytes of the
     *        file directly.
     * @throws Exception It is possible for an exception to be thrown by a
     *         reader. Exceptions should not be handled by the lib, as many
     *         programs will want to respond to these on their own.
     */
    default void readFile (Map<String, Object> metadata, File file, byte[] bytes) throws Exception {

    }

    /**
     * Called when the file is an archive, and for every file contained within.
     * This allows multiple readers to process the contents of an archive
     * without iterating through the entries independently.
     *
     * @param metadata A map to contain all of the metadata that has been
     *        learned about the passed file. The key is the name of the data,
     *        and should be consistent. The value can be an arbitrary object,
     *        however objects that can be serialized make for the best
     *        experience.
     * @param file The file to parent archive file. Metadata can be read from
     *        this as well, however this method is called for every archived
     *        file so keep that in mind. This should always exist, and should
     *        not bet modified directly by the read process.
     * @param entry The current entry being read. This is the intended file to
     *        read. It should always exist, and should not be modified directly
     *        by the read process.
     * @throws Exception It is possible for an exception to be thrown by a
     *         reader. Exceptions should not be handled by the lib, as many
     *         programs will want to respond to these on their own.
     */
    default void readArchiveEntry (Map<String, Object> metadata, ZipFile file, ZipEntry entry) throws Exception {

    }
}
