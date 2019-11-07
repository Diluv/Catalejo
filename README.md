# Catalejo
A Java library for analyzing files and learning metadata about them. 

## How to use?
To use Catalejo, you must first create a Catalejo instance. Once the instance has been created, you can add some of the various meta readers to it. 

```java
private final Catalejo catalejo = new Catalejo().add(MD5_READER, SHA_256_READER, SHA_512_READER, CRC_32_READER, ModTypeReader.MOD_TYPE_READER, JavaVersionReader.JAVA_VERSION_READER);
```

Once the Catalejo instance is set up, use the `Catalejo#readFile` method to read a file. 

```
    		File file = DataUtils.downloadFile(s.getUrl(), s.getFilename());
    		event.getMessage().delete();
    		final Map<String, Object> meta = new HashMap<>();
    		catalejo.readFileMeta(meta, file);  		
```

