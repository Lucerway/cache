package com.lucer.leetcode;

/**
 * @author: liuchuan
 */
public class XORCrypto {
    private byte[] keyBytes; // 密钥
    private int k;

    public XORCrypto(String key) {
        keyBytes = key.getBytes();
        k = keyBytes.length;
    }

    private String coding(String message) {
        byte[] origin = message.getBytes();
        byte[] master = new byte[origin.length];
        for (int i = 0, len = origin.length; i < len; i++) {
            master[i] = (byte) (origin[i] ^ keyBytes[i % k]);
        }
        return new String(master);
    }

    public String encoding(String plaintext) {
        return coding(plaintext);
    }

    public String decoding(String cipherText) {
        return coding(cipherText);
    }

    public static void main(String[] args) {
        String name = "AngelaBaby";
        String key = "1989-2-28";

        XORCrypto crypto = new XORCrypto(key);
        String cipherText = crypto.encoding(name); // 将name加密成密文
        String plaintext = crypto.decoding(cipherText); // 解密
        System.out.println(cipherText);
        System.out.println(plaintext);
    }

}
