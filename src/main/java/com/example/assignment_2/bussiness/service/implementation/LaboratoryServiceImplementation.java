package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.base.Attendance;
import com.example.assignment_2.bussiness.model.base.Laboratory;
import com.example.assignment_2.bussiness.model.create.LaboratoryCreateModel;
import com.example.assignment_2.bussiness.service.interfaces.LaboratoryService;
import com.example.assignment_2.data.model.LaboratoryDB;
import com.example.assignment_2.data.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaboratoryServiceImplementation implements LaboratoryService {


    @Qualifier("laboratoryRepository")
    @Autowired
    private LaboratoryRepository laboratoryRepository;
    @Autowired
    private AttendanceServiceImplementation attendanceService;


    @Override
    public List<Laboratory> findAll() {
        List<LaboratoryDB> laboratories = laboratoryRepository.findAll();
        return laboratories.stream().map(Laboratory::new).collect(Collectors.toList());
    }

    @Override
    public Laboratory findById(Long id) {
        Optional<LaboratoryDB> laboratory = laboratoryRepository.findById(id);
        return laboratory.map(Laboratory::new).orElse(null);
    }

    @Override
    public Laboratory create(LaboratoryCreateModel createModel) {
        if(createModel == null){
            return null;
        }

        LocalDate date = LocalDate.of(
                createModel.getYear(),
                createModel.getMonth(),
                createModel.getDay()
        );
        LaboratoryDB laboratoryDB = new LaboratoryDB(
                createModel.getNumber(),
                date,
                createModel.getTitle(),
                createModel.getTopic(),
                createModel.getDescription()
        );

        LaboratoryDB saved = laboratoryRepository.save(laboratoryDB);
        return new Laboratory(saved);
    }

    @Override
    public Laboratory deleteById(Long id) {
        Optional<LaboratoryDB> laboratory = laboratoryRepository.findById(id);

        if (laboratory.isEmpty()) {
            return null;
        }

        LaboratoryDB toDelete = laboratory.get();

        laboratoryRepository.deleteById(id);

        return new Laboratory(toDelete);
    }

    @Override
    public Laboratory update(Long id, LaboratoryCreateModel newValue) {
        if (newValue == null) {
            return null;
        }

        Optional<LaboratoryDB> laboratory = laboratoryRepository.findById(id);

        if (laboratory.isEmpty()) {
            return null;
        }

        LaboratoryDB toUpdate = laboratory.get();
        LocalDate oldDate = toUpdate.getDate();

        int year = newValue.getYear() > 0 ? newValue.getYear() : oldDate.getYear();
        int month = newValue.getMonth() > 0 ? newValue.getMonth() : oldDate.getMonthValue();
        int day = newValue.getDay() > 0 ? newValue.getDay() : oldDate.getDayOfMonth();

        LocalDate newDate = LocalDate.of(year, month, day);
        toUpdate.setDate(newDate);

        if (newValue.getNumber() > 0) {
            toUpdate.setNumber(newValue.getNumber());
        }

        if (newValue.getTitle() != null) {
            toUpdate.setTitle(newValue.getTitle());
        }

        if (newValue.getTopic() != null) {
            toUpdate.setTopic(newValue.getTopic());
        }

        if (newValue.getDescription() != null) {
            toUpdate.setDescription(newValue.getDescription());
        }

        LaboratoryDB updated = laboratoryRepository.save(toUpdate);

        return new Laboratory(updated);
    }

    @Override
    public List<Attendance> getAttendance(Long id) {
        Optional<LaboratoryDB> laboratory = laboratoryRepository.findById(id);

        if (laboratory.isEmpty()) {
            return null;
        }

        return attendanceService.findAllByLaboratory_Id(id);
    }
}
