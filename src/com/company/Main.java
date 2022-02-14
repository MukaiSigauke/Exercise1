package com.company;

//Number 1: C (derived)

// 2. Challenge #1: Override a Method using the Super Keyword
class Shape{ // Shape class for Challenge 1 and 2

    private String name;
    private double width;
    private double length;
    public  Shape(){
        this.name = "";
        this.length=0;
        this.width=0;
    }
    // for challenge 1
    public void  setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    // for challenge 2
    public  Shape(double width, double length){
        this.width = width;
        this.length = length;
    }
    public double getArea(){
        return  this.length*this.width;
    }
}
class XShape extends Shape {
    public XShape(String name) {
        super.setName(name);
    }
    // Overridden Method
    public String getName() {
        return super.getName();
    }
}
// Challenge 2: Implement and Override the Method
class Circle extends Shape { // using Shape class defined in challenge 1
    private  double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return 2*3.14*this.radius;
    }
}
//Assignment: Implement an Account Class using Polymorphism
class  Account {
    protected double balance;
    public  Account(double balance){
        this.balance = balance;
    }

    public void Withdraw(double amount) {

    }
    public void Deposit(double amount){

    }
    public  void  printBalance(){
         System.out.println(this.balance);
    }
}
class  Savings extends Account{
    private  static double interestRate = 0.8;
    public  Savings(double balance){
        super(balance);
    }
    public void Withdraw(double amount) {
        this.balance = (balance + interestRate*this.balance)-amount;
    }
    @Override
    public void Deposit(double amount){
        this.balance = (balance + interestRate*this.balance)+amount;
    }
    @Override
    public  void  printBalance(){
        System.out.println(this.balance);
    }
}
class  Current extends Account{
    public  Current(double balance){
        super(balance);
    }
    public void Withdraw(double amount) {
        this.balance -= amount;
    }
    @Override
    public void Deposit(double amount){
        this.balance += amount;
    }
    @Override
    public  void  printBalance(){
        System.out.println(this.balance);
    }
}

public class Main {

    public static void main(String[] args) {

        // . Challenge #1: Override a Method using the Super Keyword
        System.out.println("2. Challenge #1: Override a Method using the Super Keyword");
        Shape circle = new XShape("Circle");
        System.out.println(circle.getName());

        // Challenge 2: Implement and Override the Method
        System.out.println("Challenge 2: Implement and Override the Method");
        Shape circle1 = new Circle(2);
        System.out.println(circle1.getArea());

        // Assignment: Implement an Account Class using Polymorphism
        System.out.println("Assignment: Implement an Account Class using Polymorphism");
        Account SAccount = new Savings(50000);
        SAccount.Deposit(1000);
        SAccount.printBalance();
        SAccount.Withdraw(3000);
        SAccount.printBalance();
        System.out.println();
        // creating current account object
        Account CAccount = new Current(50000);
        CAccount.Deposit(1000);
        CAccount.printBalance();
        CAccount.Withdraw(3000);
        CAccount.printBalance();
    }
}
