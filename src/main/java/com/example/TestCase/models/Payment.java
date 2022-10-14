package com.example.TestCase.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Payment {

    @NotNull(message = "Введите значение")
    @Range(min = 10000, max = 1000000, message = "Значение среднего дохода должно быть от 10 тысяч до миллиона")
    private double avgIncome;

    @NotNull(message = "Введите значение")
    @Min(value = 5, message = "Количество отпускных дней должно быть не меньше 5")
    private int daysNum;

    private String firstDay;

    public Payment() {
    }

    public Payment(double avgIncome, int daysNum) {
        this.avgIncome = avgIncome;
        this.daysNum = daysNum;
    }

    public Payment(double avgIncome, int daysNum, String firstDay) {
        this.avgIncome = avgIncome;
        this.daysNum = daysNum;
        this.firstDay = firstDay;
    }

    public String getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }

    public double getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(double avgIncome) {
        this.avgIncome = avgIncome;
    }

    public int getDaysNum() {
        return daysNum;
    }

    public void setDaysNum(int daysNum) {
        this.daysNum = daysNum;
    }
}
