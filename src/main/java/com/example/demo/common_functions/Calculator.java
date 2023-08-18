package com.example.demo.common_functions;

public class Calculator {
    
    public int addTwoNumbers(int number1, int number2) {
        return number1 + number2;
    }

    public float divideTwoNumbers(int numberToBeDivided, int numberDividing) {
        if(numberDividing == 0) {
            throw new IllegalArgumentException("You cannot divide a number by zero");
        }
        return numberToBeDivided / numberDividing;
    }
}
