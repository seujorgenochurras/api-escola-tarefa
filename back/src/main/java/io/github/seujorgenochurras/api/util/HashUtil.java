package io.github.seujorgenochurras.api.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String toSHA1(byte[] str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "null";
        }
        assert md != null;
        return StringUtils.byteArrayToHexString(md.digest(str));
    }
}
