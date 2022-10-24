package com.example.TestCase.controllers;

import com.example.TestCase.models.Payment;
import com.example.TestCase.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Calendar;

@Controller
@RequestMapping("/")
public class PaymentController {

    @Autowired
    public PaymentController(PaymentService paymentService) {
    }

    @GetMapping()
    public String showCalculatorPage(Model model, Payment payment) {
        model.addAttribute("payment", payment);
        return "payments/calculate";
    }

    @GetMapping(value = "/calculate")
    public String calculate(@ModelAttribute("payment") @Valid Payment payment, BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors())
            return "payments/calculate";
        model.addAttribute("result", PaymentService.calculation(payment));
        return "payments/calculate";
    }

}
