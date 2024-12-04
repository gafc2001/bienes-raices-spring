package com.example.demo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Util {
    public static String generateFileHash(MultipartFile file) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(file.getBytes());
        return HexFormat.of().formatHex(hashBytes) + getFileExtension(file.getOriginalFilename());
    }

    private static String getFileExtension(String filename) {
        int lastIndexOfDot = filename.lastIndexOf(".");
        return lastIndexOfDot != -1 ? filename.substring(lastIndexOfDot) : "";
    }
}
