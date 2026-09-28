package com.example.demo.Controller;


import com.example.demo.Dto.PaymentDto;
import com.example.demo.Entity.Payment;
import com.example.demo.Repository.PaymentRepository;
import com.example.demo.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(final PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    public Payment createPayment(@RequestBody PaymentDto paymentDto){
        return paymentService.createPayment(paymentDto);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id){
        paymentService.DeletePaymentById(id);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@RequestBody Long id,  PaymentDto paymentDto){
        return paymentService.updatePayment(paymentDto, id);
    }
}
