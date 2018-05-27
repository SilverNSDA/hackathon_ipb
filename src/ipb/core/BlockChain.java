/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author SIlver
 */

public class BlockChain {
    public enum ChainState { NeedValidate, Valid, Invalid}
    public ArrayList<Block> chain = new ArrayList<>();
    public ChainState state = ChainState.NeedValidate;
    
    public boolean Push(Block b) throws NoSuchAlgorithmException{
        if(chain.size()>0){
            if(state == ChainState.NeedValidate){
                this.ChainValidate();
            }
            if(state == ChainState.Invalid){
                System.out.println("Chain invalid can not push");
                return false;
            }
            Block lastBlock = chain.get(chain.size()-1);
//            if(lastBlock.data.contract.state != SmartContract.ContractState.Claimed
//                    && lastBlock.data.contract.state != SmartContract.ContractState.Failed){
//                System.out.println("Last contract isn't completed yet");
//                return false;
//            }
        }
        
        chain.add(b);
        System.out.println("pushed");
        state = ChainState.NeedValidate;
        System.out.println("Transaction requested");
        return true;
    }
    
    public void ChainValidate() throws NoSuchAlgorithmException{
        if(state == ChainState.Valid) return;
        for(int i =1; i<chain.size();i++){
            Block current = chain.get(i);
            Block previous = chain.get(i-1);
            if(!previous.hash.equals(current.pHash)){
                System.out.println("Chain broken between these two blocks: ");
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(previous));
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(current));
                state = ChainState.Invalid;
                return;
            }
                
            if(!previous.hash.equals(previous.Hash())){
                System.out.println("Corrupted hash at block: ");
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(previous));
                state = ChainState.Invalid;
                return;
            }
            if(!current.hash.equals(current.Hash())){
                System.out.println("Corrupted hash at block: ");
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(current));
                state = ChainState.Invalid;
                return;
            }
        }
        System.out.println("No problem found");
        state = ChainState.Valid;

        
    }
//    public void LastContractFailed(){
//        if(this.chain.get(chain.size()-1).data.contract.state ==SmartContract.ContractState.Ongoing)
//            this.chain.get(chain.size()-1).data.contract.state =SmartContract.ContractState.Failed;
//        System.out.println("Contract failed ");
//    }
//    
//    public void LastContractSuccess(){
//        if(this.chain.get(chain.size()-1).data.contract.state ==SmartContract.ContractState.Ongoing)
//            this.chain.get(chain.size()-1).data.contract.state =SmartContract.ContractState.Rewardable;
//        System.out.println("Contract success ");
//    }
//    
//    public int Transact(){
//        if(this.chain.get(chain.size()-1).data.contract.state ==SmartContract.ContractState.Rewardable){
//            this.chain.get(chain.size()-1).data.contract.state = SmartContract.ContractState.Claimed;
//            System.out.println("transaction");
//            return this.chain.get(chain.size()-1).data.contract.worth;
//            
//        }
//        return 0;
//    }
    
    public void print(){
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(chain));
    }
    
}
