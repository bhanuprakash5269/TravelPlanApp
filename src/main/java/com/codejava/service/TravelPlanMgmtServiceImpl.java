package com.codejava.service;

import com.codejava.entity.PlanCategory;
import com.codejava.entity.TravelPlan;
import com.codejava.repository.IPlanCategoryRepository;
import com.codejava.repository.ITravelPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService{

    @Autowired
    private ITravelPlanRepository travelPlanRepository;

    @Autowired
    private IPlanCategoryRepository planCategoryRepository;

    @Override
    public String registerTravelPlan(TravelPlan travelPlan) {
        //save the Object
        TravelPlan saved = travelPlanRepository.save(travelPlan);
       /* if(saved.getPlanId()!==null)
            return "Travel Plan is saved with ID value: "+saved.getPlanId();
        else
            return "Problem in saving the TravelPlan";*/

        return saved.getPlanId()!=null?"Travel Plan is saved with ID value: "+saved.getPlanId():"Problem in saving the TravelPlan";
    }

    @Override
    public Map<Integer, String> getTravelPlanCategories() {
        //get all Travel Plans
        List<PlanCategory> list=planCategoryRepository.findAll();
        Map<Integer,String> categoriedMap= new HashMap<Integer,String>();
        list.forEach(category->{
            categoriedMap.put(category.getCategoryId(),category.getCategoryName());
        });
        return categoriedMap;
    }

    @Override
    public List<TravelPlan> showAllTravelPlans() {
        return travelPlanRepository.findAll();
    }

    @Override
    public TravelPlan showTravelPlanById(Integer planId) {
        return travelPlanRepository.findById(planId).orElseThrow(()->new IllegalArgumentException("TravelPlan id not found"));
       /* Optional<TravelPlan> opt = travelPlanRepository.findById(planId);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new IllegalArgumentException("Plan id is not found");
        }*/

    }

    @Override
    public String updateTravelPlan(TravelPlan plan) {
        Optional<TravelPlan> opt = travelPlanRepository.findById(plan.getPlanId());
        if(opt.isPresent()){
            //updat the object
            travelPlanRepository.save(plan);
            return plan.getPlanId()+"Travel Plain is updated";
        }else{
            return plan.getPlanId()+" Plan id is not found";
        }
    }

    @Override
    public String deleteTravelPlan(Integer planId) {
        Optional<TravelPlan> opt = travelPlanRepository.findById(planId);
        if(opt.isPresent()){
            //Delete the object
            travelPlanRepository.deleteById(planId);
            return planId+" Travel Plain is Deleted";
        }else{
            return planId+" Travel Plan is not found";
        }
    }

    @Override
    public String changeTravelPlanByStatus(Integer planId, String status) {
        Optional<TravelPlan> opt = travelPlanRepository.findById(planId);
        if(opt.isPresent()){
            TravelPlan plan = opt.get();
            plan.setActiveSW(status);
            travelPlanRepository.save(plan);
            return planId+"Travel Plain Status is changed";
        }else{
            return planId+" Travel Plan is not found for updation";
        }
    }
}
