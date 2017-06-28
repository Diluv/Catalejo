package com.diluv.catalejo;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.diluv.catalejo.reader.MetadataReader;

/**
 * This is the main class for using Catalejo. To use Catalejo, a Catalejo instance must first
 * be constructed. Once the instance has been constructed, various readers can be added using
 * {@link #add(MetadataReader)}. There are also several methods which can be used to add entire
 * categories of provided readers. Once the instance has been configured to your needs,
 * {@link #readFileMeta(Map, File)} can be used to learn metadata about a file.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class Catalejo {

    /**
     * A list of readers used by the Catalejo instance.
     */
    private final List<MetadataReader> readers = new ArrayList<>();

    /**
     * Gets a list of all the readers used by the instance. Please use
     * {@link #add(MetadataReader)} and {@link #addAll(Collection)} to add readers.
     *
     * @return A list of all the readeres used by the instance.
     */
    public List<MetadataReader> getReaders () {

        return this.readers;
    }

    /**
     * Adds a reader to the instance.
     *
     * @param reader The reader to add.
     * @return The Catalejo instance.
     */
    public Catalejo add (MetadataReader reader) {

        this.readers.add(reader);
        return this;
    }

    /**
     * Adds an entire collection of readers to the instance.
     *
     * @param readers The collection of readers to add.
     * @return The Catalejo instance.
     */
    public Catalejo addAll (Collection<MetadataReader> readers) {

        readers.addAll(readers);
        return this;
    }

    /**
     * Reads the file metadata for the passed file. Handles the delegation of the file to all
     * the readers. The metadata that is learned is added to the metadata map.
     *
     * @param metadata A map to contain metadata that is learned.
     * @param file The file to read metadata from.
     */
    public void readFileMeta (Map<String, Object> metadata, File file) {

        // Exit if the file does not exist!
        if (!file.exists()) {
            return;
        }

        try {

            final byte[] bytes = Files.readAllBytes(file.toPath());

            // Handle main level file readers
            for (final MetadataReader reader : this.getReaders()) {
                reader.readFile(metadata, file, bytes);
            }
        }

        catch (final IOException e1) {

            // TODO add a logger
            e1.printStackTrace();
        }

        // Handles reading zip archive files
        if (isValidZip(file)) {
            try (ZipFile zip = new ZipFile(file)) {

                if (zip != null) {

                    final Enumeration<? extends ZipEntry> entries = zip.entries();

                    while (entries.hasMoreElements()) {

                        final ZipEntry entry = entries.nextElement();

                        for (final MetadataReader reader : this.getReaders()) {
                            reader.readArchiveEntry(metadata, zip, entry);
                        }
                    }
                }
            }

            catch (final IOException e) {

                // TODO add a logger
                e.printStackTrace();
            }
        }
    }

    /**
     * Checks if a File is a valid zip archive for the archive metadata readers.
     *
     * @param file The file to test.
     * @return Whether or not the file is a valid zip archive.
     */
    private static boolean isValidZip (File file) {

        // Directories, files that can't be read, and files smaller than 1byte are not valid.
        if (!file.isDirectory() && file.canRead() && !(file.length() < 4)) {
            try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {

                // Checks for the right signature. We only care about zip archives which are
                // not empty or spanned.
                return in.readInt() == 0x504b0304;
            }

            catch (final IOException e) {

                // TODO logger
            }
        }

        return false;
    }
}
