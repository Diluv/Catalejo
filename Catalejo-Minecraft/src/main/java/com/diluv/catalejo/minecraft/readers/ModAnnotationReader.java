package com.diluv.catalejo.minecraft.readers;

import java.io.InputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.diluv.catalejo.minecraft.asm.ModClassVisitor;
import com.diluv.catalejo.reader.MetadataReader;

/**
 * This reader will look for class files, and then search them for relevant
 * annotations.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class ModAnnotationReader implements MetadataReader {

    /**
     * A constant instance, which can be used to save memory.
     */
    public static final ModAnnotationReader MOD_ANNOTATION_READER = new ModAnnotationReader();

    @Override
    public void readArchiveEntry (Map<String, Object> metadata, ZipFile file, ZipEntry entry) throws Exception {

        // Mac OSX thumbprint files are very annoying.
        if (entry.getName().startsWith("__MACOSX")) {
            return;
        }

        // Basic filter based on file name.
        if (!entry.getName().endsWith(".class")) {
            return;
        }

        // Passes the input stream to the ASM reader.
        try (InputStream stream = file.getInputStream(entry)) {

            ModClassVisitor.readClassFile(metadata, stream);
        }
    }
}
