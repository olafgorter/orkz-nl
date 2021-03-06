package com.orkznl.usecase;

import com.orkznl.model.Ward;
import com.orkznl.model.WardDTO;
import com.orkznl.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class WardUseCase {

    @Autowired
    private WardRepository wardRepository;

    @Transactional
    public List<WardDTO> getAllWards(){
        List<Ward> wards = wardRepository.findAll();

        return WardDTO.toDto(wards);

    }
}