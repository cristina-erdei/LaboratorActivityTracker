package com.example.assignment_2.bussiness.service.implementation;


import com.example.assignment_2.bussiness.model.base.Assignment;
import com.example.assignment_2.bussiness.model.create.AssignmentCreateModel;
import com.example.assignment_2.bussiness.service.interfaces.AssignmentService;
import com.example.assignment_2.data.model.AssignmentDB;
import com.example.assignment_2.data.model.LaboratoryDB;
import com.example.assignment_2.data.repository.AssignmentRepository;
import com.example.assignment_2.data.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignmentServiceImplementation implements AssignmentService {


    @Qualifier("assignmentRepository")
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Qualifier("laboratoryRepository")
    @Autowired
    private LaboratoryRepository laboratoryRepository;


    @Override
    public List<Assignment> findAll() {
        List<AssignmentDB> assignments = assignmentRepository.findAll();
        return assignments.stream().map(Assignment::new).collect(Collectors.toList());

    }

    @Override
    public Assignment findById(Long id) {
        Optional<AssignmentDB> assignmentDB = assignmentRepository.findById(id);
        return assignmentDB.map(Assignment::new).orElse(null);
    }

    @Override
    public List<Assignment> findAllByLaboratory_Id(Long laboratory_id) {
        List<AssignmentDB> assignmentDBS = assignmentRepository.findAllByLaboratory_Id(laboratory_id);
        return assignmentDBS.stream().map(Assignment::new).collect(Collectors.toList());
    }

    @Override
    public Assignment create(AssignmentCreateModel createModel) {
        if (createModel == null) {
            return null;
        }

        Optional<LaboratoryDB> laboratoryDB = laboratoryRepository.findById(createModel.getLaboratoryId());
        if (laboratoryDB.isEmpty()) {
            return null;
        }

        LocalDateTime dateTime = LocalDateTime.of(
                LocalDate.of(createModel.getYear(), createModel.getMonth(), createModel.getDay()),
                LocalTime.of(createModel.getHour(), createModel.getMinute())
        );
        AssignmentDB assignmentDB = new AssignmentDB(
                laboratoryDB.get(),
                createModel.getName(),
                dateTime,
                createModel.getDescription()
                );

        AssignmentDB saved = assignmentRepository.save(assignmentDB);
        return new Assignment(saved);
    }

    @Override
    public Assignment update(Long id, AssignmentCreateModel newValue) {
        if (newValue == null) {
            return null;
        }

        Optional<AssignmentDB> assignmentDB = assignmentRepository.findById(id);

        if (assignmentDB.isEmpty()) {
            return null;
        }

        AssignmentDB toUpdate = assignmentDB.get();

        if(newValue.getLaboratoryId() != null){
            Optional<LaboratoryDB> laboratoryDB = laboratoryRepository.findById(newValue.getLaboratoryId());
            laboratoryDB.ifPresent(toUpdate::setLaboratory);
        }

        LocalDateTime oldDateTime = toUpdate.getDeadline();

        int year = newValue.getYear() > 0 ? newValue.getYear() : oldDateTime.getYear();
        int month = newValue.getMonth() > 0 ? newValue.getMonth() : oldDateTime.getMonthValue();
        int day = newValue.getDay() > 0 ? newValue.getDay() : oldDateTime.getDayOfMonth();
        int hour = newValue.getHour() > 0 ? newValue.getHour() : oldDateTime.getHour();
        int minute = newValue.getMinute() > 0 ? newValue.getMinute() : oldDateTime.getMinute();

        LocalDateTime newDateTime = LocalDateTime.of(
                LocalDate.of(year, month, day),
                LocalTime.of(hour, minute)
        );

        toUpdate.setDeadline(newDateTime);

        if(newValue.getName() != null){
            toUpdate.setName(newValue.getName());
        }

        if(newValue.getDescription() != null){
            toUpdate.setDescription(newValue.getDescription());
        }

        AssignmentDB updated = assignmentRepository.save(toUpdate);

        return new Assignment(updated);
    }

    @Override
    public Assignment deleteById(Long id) {
        Optional<AssignmentDB> assignmentDB = assignmentRepository.findById(id);

        if (assignmentDB.isEmpty()) {
            return null;
        }

        AssignmentDB toDelete = assignmentDB.get();

        assignmentRepository.deleteById(id);

        return new Assignment(toDelete);
    }
}
