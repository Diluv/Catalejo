package net.diluv.catalejo.minecraft.readers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.diluv.catalejo.reader.MetadataReader;

public class ModTypeReader implements MetadataReader {

	public static final MetadataReader MOD_TYPE_READER = new ModTypeReader();
	
    @Override
    public void readArchiveEntry (Map<String, Object> metadata, ZipFile file, ZipEntry entry) {

        final String fileName = entry.getName();

        if ("mcmod.info".equals(fileName)) {
            this.setType(metadata, "forge");
        }
        else if ("litemod.json".equals(fileName)) {
            this.setType(metadata, "liteloader");
        }
        else if (fileName.startsWith("mod/mcreator/mcreator_")) {
            this.setType(metadata, "mcreator");
        }
    }

    private void setType (Map<String, Object> metadata, String type) {

        final Set<String> types = (Set<String>) metadata.getOrDefault("mcmodtypes", new HashSet<String>());
        types.add(type);
        metadata.put("mcmodtypes", types);
    }
}
