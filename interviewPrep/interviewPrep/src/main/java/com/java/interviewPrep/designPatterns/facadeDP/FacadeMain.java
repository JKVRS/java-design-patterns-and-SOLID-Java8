package com.java.interviewPrep.designPatterns.facadeDP;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Customer{
    private int custId;
    private String name;

    public Customer(int custId, String name) {
        this.custId = custId;
        this.name = name;
    }

    public String getCustName(){
        return name;
    }
}

@Getter
@Setter
class Account{
    private int actId;
    private long actNumber;

    public Account(int actId, long actNumber) {
        this.actId = actId;
        this.actNumber = actNumber;
    }

    public long getAccountNumber(){
        return actNumber;
    }
}

class Bank{
    private Customer customer;
    private Account account;

    public Bank() {

    }

    public void getDetails(int custId, String custName, int actId, long actNumber){
        customer = new Customer(custId,custName );
        account = new Account(actId,actNumber);
        System.out.println( customer.getCustName()+" has account number "+ account.getAccountNumber());
    }
}
public class FacadeMain {
    public static void main(String[] args) {

        // client should only talk to facade
        Bank b = new Bank();
        b.getDetails(12,"Ram",1,325222002);
    }

}
