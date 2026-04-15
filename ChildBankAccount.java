package com.atmbanksimulator;

// Class for child bank account
// - does not let user deposit more than 20 pounds at a time
public class ChildBankAccount extends BankAccount{

    public ChildBankAccount(String a, String p, int b){
        super(a, p, b); //passes values from BankAccount class so that they can be used here
    }

    @Override
    public boolean deposit (int amount){
        if (amount < 20 ){
            return false;
        }
        return super.withdraw(amount); //as amount is private in the bankaccount class, super allows this class to use it so rewriting is not needed
    }
}
