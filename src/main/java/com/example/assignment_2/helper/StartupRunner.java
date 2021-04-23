package com.example.assignment_2.helper;

import com.example.assignment_2.bussiness.model.DTO.TeacherDTO;
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
        TeacherDTO teacher = teacherService.findByEmail("admin@admin.com");
        if(teacher == null){
            TeacherCreateModel defaultTeacher = new TeacherCreateModel("admin@admin.com", "admin");
            teacherService.create(defaultTeacher);
        }
    }
}
