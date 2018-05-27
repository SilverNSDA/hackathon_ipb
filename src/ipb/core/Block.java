/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.core;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author SIlver
 */
public class Block {
    public enum BlockState { Inactive, Active, Claimed, Rejected }
    public String hash;
    public String pHash;
    public String data;
    public BlockState state;
    private final long timeStamp;
    
    public Block(String data, String pHash, BlockState s) throws NoSuchAlgorithmException{
        this.data = data;
        this.pHash = pHash;
        state =s;
        this.timeStamp= new Date().getTime();
//        try {
//            this.data = this.DataEncrypt();
//        } catch (NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | ShortBufferException | IllegalBlockSizeException | BadPaddingException ex) {
//            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
//        }
        this.hash = Hash();
    }
    public final String Hash() throws NoSuchAlgorithmException {
        return HashUtil.ApplySHA256(pHash+Long.toString(timeStamp)+data);
    }
    public final String DataEncrypt() 
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException{
        byte[] input = data.getBytes();
        byte[] key = HashUtil.ApplySHA256("abcd").getBytes();  
        byte[] ivKey =  HashUtil.ApplySHA256("bcde").getBytes();
        
        SecretKeySpec k = new SecretKeySpec(key,"DES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivKey);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, k, ivSpec);
        byte[] encrypted = new byte[cipher.getOutputSize(input.length)];
        int enc_len = cipher.update(ivKey, 0, input.length, encrypted, 0);
        enc_len+=cipher.doFinal(encrypted, enc_len);
        return Arrays.toString(encrypted);
        
    }
    public String DataDecrypt() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException{
        byte[] input = data.getBytes();
        byte[] key = HashUtil.ApplySHA256("abcd").getBytes();  
        byte[] ivKey =  HashUtil.ApplySHA256("bcde").getBytes();
        
        SecretKeySpec k = new SecretKeySpec(key,"DES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivKey);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, k, ivSpec);
        byte[] decrypted = new byte[cipher.getOutputSize(input.length)];
        int dec_len = cipher.update(ivKey, 0, input.length, decrypted, 0);
        dec_len+=cipher.doFinal(decrypted, dec_len);
        return Arrays.toString(decrypted);
    }
    
    public void Inactivate(){
        if(state!=BlockState.Claimed&&state!=BlockState.Rejected)
            state = BlockState.Inactive;
    }
    public void Activate(){
        if(state!=BlockState.Claimed&&state!=BlockState.Rejected)
            state = BlockState.Active;
    }
    
    public void Claim(){
        if(state==BlockState.Active)
            state = BlockState.Claimed;
    }
    public void Reject(){
        if(state==BlockState.Active)
            state = BlockState.Rejected;
    }
    
}
