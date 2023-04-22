/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shutup.softwaresecurityca;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.SecretKey;
import static shutup.softwaresecurityca.decrypt.decryptGivenKey;
import static shutup.softwaresecurityca.decrypt.decryptRandomKey;
import static shutup.softwaresecurityca.decrypt.readFileToString;
import static shutup.softwaresecurityca.encrypt.encrypt;
import static shutup.softwaresecurityca.encrypt.encryptWithKey;
import static shutup.softwaresecurityca.encrypt.generateKey1;

/**
 *
 * @author Frist
 */
public class Menu {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, Exception {
        Scanner sc = new Scanner(System.in);
        int keySize = 256;
        String answer1;

        //question
        System.out.println("Do you wish to add a File to Encrypt?   Y/N");
        answer1 = sc.nextLine();
        //if yes create file
        if (answer1.equalsIgnoreCase("Yes")) {
            System.out.println("What do you wish to Call the file?");
            String answer2 = sc.nextLine();
            File file = new File(answer2 + ".txt");
            FileWriter fw = new FileWriter(file);
            FileReader fr = new FileReader(file);
            System.out.println("What do you wish to add to the file ?");
            String answer3 = sc.nextLine();

            fw.write(answer3);
            fw.flush();
            fw.close();

            //now that file has been create encrypt it
            System.out.println("your file will now be encrypted, do you want to use your own key for encryption? if no the program will generate a random one");
            String answer4 = sc.nextLine();
            if (answer4.equalsIgnoreCase("Yes")) {
                System.out.println("What do you want your key to be, keep in mind the only possible keysizes are 1 byte(32 characters long) or half of 1 byte(16characters long)");
                String keyPersonal = sc.nextLine();
                String message = readFileToString(file);
                byte[] encrypted = encryptWithKey(message, keyPersonal);
                System.out.println("Encrypted message: " + new String(encrypted));
                //now decrypt
                System.out.println("do you wish to decrypt this file? Y/N");
                String answer5 = sc.nextLine();
                if (answer5.equalsIgnoreCase("Yes")) {
                    String decrypted = decryptGivenKey(encrypted, keyPersonal);
                    System.out.println("Decrypted message: " + decrypted);
                }
            } else {
                SecretKey secretKey = generateKey1(keySize);
                String message = readFileToString(file);
               
                    byte[] encrypted = encrypt(message, secretKey);
                System.out.println("Encrypted message: " + new String(encrypted));
                System.out.println("do you wish to decrypt this file? Y/N");
                String answer5 = sc.nextLine();
                if (answer5.equalsIgnoreCase("Yes")) {
                    String decrypted = decryptRandomKey(encrypted, secretKey);
                    System.out.println("Decrypted message: " + decrypted);
                    
            }

        }
    }

}
}
