package method.affinecipher;

import java.util.Scanner;

/**
 *
 * @author Joy Pal & Prodip Sarkar
 */
public class Affinecipher {

    //Encryption Process
    
     static String encryptMessage(char[] msg, int a, int b) 
    {
        String cipher = "";
        for (int i = 0; i < msg.length; i++)
        {
            if (Character.isLetter(msg[i])) 
            {
                char base = Character.isUpperCase(msg[i]) ? 'A' : 'a';
                cipher = cipher
                        + (char) ((((a * (msg[i] - base)) + b) % 26) + base);
            } 
            else 
            {
                cipher += msg[i];
            }
        }
        return cipher;
    }

     //Decryption Process
     
    static String decryptCipher(String cipher, int a, int b) 
    {
        String msg = "";
        int a_inv = 0;
        int flag = 0;
        for (int i = 0; i < 26; i++) 
        {
            flag = (a * i) % 26;
            if (flag == 1) 
            {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++) 
        {
            if (Character.isLetter(cipher.charAt(i))) 
            {
                char base = Character.isUpperCase(cipher.charAt(i)) ? 'A' : 'a';
                msg = msg + (char) (((a_inv * 
                        ((cipher.charAt(i) - base + 26 - b) % 26)) + base));
            } 
            else
            {
                msg += cipher.charAt(i);
            }
        }
        return msg;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message to be encrypted:");
        String msg = scanner.nextLine();

        System.out.println("Enter the key values of a and b:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String cipherText = encryptMessage(msg.toCharArray(), a, b);
        System.out.println("Encrypted Message is : " + cipherText);

        System.out.println("Decrypted Message is: " + decryptCipher(cipherText, a, b));
    }

}
