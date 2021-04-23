package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.DTO.TeacherDTO;
import com.example.assignment_2.bussiness.model.create.TeacherCreateModel;
import com.example.assignment_2.bussiness.service.interfaces.TeacherService;
import com.example.assignment_2.data.model.TeacherDB;
import com.example.assignment_2.data.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImplementation implements TeacherService {


    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<TeacherDTO> findAll() {
        List<TeacherDB> result = teacherRepository.findAll();
        return result.stream().map(TeacherDTO::new).collect(Collectors.toList());
    }

    @Override
    public TeacherDTO findByToken(String token) {
        TeacherDB found = teacherRepository.findByAuthenticationToken(token);
        if (found == null) {
            return null;
        }

        return new TeacherDTO(found);
    }

    @Override
    public TeacherDTO findById(Long id) {
        Optional<TeacherDB> teacher = teacherRepository.findById(id);
        return teacher.map(TeacherDTO::new).orElse(null);
    }

    @Override
    public TeacherDTO create(TeacherCreateModel createModel) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedPassword = encoder.encodeToString(createModel.getPassword().getBytes(StandardCharsets.UTF_8));
        TeacherDB teacherDB = new TeacherDB(createModel.getEmail(), encodedPassword);
        TeacherDB saved = teacherRepository.save(teacherDB);
        return new TeacherDTO(saved);
    }

    @Override
    public TeacherDTO update(Long id, TeacherCreateModel createModel) {
        Optional<TeacherDB> teacher = teacherRepository.findById(id);

        if(teacher.isEmpty()){
            return null;
        }

        TeacherDB found = teacher.get();

        if(createModel.getEmail() != null){
            found.setEmail(createModel.getEmail());
        }

        if(createModel.getPassword() != null){
            found.setPassword(createModel.getPassword());
        }

        TeacherDB updated = teacherRepository.save(found);

        return new TeacherDTO(updated);
    }

    @Override
    public boolean updateAuthenticationToken(Long id, String token) {
        Optional<TeacherDB> teacher = teacherRepository.findById(id);

        if(teacher.isEmpty()){
            return false;
        }

        TeacherDB found = teacher.get();
        found.setAuthenticationToken(token);

        teacherRepository.save(found);

        return true;
    }

    @Override
    public TeacherDTO deleteById(Long id) {
        Optional<TeacherDB> teacher = teacherRepository.findById(id);

        if(teacher.isEmpty()){
            return null;
        }

        TeacherDB found = teacher.get();

        teacherRepository.deleteById(id);

        return new TeacherDTO(found);
    }
}
