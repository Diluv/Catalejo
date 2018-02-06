package com.diluv.catalejo.java.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.diluv.catalejo.Catalejo;
import com.diluv.catalejo.java.readers.JavaVersionReader;

public class TestJava {

    @Test
    public void testVersion () throws Exception {

        final Catalejo reader = new Catalejo().add(JavaVersionReader.JAVA_VERSION_READER);

        final File file = new File("src/test/Bookshelf-1.12.2-2.3.523.jar");

        final Map<String, Object> map = new HashMap<>();
        reader.readFileMeta(map, file);

        final Set<String> version = (Set<String>) map.get("JavaVersions");
        Assert.assertTrue(version.contains("Java 8"));
    }
}