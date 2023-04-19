/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shutup.softwaresecurityca;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Frist
 */
public class decrypt {
    
    
    
    public static String decrypt2(byte[] encrypt , SecretKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
         SecretKeySpec secretKeyDecrypt = new SecretKeySpec(key.getEncoded(),"AES");
         Cipher cipher = Cipher.getInstance("AES");
         cipher.init(Cipher.DECRYPT_MODE, secretKeyDecrypt);
        byte[] decryptedByte = cipher.doFinal(encrypt);
      String message = new String(decryptedByte);
        return message;
    }
     
        
    }

