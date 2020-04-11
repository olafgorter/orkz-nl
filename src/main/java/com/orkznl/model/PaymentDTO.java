package com.orkznl.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentDTO {
    public Long id;
    public ResidentDTO resident;
    public Double  amount;
    public Date payment_date;
    public String description;
    public String change_name;
    public Date change_date;
    public Integer version;

    public static List<PaymentDTO> toDto(List<Payment> payments){
        List<PaymentDTO> paymentDTOs = payments.stream().map(PaymentDTO::toDto).collect(Collectors.toList());
        return paymentDTOs;
    }

    public static PaymentDTO toDto(Payment payment){
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.id = payment.getId();
        paymentDTO.resident = ResidentDTO.toDto( payment.getResident());
        paymentDTO.amount = payment.getAmount();
        paymentDTO.payment_date = payment.getPayment_date();
        paymentDTO.description = payment.getDescription();
        paymentDTO.change_name = payment.getChange_name();
        paymentDTO.change_date = payment.getChange_date();
        paymentDTO.version = payment.getVersion();
        return paymentDTO;
    }

    @Override
    public String toString(){
        return id + " " + resident.fullName + " " + amount + " " + payment_date + " " + description + " " + change_name + " " + change_date;
    }
}