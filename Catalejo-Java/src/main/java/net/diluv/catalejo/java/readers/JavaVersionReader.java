package net.diluv.catalejo.java.readers;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.diluv.catalejo.reader.MetadataReader;

public class JavaVersionReader implements MetadataReader {

    @Override
    public void readArchiveEntry (Map<String, Object> metadata, ZipFile file, ZipEntry entry) {

        try {

            if (entry.getName().endsWith(".class")) {

                this.addJavaVersion(metadata, this.getVersion(new DataInputStream(file.getInputStream(entry))));
            }
        }

        catch (final IOException e) {

        }
    }

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

    private void addJavaVersion (Map<String, Object> metadata, String type) {

        final Set<String> types = (Set<String>) metadata.getOrDefault("JavaVersions", new HashSet<String>());
        types.add(type);
        metadata.put("JavaVersions", types);
    }
}