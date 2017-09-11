package com.diluv.catalejo.reader.files;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import com.diluv.catalejo.reader.MetadataReader;

/**
 * A meta reader for reading the hash of a file. This reader uses java.security.MessageDigest
 * to digest the file's bytes to generate a hash. Any hash generated will be converted to a hex
 * string.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class HashDigestReader implements MetadataReader {

    /**
     * The name of the hash algorithm. Java officially supports MD5, SHA-1 and SHA-256.
     */
    private final String algorithm;

    /**
     * The MessageDigest instance.
     */
    private final MessageDigest digest;

    /**
     * Constructs a new instance.
     *
     * @param algorithm The name of the algorithm to use. See {@link #algorithm} for more info.
     */
    public HashDigestReader (String algorithm) {

        this.algorithm = algorithm;
        this.digest = getDigest(algorithm);
    }

    @Override
    public void readFile (Map<String, Object> data, File file, byte[] bytes) {

        data.put(this.algorithm, DatatypeConverter.printHexBinary(this.digest.digest(bytes)).toLowerCase());
    }

    /**
     * Gets a MessageDigest instance for an algorithm name. See {@link #algorithm} for more info.
     *
     * @param algorithm The algorithm to use. See {@link #algorithm}.
     * @return The MessageDigest instance. Hopefully it's not null!
     */
    private static MessageDigest getDigest (String algorithm) {

        try {

            return MessageDigest.getInstance(algorithm);
        }

        catch (final NoSuchAlgorithmException e) {

            // TODO add logger
            e.printStackTrace();
        }

        return null;
    }
}
