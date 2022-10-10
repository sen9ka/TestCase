package com.example.TestCase.services;

import com.example.TestCase.models.Payment;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.time.DayOfWeek.*;

@Service
public class PaymentService {

    private double vacationPay (double income, int days) {
        return ((income / 29.3) * days);
    }

    public double calculate(Payment payment) {
        return vacationPay(payment.getAvgIncome(), payment.getDaysNum());
    }

    public int paidDays (String firstDayDate, int days) {
        LocalDate firstDay = LocalDate.parse(firstDayDate);
        LocalDate endDate = firstDay.plusDays(days);
        final Set<Integer> holidays = Set.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 54, 67, 121, 122, 123, 129, 163, 308, 365
        );
        final Set<DayOfWeek> weekendDays = Set.of(
            SATURDAY, SUNDAY
        );
        List<LocalDate> paidDates = firstDay.datesUntil(endDate)
                .filter(t -> !weekendDays.contains(t.getDayOfWeek()))
                .filter(t -> !holidays.contains(t.getDayOfYear()))
                .collect(Collectors.toList());

        return paidDates.size();
    }

    public double calculateWithDate(Payment payment) {
        return vacationPay(payment.getAvgIncome(), paidDays(payment.getFirstDay(), payment.getDaysNum()));
    }

}
