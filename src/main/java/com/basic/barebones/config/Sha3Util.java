package com.basic.barebones.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha3Util {
    public static byte[] digest(byte[] userPassword){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA3-256");
        }catch(NoSuchAlgorithmException e){
            throw new IllegalArgumentException(e);
        }
        return md.digest(userPassword);
    }

    public static String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
