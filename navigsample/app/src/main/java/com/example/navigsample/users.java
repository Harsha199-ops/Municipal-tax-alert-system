package com.example.navigsample;

public class users {
    private String name;
    private String number;
    private String amount;
    private String duedate,remove;
    private String kgs;
    private String loc;



    long stackId;
    public users() {
        /*Blank default constructor essential for Firebase*/
    }
    public users(String a)
    {

    }
    public users(String name, String number, String amount, String duedate){
        this.name= name;
        this.number= number;
        this.amount=amount;
        this.duedate=duedate;
        this.remove=remove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemoveValue() {
        return remove;
    }

    public void setRemoveValue(String remove) {
        this.remove = remove;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {

        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }




    //Getters and setters

}
