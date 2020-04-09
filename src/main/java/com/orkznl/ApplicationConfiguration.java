package com.orkznl;

import com.orkznl.rest.UserRestResource;
import com.orkznl.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean public UserUseCase userUseCase(){
        return new UserUseCase();
    }
    @Bean public WardUseCase wardUseCase(){
        return new WardUseCase();
    }
    @Bean public RoomUseCase roomUseCase(){
        return new RoomUseCase();
    }
    @Bean public ResidentUseCase residentUseCase(){
        return new ResidentUseCase();
    }
    @Bean public ResidentChargeUseCase residentChargeUseCase() { return new ResidentChargeUseCase(); }
    @Bean public UserRoleUseCase userroleUseCase(){
        return new UserRoleUseCase();
    }
    @Bean public RoleUseCase roleUseCase(){
        return new RoleUseCase();
    }
    @Bean public ChargeUseCase chargeUseCase(){
        return new ChargeUseCase();
    }
    @Bean public ChargePriceUseCase chargepriceUseCase(){
        return new ChargePriceUseCase();
    }
    @Bean public PaymentUseCase paymentUseCase(){
        return new PaymentUseCase();
    }

//    @Bean public UserRestResource userRestResource(){
//        return new UserRestResource();
//    }

}

