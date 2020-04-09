package com.orkznl.usecase;

import com.orkznl.model.Payment;
import com.orkznl.model.PaymentDTO;
import com.orkznl.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class PaymentUseCase {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public List<PaymentDTO> getAllPayments(){
        List<Payment> payments = paymentRepository.findAll();

        return PaymentDTO.toDto(payments);

    }
}