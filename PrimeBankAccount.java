package com.atmbanksimulator;

// class for primebank account
// - lets users go -500 into negatives
public class PrimeBankAccount extends BankAccount{

    public PrimeBankAccount(String a, String p, int b){
        super(a, p, b); //passes values from BankAccount class so that they can be used here
    }

    @Override
    public boolean withdraw(int amount ) {
        if (amount < 0) {
            return false;
        }
        int newBalance = getBalance() - amount;

        if ((getBalance() - amount) < -500) { //balance is private in parent class, function calls it
            return false;
        }
        setBalance(newBalance); //overwrites balance and all withdraw rules as parent class doesnt allow negatives
        return true;
        }
    }

