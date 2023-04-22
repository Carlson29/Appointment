/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shutup.softwaresecurityca;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class encrypt {

    /**
     * Generates a new AES encryption key with the specified key size.
     *
     * @param keySize The size of the key to be generated, in bits.
     * @return The generated encryption key.
     * @throws NoSuchAlgorithmException if the AES encryption algorithm is not
     * available.
     */
    public static SecretKey generateKey1(int keySize) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(keySize);
        SecretKey encryptionKey = keyGenerator.generateKey();
        return encryptionKey;
    }

    /**
     * Encrypts the given message using the specified key.
     *
     * @param message The message to be encrypted.
     * @param key The key to be used for encryption.
     * @return The encrypted message as a byte array.
     *
     */
    public static byte[] encrypt(String message, SecretKey key) throws Exception {
        SecretKeySpec secretKey2 = new SecretKeySpec(key.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey2);
        return cipher.doFinal(message.getBytes());
    }

    /**
     * Encrypts the given message using the specified key string.
     *
     * @param message The message to be encrypted.
     * @param key The key string to be used for encryption.
     * @return The encrypted message as a byte array.
     *
     */
    public static byte[] encryptWithKey(String message, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(message.getBytes());
    }

    /**
     *
     * @param algorithm The name of the encryption algorithm.
     * @return The maximum allowed key size for the specified encryption
     * algorithm, in bits.
     * @throws NoSuchAlgorithmException if the specified encryption algorithm is
     * not available.
     */
    public static int maxKeySize(String algorithm) throws NoSuchAlgorithmException {
        return Cipher.getMaxAllowedKeyLength(algorithm);
    }

    /**
     *
     * @return The maximum allowed key size for the AES encryption algorithm, in
     * bits.
     * @throws NoSuchAlgorithmException if the AES encryption algorithm is not
     * available.
     */
    public static int maxKeySizeAES() throws NoSuchAlgorithmException {
        return Cipher.getMaxAllowedKeyLength("AES");
    }

}
