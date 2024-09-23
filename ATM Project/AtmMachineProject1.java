package com.machine;

import java.util.Scanner;

class ATM{
    Scanner sc = new Scanner(System.in);
    private int pin = 123;
    private float balance=7900f;
    private boolean isValid=false;

    public ATM(){
        String repeat;
        System.out.println("Please enter pin: ");
        int pin=sc.nextInt();
        //validation process
        this.isValid=validatePin(pin);
        if (isValid){
            do {
                menu();
                System.out.println("Do you want to return main menu ? ");
                repeat=sc.next();
            }while (repeat.compareTo("yes")==0);
        }else {
            System.exit(0);
        }
    }

    //main menu setting
    public void menu(){
        int choice;
        float amount;
        System.out.println();
        System.out.println("1. Balance Enquiry.");
        System.out.println("2. Money Deposit.");
        System.out.println("3. Money Withdraw.");
        System.out.println("4. Pin Change");
        System.out.print("Enter option: ");
        //input taking for choice
        choice=sc.nextInt();
        System.out.println();
        //process the choice

        switch (choice){
            case 1: balanceEnquiry();
                    break;
            case 2: System.out.println("Please enter amount: ");
                    amount=sc.nextFloat();
                    moneyDeposit(amount);
                    break;
            case 3: System.out.println("Please enter amount: ");
                    amount=sc.nextFloat();
                    moneyWithdraw(amount);
                    break;
            case 4: setPin();
                    break;
            default:System.out.println("Wrong input! check your option further.");
        }

    }

    //pin validation setting
    public boolean validatePin(int pin){
        if (this.pin==pin) {
            System.out.println("pin matched");
            return true;
        }else {
            System.out.println("Wrong pin!");
            return false;
        }
    }

    //money deposit setting
    public void moneyDeposit(float money){
        this.balance+=money;
        System.out.println("Money deposition successfully: "+money);
    }

    // money withdraw setting
    public void moneyWithdraw(float money){
        if (this.balance<money){
            System.out.println("Insufficient balance! please check the balance.");
        }else {
            this.balance -= money;
            System.out.println("Withdrawal successfully: "+ money);
        }
    }

    //Balance enquiry setting
    public void balanceEnquiry(){
        System.out.println("Your balance: "+this.balance);
    }

    public void setPin(){
        System.out.println("please enter your old pin: ");
        int oldPin=sc.nextInt();
        int newPin;

        //validation process
        this.isValid=validatePin(oldPin);
        if (isValid){
            System.out.println("Enter new pin: ");
            newPin=sc.nextInt();
            this.pin=newPin;
            System.out.println("New pin added.");
        }else {
            System.exit(0);
        }

    }
}


public class AtmMachineProject1 {
    public static void main(String[] args) {
        new ATM();
    }
}
