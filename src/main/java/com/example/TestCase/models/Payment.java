package com.example.TestCase.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Payment {

    @NotNull(message = "Введите значение")
    @Range(min = 10000, max = 1000000, message = "Значение среднего дохода должно быть от 10 тысяч до миллиона")
    private double avgIncome;

    @NotNull(message = "Введите значение")
    @Min(value = 5, message = "Количество отпускных дней должно быть не меньше 5")
    private int daysNum;

    private Calendar firstDay;

    public Payment() {
    }

    public Payment(double avgIncome, int daysNum) {
        this.avgIncome = avgIncome;
        this.daysNum = daysNum;
    }

    public Payment(double avgIncome, int daysNum, Calendar firstDay) {
        this.avgIncome = avgIncome;
        this.daysNum = daysNum;
        this.firstDay = firstDay;
    }

    public Calendar getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(Calendar firstDay) {
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
