package com.orkznl;

import com.orkznl.usecase.ResidentUseCase;
import com.orkznl.usecase.RoomUseCase;
import com.orkznl.usecase.UserUseCase;
import com.orkznl.usecase.WardUseCase;
import com.orkznl.usecase.UserRoleUseCase;
import com.orkznl.usecase.RoleUseCase;
import com.orkznl.usecase.ChargeUseCase;
import com.orkznl.usecase.ChargePriceUseCase;
import com.orkznl.usecase.PaymentUseCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private UserUseCase userUseCase;
    @Autowired
    private WardUseCase wardUseCase;
    @Autowired
    private RoomUseCase roomUseCase;
    @Autowired
    private ResidentUseCase residentUseCase;
    @Autowired
    private UserRoleUseCase userroleUseCase;
    @Autowired
    private RoleUseCase roleUseCase;
    @Autowired
    private ChargeUseCase chargeUseCase;
    @Autowired
    private ChargePriceUseCase chargepriceUseCase;
    @Autowired
    private PaymentUseCase paymentUseCase;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        //userRepository.save(new User("Alex", "1234ab", "alvanklaveren@gmail.com"));

//        System.out.println("\nfindAll()");
//        userUseCase.getAllUsers().forEach(x -> System.out.println(x));
//        wardUseCase.getAllWards().forEach(x -> System.out.println(x));
//        roomUseCase.getAllRooms().forEach(x -> System.out.println(x));
//        residentUseCase.getAllResidents().forEach(x -> System.out.println(x));
//        userroleUseCase.getAllUserroles().forEach(x -> System.out.println(x));
//        roleUseCase.getAllRoles().forEach(x -> System.out.println(x));
//        chargeUseCase.getAllCharges().forEach(x -> System.out.println(x));
//        chargepriceUseCase.getAllChargePrices().forEach(x -> System.out.println(x));
//        paymentUseCase.getAllPayments().forEach(x -> System.out.println(x));
    }

}