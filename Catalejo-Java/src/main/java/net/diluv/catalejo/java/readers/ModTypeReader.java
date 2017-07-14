package net.diluv.catalejo.java.readers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.diluv.catalejo.reader.MetadataReader;

public class ModTypeReader implements MetadataReader {

	@Override
	public void readArchiveEntry (Map<String, Object> metadata, ZipFile file, ZipEntry entry) {
		
		final String fileName = entry.getName();
		
		if ("mcmod.info".equals(fileName)) {
			
			setType(metadata, "forge");
		}
		
		else if ("litemod.json".equals(fileName)) {
			
			setType(metadata, "liteloader");
		}
		
		else if (fileName.startsWith("mod/mcreator/mcreator_")) {
			
			setType(metadata, "mcreator");
		}
    }
	
	private void setType(Map<String, Object> metadata, String type) {
		
		Set<String> types = (Set<String>) metadata.getOrDefault("mcmodtypes", new HashSet<String>());
		types.add(type);
		metadata.put("mcmodtypes", types);
	}
}
