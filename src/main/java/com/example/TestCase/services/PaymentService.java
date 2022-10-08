package com.example.TestCase.services;

import com.example.TestCase.models.Payment;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PaymentService {

    private double vacationPay (double income, int days) {
        return (int) ((income / 29.3) * days);
    }

    public double calculate(Payment payment) {
        return vacationPay(payment.getAvgIncome(), payment.getDaysNum());
    }

//    public double calculateWithDate(Payment payment) {
//        int countHolidays = 0;
//        Calendar firstDay = payment.getFirstDay();
//
//        for (int i = 0; i < payment.getDaysNum(); i++) {
//            if (firstDay.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
//                    firstDay.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
//                countHolidays++;
//            }
//            firstDay.add(Calendar.DAY_OF_WEEK, 1);
//        }
//
//        return (vacationPay(payment.getAvgIncome(), payment.getDaysNum()) - countHolidays * payment.getAvgIncome()/29.3);
//    }

}
