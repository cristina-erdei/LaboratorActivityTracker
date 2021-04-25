package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.base.Attendance;
import com.example.assignment_2.bussiness.model.create.AttendanceCreateModel;
import com.example.assignment_2.bussiness.service.interfaces.AttendanceService;
import com.example.assignment_2.data.model.AttendanceDB;
import com.example.assignment_2.data.model.LaboratoryDB;
import com.example.assignment_2.data.model.StudentDB;
import com.example.assignment_2.data.repository.AttendanceRepository;
import com.example.assignment_2.data.repository.LaboratoryRepository;
import com.example.assignment_2.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImplementation implements AttendanceService {


    @Qualifier("attendanceRepository")
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;
    @Qualifier("laboratoryRepository")
    @Autowired
    private LaboratoryRepository laboratoryRepository;


    @Override
    public List<Attendance> findAll() {
        List<AttendanceDB> attendance = attendanceRepository.findAll();
        return attendance.stream().map(Attendance::new).collect(Collectors.toList());
    }

    @Override
    public Attendance findById(Long id) {
        Optional<AttendanceDB> attendanceDB = attendanceRepository.findById(id);
        return attendanceDB.map(Attendance::new).orElse(null);
    }

    @Override
    public List<Attendance> findAllByLaboratory_Id(Long laboratory_id) {
        List<AttendanceDB> attendanceDBS = attendanceRepository.findAllByLaboratory_Id(laboratory_id);
        return attendanceDBS.stream().map(Attendance::new).collect(Collectors.toList());
    }

    @Override
    public Attendance create(AttendanceCreateModel createModel) {
        if (createModel == null) {
            return null;
        }

        Optional<StudentDB> studentDB = studentRepository.findById(createModel.getStudentId());
        if (studentDB.isEmpty()) {
            return null;
        }

        Optional<LaboratoryDB> laboratoryDB = laboratoryRepository.findById(createModel.getLaboratoryId());
        if (laboratoryDB.isEmpty()) {
            return null;
        }

        AttendanceDB attendanceDB = new AttendanceDB(studentDB.get(), laboratoryDB.get());
        AttendanceDB saved = attendanceRepository.save(attendanceDB);
        return new Attendance(saved);
    }

    @Override
    public Attendance update(Long id, AttendanceCreateModel newValue) {
        if (newValue == null) {
            return null;
        }

        Optional<AttendanceDB> attendanceDB = attendanceRepository.findById(id);

        if (attendanceDB.isEmpty()) {
            return null;
        }

        AttendanceDB toUpdate = attendanceDB.get();

        if (newValue.getStudentId() != null) {
            Optional<StudentDB> studentDB = studentRepository.findById(newValue.getStudentId());
            studentDB.ifPresent(toUpdate::setStudent);
        }

        if (newValue.getLaboratoryId() != null) {
            Optional<LaboratoryDB> laboratoryDB = laboratoryRepository.findById(newValue.getLaboratoryId());
            laboratoryDB.ifPresent(toUpdate::setLaboratory);
        }

        AttendanceDB updated = attendanceRepository.save(toUpdate);
        return new Attendance(updated);

    }

    @Override
    public Attendance deleteById(Long id) {
        Optional<AttendanceDB> attendanceDB = attendanceRepository.findById(id);

        if (attendanceDB.isEmpty()) {
            return null;
        }

        AttendanceDB toDelete = attendanceDB.get();

        attendanceRepository.deleteById(id);

        return new Attendance(toDelete);
    }
}
