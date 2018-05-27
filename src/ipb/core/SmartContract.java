/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.core;

/**
 *
 * @author SIlver
 */
public class SmartContract {
    public enum ContractState {Failed, Ongoing, Rewardable, Claimed}
    public String contract;
    public int worth;
    public ContractState state = ContractState.Ongoing;
    
    public SmartContract(String con, int w){
        contract = con;
        worth = w;
    }
    
}
