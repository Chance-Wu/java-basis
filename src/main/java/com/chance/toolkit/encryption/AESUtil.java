package com.chance.toolkit.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author: chance
 * @date: 2022/6/27 09:38
 * @since: 1.0
 */
public class AESUtil {

    static byte[] key = "w@#$4@#$s^&3*&^4".getBytes();
    final static String algorithm = "AES";

    public static String encrypt(String data) {

        byte[] dataToSend = data.getBytes();
        Cipher c = null;
        try {
            c = Cipher.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SecretKeySpec k = new SecretKeySpec(key, algorithm);
        try {
            c.init(Cipher.ENCRYPT_MODE, k);
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] encryptedData = "".getBytes();
        try {
            encryptedData = c.doFinal(dataToSend);
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] encryptedByteValue = Base64.getEncoder().encode(encryptedData);
        return new String(encryptedByteValue);
    }

    public static String decrypt(String data) {

        byte[] encryptedData = Base64.getDecoder().decode(data);
        Cipher c = null;
        try {
            c = Cipher.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SecretKeySpec k =
                new SecretKeySpec(key, algorithm);
        try {
            c.init(Cipher.DECRYPT_MODE, k);
        } catch (InvalidKeyException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        byte[] decrypted = null;
        try {
            decrypted = c.doFinal(encryptedData);
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new String(decrypted);
    }

    public static void main(String[] args) {
        String password = encrypt("12233440988:1239874389888:dd333");
        System.out.println(password);
        System.out.println(decrypt(password));
    }
}
