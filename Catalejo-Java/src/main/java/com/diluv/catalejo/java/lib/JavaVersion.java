package com.diluv.catalejo.java.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * A basic enumeration that allows for java variables to be mapped to their
 * major version number.
 *
 * @author Tyler Hancock (Darkhax)
 */
public enum JavaVersion {

    JAVA_1_1("JDK 1.1", 0x2D),
    JAVA_1_2("JDK 1.2", 0x2E),
    JAVA_1_3("JDK 1.3", 0x2F),
    JAVA_1_4("JDK 1.4", 0x30),
    JAVA_1_5("Java SE 5.0", 0x31),
    JAVA_1_6("Java SE 6.0", 0x32),
    JAVA_1_7("Java SE 7", 0x33),
    JAVA_1_8("Java SE 8", 0x34),
    JAVA_1_9("Java SE 9", 0x35),
    JAVA_1_10("Java SE 10", 0x36),
    JAVA_1_11("Java SE 11", 0x37),
    JAVA_1_12("Java SE 12", 0x38),
    JAVA_1_13("Java SE 13", 0x39),
    JAVA_1_14("Java SE 14", 0x3A);

    /**
     * A map of version numbers to localizations.
     */
    private static final Map<Integer, String> VERSION_TO_LOCAL = new HashMap<>();

    /**
     * A map of localizations to version numbers.
     */
    private static final Map<String, Integer> LOCAL_TO_VERSION = new HashMap<>();

    static {

        for (final JavaVersion version : JavaVersion.values()) {

            VERSION_TO_LOCAL.put(version.getNumber(), version.getLocal());
            LOCAL_TO_VERSION.put(version.getLocal(), version.getNumber());
        }
    }

    /**
     * Gets a localization for a major version integer.
     *
     * @param version The major version number.
     * @return The localization value.
     */
    public static String getLocal (int version) {

        final String local = VERSION_TO_LOCAL.get(version);
        return local == null ? "unknown" : local;
    }

    /**
     * The localization.
     */
    private final String local;

    /**
     * The major version number.
     */
    private final int number;

    JavaVersion (String local, int number) {

        this.local = local;
        this.number = number;
    }

    /**
     * Gets the localization.
     *
     * @return The localization.
     */
    public String getLocal () {

        return this.local;
    }

    /**
     * Gets the major version number.
     *
     * @return The major version number.
     */
    public int getNumber () {

        return this.number;
    }
}
