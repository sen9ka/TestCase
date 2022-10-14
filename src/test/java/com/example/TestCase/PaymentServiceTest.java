package com.example.TestCase;

import com.example.TestCase.models.Payment;
import com.example.TestCase.services.PaymentService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaymentServiceTest {

    @Test
    public void paidDaysShouldExcludeMayHolidays() {
        int result = PaymentService.paidDays("2014-05-01", 14);
        Assert.assertEquals(7, result, 1e-9);
    }

    @Test
    public void vacationPayShouldReturnZero() {
        double result = PaymentService.vacationPay(25000, 0);
        Assert.assertEquals(0, result, 1e-9);
    }

    @Test
    public void paidDaysShouldReturnZero() {
        int result = PaymentService.paidDays("2014-05-01", 4);
        Assert.assertEquals(0, result, 1e-9);
    }

    @Test
    public void calculationShouldReturn35836() {
        Payment payment = new Payment(75000, 14);
        double result = PaymentService.calculate(payment);
        Assert.assertEquals(35835.17, result, 2);
    }

    @Test
    public void calculateWithDateShouldReturn25597() {
        Payment payment = new Payment(75000, 14, "2016-07-01");
        double result = PaymentService.calculateWithDate(payment);
        Assert.assertEquals(25597.26, result, 2);
    }
}
