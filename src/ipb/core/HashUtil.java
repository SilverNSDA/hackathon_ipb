/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author SIlver
 */
public class HashUtil {
    public static String ApplySHA256(String input) throws NoSuchAlgorithmException{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexStr = new StringBuilder();
            for (byte h:hash){
                String hex = Integer.toHexString(0xff & h);
                if(hex.length()==1) hexStr.append('0');
                hexStr.append(hex);
            }
            return hexStr.toString();
        
    }
    
}
