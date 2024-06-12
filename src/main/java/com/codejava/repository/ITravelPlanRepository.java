package com.codejava.repository;

import com.codejava.entity.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {


}
