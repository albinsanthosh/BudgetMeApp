package com.app.budgetme.dao;

import com.app.budgetme.entity.planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanningRepository extends JpaRepository<planning, Integer> {
    List<planning> findAllByMonth(String selectMonth);
}
