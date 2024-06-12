package com.codejava.repository;

import com.codejava.entity.PlanCategory;
import com.codejava.entity.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {


}
