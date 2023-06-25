package com.app.budgetme.service;

import com.app.budgetme.dao.PlanningRepository;
import com.app.budgetme.entity.planning;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanningServiceImpl implements PlanningService{

    private PlanningRepository planningRepository;

    public PlanningServiceImpl(PlanningRepository theplanningRepository){
        planningRepository = theplanningRepository;
    }

    @Override
    public List<planning> findAll() {
        return planningRepository.findAll();
    }

    @Override
    public planning findById(int theId) {
        Optional<planning> result = planningRepository.findById(theId);

        planning thePlanning = null;

        if(result.isPresent()){
            thePlanning = result.get();
        }
        else{
            // we didn't find the planning
            throw new RuntimeException("Did not find planning id - " + theId);
        }

        return thePlanning;
    }

    @Override
    public void save(planning thePlanning) {
        planningRepository.save(thePlanning);
    }

    @Override
    public void deleteById(int theId) {
        planningRepository.deleteById(theId);
    }

    @Override
    public List<planning> findAllByMonth(String selectMonth) {
        return planningRepository.findAllByMonth(selectMonth);
    }
}
