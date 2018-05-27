/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.core;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author SIlver
 */
public class IpbCore {

    /**
     * @param args the command line arguments
     * @throws java.security.NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
//        Block b1 = new Block(new Data(new SmartContract("1st Block",150)),"0");
//        Block b2 = new Block(new Data(new SmartContract("2nd block",100)),b1.hash);
//        Block b3 = new Block(new Data(new SmartContract("3rd block",250)),b2.hash);
        Block b1 = new Block("1st Block","0", Block.BlockState.Active);
        Block b2 = new Block("2nd block",b1.hash, Block.BlockState.Active);
        Block b3 = new Block("3rd block",b2.hash, Block.BlockState.Active);
        System.out.println(b1.hash);
        System.out.println(b2.hash);
        System.out.println(b3.hash);
        
        BlockChain bc = new BlockChain();
        bc.Push(b1);
//        bc.LastContractFailed();
        bc.Push(b2);
//        bc.LastContractSuccess();
//        bc.Transact();
        bc.Push(b3);
        
        bc.print();

    }
    
}
