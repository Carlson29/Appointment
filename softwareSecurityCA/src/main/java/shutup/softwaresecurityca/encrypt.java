/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shutup.softwaresecurityca;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Frist
 */
public class encrypt {
    public static SecretKey generateKey1(int Key) throws NoSuchAlgorithmException{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(Key);
        SecretKey encryptionKey = keyGenerator.generateKey();
        return encryptionKey;
       
    }
    
    public static byte[] encryptWithKey(String message, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        return cipher.doFinal(message.getBytes());
    }
    
    public static byte[] encrypt(String message, SecretKey key) throws Exception{
        SecretKeySpec secretKey2 = new SecretKeySpec(key.getEncoded(),"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey2);
        
        return cipher.doFinal(message.getBytes());
    }
    public static int maxKeySize(String message) throws NoSuchAlgorithmException{
        return Cipher.getMaxAllowedKeyLength(message);
    }
    public static int maxKeySizeAES() throws NoSuchAlgorithmException{
        return Cipher.getMaxAllowedKeyLength("AES");
    }
   
    }
   
  

