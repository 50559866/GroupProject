package com.atmbanksimulator;

import javafx.application.Application;
import javafx.stage.Stage;

// 🧍Think of MVC like a human body:
// - View is the face and senses: it shows things and receives input.
// - Controller is the nerves: it carries signals to the brain and triggers actions.
// - UIModel is the brain: it holds state and logic, and queries domain services.
// - Bank / BankAccount are the real "money world" rules.
// Together, they simulate how an ATM thinks, reacts, and handles money.

public class Main extends Application {
    public static void main( String args[] ) {launch(args);}

    public void start(Stage window) {
        // Create a Bank object add two bank accounts for test
        Bank bank = new Bank();
        bank.addBankAccount("10001", "11111", 100);
        bank.addBankAccount("10002", "22222", 50);

        // Student bank - to test if withdrawl limit works. - added
        bank.addBankAccount(new StudentBankAccount("10003","33333", 150));  //kept same pattern as it is easy to remeber
        // Prime bank - to test withdraw boundaries and if overdraft works - added
        bank.addBankAccount(new PrimeBankAccount("10004", "44444", 50));
        // Child bank - test deposit boundaries - added
        bank.addBankAccount(new ChildBankAccount("10005", "55555", 20));

        //UIModel-View-Controller structure setup
        // Create the UIModel, View and Controller objects and link them together
        UIModel UIModel = new UIModel(bank);   // the UIModel needs the Bank object to 'talk to' the bank
        View  view  = new View();
        Controller controller  = new Controller();

        // Link them together so they can talk to each other
        view.controller = controller;
        controller.UIModel = UIModel;
        UIModel.view = view;

        // start up the GUI (view), and then tell the UIModel to initialise itself
        view.start(window);
        UIModel.initialise();
    }
}
