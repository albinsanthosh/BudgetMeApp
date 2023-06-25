package com.app.budgetme.service;

import com.app.budgetme.entity.planning;

import java.util.List;

public interface PlanningService {
    List<planning> findAll();

    planning findById(int theId);

    void save(planning thePlanning);

    void deleteById(int theId);

    List<planning> findAllByMonth(String selectMonth);
}
