package com.atmbanksimulator;

public class StudentBankAccount extends BankAccount{
    private int wdLimit = 50; //limites withdrawls to 50

    public StudentBankAccount(String a, String p, int b){
        super(a, p, b); //passes values from BankAccount class so that they can be used here
    }

    @Override
    public boolean withdraw (int amount){
        if (amount > wdLimit ){
            return false;
        }
        return super.withdraw(amount); //as amount is private in the bankaccount class, super allows this class to use it so rewriting is not needed
    }
}
