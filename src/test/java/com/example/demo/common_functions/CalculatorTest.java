package com.example.demo.common_functions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void threePlusSevenShouldEqualTen() {
        var calculator = new Calculator();
        assertEquals(10, calculator.addTwoNumbers(3, 7));
    }

    @Test
    void tenDividedByFiveShouldEqualTwo() {
        var calculator = new Calculator();
        assertEquals(2, calculator.divideTwoNumbers(10, 5));
    }

    @Test
    void divideByZeroShouldThrowException() {
        var calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divideTwoNumbers(5, 0);
        });
    }
}
