package com.example.assignment_2.helper;

import com.example.assignment_2.bussiness.model.DTO.TeacherDTO;
import com.example.assignment_2.bussiness.model.base.Teacher;
import com.example.assignment_2.bussiness.model.create.TeacherCreateModel;
import com.example.assignment_2.bussiness.service.implementation.TeacherServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private TeacherServiceImplementation teacherService;

    @Override
    public void run(String... args) throws Exception {
        Teacher teacher = teacherService.findByEmail(AppConstants.defaultTeacherEmail);
        if(teacher == null){
            TeacherCreateModel defaultTeacher = new TeacherCreateModel(AppConstants.defaultTeacherEmail, AppConstants.defaultTeacherPassword);
            teacherService.create(defaultTeacher);
        }
    }
}
