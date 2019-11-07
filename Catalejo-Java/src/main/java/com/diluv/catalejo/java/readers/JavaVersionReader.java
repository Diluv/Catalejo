package com.diluv.catalejo.java.readers;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.diluv.catalejo.java.lib.JavaVersion;
import com.diluv.catalejo.reader.MetadataReader;

/**
 * This reader can scan Java class files, and determine which version of Java
 * they were compiled with.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class JavaVersionReader implements MetadataReader {

    /**
     * A constant instance, which can be used to save memory.
     */
    public static final MetadataReader JAVA_VERSION_READER = new JavaVersionReader();

    @Override
    public void readArchiveEntry (Map<String, Object> metadata, ZipFile file, ZipEntry entry) throws Exception {

        if (entry.getName().endsWith(".class")) {

            try (InputStream input = file.getInputStream(entry); DataInputStream dataStream = new DataInputStream(input)) {

                this.getVersion(metadata, dataStream);
            }
        }
    }

    /**
     * Attempts to get the Java version for a class.
     *
     * @param metadata The metadata to put the found version in.
     * @param in The input stream for the class file.
     * @throws IOException It's possible for the stream to have issues. The lib
     *         will not swallow this exception.
     */
    private void getVersion (Map<String, Object> metadata, DataInputStream in) throws IOException {

        final int magic = in.readInt();

        if (magic == 0xcafebabe) {

            // Read the minor version, but ignore it.
            in.readUnsignedShort();

            final int major = in.readUnsignedShort();

            this.addJavaVersion(metadata, JavaVersion.getLocal(major));
        }
    }

    /**
     * Safely adds a Java version to the set of known java versions for a
     * project.
     *
     * @param metadata The metadata to add the version to.
     * @param type The Java version type.
     */
    private void addJavaVersion (Map<String, Object> metadata, String type) {

        final Set<String> types = (Set<String>) metadata.getOrDefault("JavaVersions", new HashSet<String>());
        types.add(type);
        metadata.put("JavaVersions", types);
    }
}