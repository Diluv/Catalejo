package com.diluv.catalejo.minecraft.readers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.diluv.catalejo.reader.MetadataReader;

/**
 * This reader will search a file for certain indicators which can reveal
 * categorical information about the file. This is used to tell things like
 * which API the mod supports.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class ModTypeReader implements MetadataReader {

    /**
     * A constant instance, which can be used to save memory.
     */
    public static final MetadataReader MOD_TYPE_READER = new ModTypeReader();

    @Override
    public void readArchiveEntry (Map<String, Object> metadata, ZipFile file, ZipEntry entry) throws Exception {

        final String fileName = entry.getName();

        // mcmod.info file is used by Forge mods.
        // mods.toml is used by Forge 25 and up.
        if ("mcmod.info".equals(fileName) || "mods.toml".equals(fileName)) {
            this.setType(metadata, "forge");
        }

        // litemod.json is used by LiteLoader mods.
        else if ("litemod.json".equals(fileName)) {
            this.setType(metadata, "liteloader");
        }

        // fabric.mod.json is used by Fabric.
        else if ("fabric.mod.json".equals(entry.getName())) {
            this.setType(metadata, "fabric");
        }
        
        // This package structure is used by MCreator.
        else if (fileName.startsWith("mod/mcreator/mcreator_")) {
            this.setType(metadata, "mcreator");
        }
    }

    /**
     * Used to handle multiple types existing for a single file. Will add the
     * type flag to a set, and if the set does not exist a new one will be made.
     *
     * @param metadata The metadata map.
     * @param type The type to set.
     */
    private void setType (Map<String, Object> metadata, String type) {

        final Set<String> types = (Set<String>) metadata.getOrDefault("FileFlags", new HashSet<String>());
        types.add(type);
        metadata.put("FileFlags", types);
    }
}
