package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.LaboratoryDTO;
import com.example.assignment_2.bussiness.model.create.LaboratoryCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LaboratoryService {
    List<LaboratoryDTO> findAll();

    LaboratoryDTO findById(Long id);

    LaboratoryDTO create(LaboratoryCreateModel createModel);

    void deleteById(Long id);


}