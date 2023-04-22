/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package shutup.softwaresecurityca;

import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import static shutup.softwaresecurityca.decrypt.decryptGivenKey;
//import static shutup.softwaresecurityca.decrypt.decrypt2;
import static shutup.softwaresecurityca.encrypt.encrypt;
import static shutup.softwaresecurityca.encrypt.encryptWithKey;
import static shutup.softwaresecurityca.encrypt.generateKey1;
import static shutup.softwaresecurityca.encrypt.maxKeySize;
import static shutup.softwaresecurityca.encrypt.maxKeySizeAES;

/**
 *
 * @author Frist
 */
public class AesEncryptionMethodTesting {
//byte is 2 hex characters

    public static void main(String[] args) throws NoSuchAlgorithmException, Exception , BadPaddingException{
        int keySize = 256; //used to define key Size for generating a key method. possible key sizes are 128, 192, and 256 bits.
        String message = "this is a secret ";
        String message2 = "test key";
        String key = "0123456789abcdef0123456789abcdef";

        SecretKey secretKey = generateKey1(keySize);

        System.out.println(secretKey);

        System.out.println("/////");

        byte[] encrypted = encryptWithKey(message, key);
        System.out.println("Encrypted message: " + new String(encrypted));

        System.out.println("/////");

        byte[] encrypted2 = encrypt(message2, secretKey);
        System.out.println("Encrypted message TEST LOL: " + new String(encrypted2));

        System.out.println("/////");

        System.out.println(maxKeySize(message));

        System.out.println("/////");

        System.out.println(maxKeySizeAES());
         System.out.println("/////");
          System.out.println("/////");
          
          
          
          String decrypted = decryptGivenKey(encrypted, key) ;
        System.out.println("Decrypted message: " + decrypted);
          

        //if(maxKeySizeAES() == ){
        //  System.out.println("true");
    }
}
