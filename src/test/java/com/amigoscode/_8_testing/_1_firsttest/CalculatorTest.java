package com.amigoscode._8_testing._1_firsttest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Your First Unit Tests
 *
 * In this exercise you will write your first JUnit 5 tests for the Calculator class.
 * Complete each TODO to practice basic assertions and test lifecycle annotations.
 */
class CalculatorTest {

    // TODO: 1 - Declare a Calculator field and use @BeforeEach to create a fresh
    //  Calculator instance before each test. This ensures tests are independent.
    //  Hint: Write a setUp() method annotated with @BeforeEach that assigns
    //  a new Calculator() to your field.
    Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    // TODO: 2 - Write a test for the add method using assertEquals.
    //  Annotate it with @Test and @DisplayName("2 + 3 should equal 5").
    //  Call calculator.add(2, 3) and assert the result equals 5.
    @Test
    @DisplayName("2 + 3 should equal 5")
    void additionTest() {
        //given
        int n1 = 2, n2 = 3;
        //when
        int result = calculator.add(n1, n2);
        //then
        int expected = 5;
        assertThat(expected).isEqualTo(result);

    }
    // TODO: 3 - Write a test for the subtract method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.subtract(10, 4) equals 6.
    @Test
    @DisplayName("10  - 4 should equal to 6")
    public void subtractionTest() {
        int n1 = 10, n2 = 4;
        int result = calculator.subtract(n1, n2);
        int expected = 6;
        assertThat(expected).isEqualTo(result);
    }
    // TODO: 4 - Write a test for the multiply method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.multiply(3, 7) equals 21.
    @Test
    @DisplayName("3 * 7 should return 21")
    public void multiplicationTest() {
        int n1 = 3, n2 = 7;//given
        int result = calculator.multiply(n1, n2);//when
        int expected = 21;//then
        assertThat(expected).isEqualTo(result);
    }
    // TODO: 5 - Write a test that verifies dividing by zero throws ArithmeticException.
    //  Use assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0)).
    //  Add a @DisplayName annotation.
    @Test
    @DisplayName("Division by zero should cause ArithmeticException ")
    public void divideMethodShouldThrowArithmeticExceptionWhenDivideByZero() {
        int n1 = 3, n2 = 0;
        assertThrows(ArithmeticException.class, () -> calculator.divide(n1, n2));
    }
    // TODO: 6 - Write a test using assertNotEquals.
    //  Verify that calculator.add(2, 2) is NOT equal to 5.
    //  Add a @DisplayName annotation.
    @Test
    @DisplayName("2 + 2 should not equal to 5")
    public void addShouldNotReturnFiveForTwoPlusTwo() {
        int n1 = 2, n2 = 2;
        int actual = calculator.add(n1, n2);
        int unexpected = 5;
        assertNotEquals(unexpected, actual);
    }
    // TODO: 7 - Add @DisplayName annotations to ALL of your tests above (if not done already).
    //  Make the display names descriptive, e.g., "Adding 2 and 3 should return 5".
    //  Then write one more test: verify that calculator.divide(10, 2) equals 5.
    @DisplayName("10 / 2 should return 5 and 10 / 3 should return 3 using integer primitive type")
    @ParameterizedTest
    @CsvSource({
            "10, 2, 5",
            "10, 3, 3"})
    public void divideShouldReturnFiveForTenDivideTwo(int num1, int num2, int expected) {
        int actual = calculator.divide(num1, num2);
        assertThat(expected).isEqualTo(actual);
    }

}
