package com.codejava.service;

import com.codejava.entity.TravelPlan;

import java.util.List;
import java.util.Map;

public interface ITravelPlanMgmtService {

    public String registerTravelPlan(TravelPlan travelPlan);   //save operation
    public Map<Integer, String> getTravelPlanCategories(); //for select operation
    public List<TravelPlan> showAllTravelPlans();   //for select operation
    public TravelPlan showTravelPlanById(Integer planId);  //for edit operation form launch (To show the existing record for Editing)
    public String updateTravelPlan(TravelPlan plan);  //for edit operation form submission
    public String deleteTravelPlan(Integer planId); //for deletion opeartion (hard deletion)
    public String changeTravelPlanByStatus(Integer planId, String status);  //for soft deletion activity

}
