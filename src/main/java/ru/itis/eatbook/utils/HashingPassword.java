package ru.itis.eatbook.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPassword {
    public static String hashing(String password) {
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            for (byte b : bytes) {
                builder.append(String.format("%02X", b));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
        return builder.toString();
    }
}
