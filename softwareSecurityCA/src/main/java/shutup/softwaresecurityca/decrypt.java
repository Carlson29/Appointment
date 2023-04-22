/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shutup.softwaresecurityca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class decrypt {

/**

decrypts the message provided with a given key .
@param encrypt the byte array to be decrypted .
@param key the encryption key used to encrypt the message.
@return the decrypted message as a String.
@throws NoSuchAlgorithmException if the specified encryption algorithm is not available.
@throws NoSuchPaddingException if the specified padding scheme is not available.
@throws InvalidKeyException if the specified key is invalid.
@throws IllegalBlockSizeException if the size of the input data is not a multiple of the block size.
@throws BadPaddingException if the padding is invalid or corrupted.
*/
public static String decryptGivenKey(byte[] encrypt, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
SecretKeySpec secretKeyDecrypt = new SecretKeySpec(key.getBytes(), "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, secretKeyDecrypt);
byte[] decryptedByte = cipher.doFinal(encrypt);
String message = new String(decryptedByte);
return message;
}
/**

Decrypts the given byte array using a randomly generated encryption key.

@param encrypt the byte array to be decrypted.

@param key the encryption key used to encrypt the message.

@return the decrypted message as a string.

@throws NoSuchAlgorithmException if the specified encryption algorithm is not available.

@throws NoSuchPaddingException if the specified padding scheme is not available.

@throws InvalidKeyException if the specified key is invalid.

@throws IllegalBlockSizeException if the size of the input data is not a multiple of the block size.

@throws BadPaddingException if the padding is invalid or corrupted.
*/
public static String decryptRandomKey(byte[] encrypt, SecretKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
SecretKeySpec secretKeyDecrypt = new SecretKeySpec(key.getEncoded(), "AES");
Cipher cipher = Cipher.getInstance("AES");

cipher.init(Cipher.DECRYPT_MODE, secretKeyDecrypt);
byte[] decryptedByte = cipher.doFinal(encrypt);
String message = new String(decryptedByte);
return message;
}

/**

Reads the cpmtent of the file to be read to String.

@param file the file to be read.

@return the content of the file as a string.

@throws IOException if an I/O error occurs while reading the file.
*/
public static String readFileToString(File file) throws IOException {
BufferedReader br = new BufferedReader(new FileReader(file));

StringBuilder sb = new StringBuilder();

String line;
while ((line = br.readLine()) != null) {
sb.append(line);
}
br.close();
return sb.toString();
}

}
