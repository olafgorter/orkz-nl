package com.orkznl.usecase;

import com.orkznl.model.Payment;
import com.orkznl.model.PaymentDTO;
import com.orkznl.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PaymentUseCase {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public List<PaymentDTO> getAllPayments(){
        List<Payment> payments = paymentRepository.findAll();

        return PaymentDTO.toDto(payments);

    }
}