package com.diluv.catalejo.java.readers;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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
            this.addJavaVersion(metadata, this.getVersion(new DataInputStream(file.getInputStream(entry))));
        }
    }

    /**
     * Gets a version string from a class file stream.
     *
     * @param in The input stream.
     * @return The version read. The invalid string is used for when an invalid
     *         class is read.
     */
    private String getVersion (DataInputStream in) {

        try {

            final int magic = in.readInt();

            if (magic != 0xcafebabe) {
                return "invalid";
            }

            final int minor = in.readUnsignedShort();
            final int major = in.readUnsignedShort();
            return major + "." + minor;
        }

        catch (final IOException e) {

        }

        return "invalid";
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