package com.example.demo.Service;


import com.example.demo.Dto.PaymentDto;
import com.example.demo.Entity.Payment;
import com.example.demo.Repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(PaymentDto paymentDto){

        Payment payment = new Payment();

        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setId(payment.getId());

        return paymentRepository.save(payment);
    }


    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(final Long id){
        return paymentRepository.getOne(id);
    }

    public void DeletePaymentById(final Long id){
        paymentRepository.deleteById(id);
    }

    public Payment updatePayment(PaymentDto paymentDto,  Long id){
        Payment existPayment = paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Payment not found with id: " + id)
                );

        existPayment.setPaymentDate(paymentDto.getPaymentDate());
        existPayment.setPaymentDate(paymentDto.getPaymentDate());
        existPayment.setPaymentMethod(paymentDto.getPaymentMethod());
        existPayment.setAmount(paymentDto.getAmount());


        return paymentRepository.save(existPayment);
    }

}

