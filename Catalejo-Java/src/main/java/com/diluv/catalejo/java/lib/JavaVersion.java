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

    JAVA_1_2("Java 1.2", 46),
    JAVA_1_3("Java 1.3", 47),
    JAVA_1_4("Java 1.4", 48),
    JAVA_1_5("Java 5", 49),
    JAVA_1_6("Java 6", 50),
    JAVA_1_7("Java 7", 51),
    JAVA_1_8("Java 8", 52),
    JAVA_1_9("Java 9", 53);

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
