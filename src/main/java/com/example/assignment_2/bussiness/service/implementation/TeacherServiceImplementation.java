package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.DTO.TeacherDTO;
import com.example.assignment_2.bussiness.model.base.Teacher;
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
    public List<Teacher> findAll() {
        List<TeacherDB> result = teacherRepository.findAll();
        return result.stream().map(Teacher::new).collect(Collectors.toList());
    }

    @Override
    public Teacher findByAuthenticationToken(String authenticationToken) {
        TeacherDB found = teacherRepository.findByAuthenticationToken(authenticationToken);
        if (found == null) {
            return null;
        }

        return new Teacher(found);
    }

    @Override
    public Teacher findById(Long id) {
        Optional<TeacherDB> teacher = teacherRepository.findById(id);
        return teacher.map(Teacher::new).orElse(null);
    }

    @Override
    public Teacher findByEmail(String email) {
        TeacherDB found = teacherRepository.findByEmail(email);
        if (found == null) {
            return null;
        }

        return new Teacher(found);
    }

    @Override
    public Teacher create(TeacherCreateModel createModel) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedPassword = encoder.encodeToString(createModel.getPassword().getBytes(StandardCharsets.UTF_8));
        TeacherDB teacherDB = new TeacherDB(createModel.getEmail(), encodedPassword);
        TeacherDB saved = teacherRepository.save(teacherDB);
        return new Teacher(saved);
    }

    @Override
    public Teacher update(Long id, TeacherCreateModel createModel) {
        Optional<TeacherDB> teacher = teacherRepository.findById(id);

        if(teacher.isEmpty()){
            return null;
        }

        TeacherDB found = teacher.get();

        if(createModel.getEmail() != null){
            found.setEmail(createModel.getEmail());
        }

        if(createModel.getPassword() != null){
            Base64.Encoder encoder = Base64.getEncoder();
            String encodedPassword = encoder.encodeToString(createModel.getPassword().getBytes(StandardCharsets.UTF_8));
            found.setPassword(encodedPassword);
        }

        TeacherDB updated = teacherRepository.save(found);

        return new Teacher(updated);
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
    public Teacher deleteById(Long id) {
        Optional<TeacherDB> teacher = teacherRepository.findById(id);

        if(teacher.isEmpty()){
            return null;
        }

        TeacherDB found = teacher.get();

        teacherRepository.deleteById(id);

        return new Teacher(found);
    }
}
