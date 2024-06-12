package com.codejava.ms;

import com.codejava.entity.TravelPlan;
import com.codejava.service.ITravelPlanMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/travelplan/api")  //Global path(optional)
public class TravelPlanOperationController {

    @Autowired
    private ITravelPlanMgmtService planMgmtService;

    @PostMapping("/register")
    public ResponseEntity<String> saveTOurPlan(@RequestBody TravelPlan plan){
        //use Service method
        try{
            String msg = planMgmtService.registerTravelPlan(plan);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<?> showTravelPlanCategories(){
        //invoke service class Methods
        try{
            Map<Integer,String> mapCategories = planMgmtService.getTravelPlanCategories();
            return new ResponseEntity<Map<Integer,String>>(mapCategories,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTravelPlans(){
        //use Service
        try{
            List<TravelPlan> list = planMgmtService.showAllTravelPlans();
            return new ResponseEntity<List<TravelPlan>>(list,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{planId}")
    public ResponseEntity<?> getTravelPlanById(@PathVariable Integer planId){
        try{
            TravelPlan plan = planMgmtService.showTravelPlanById(planId);
            return new ResponseEntity<TravelPlan>(plan,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTravelPlan(@RequestBody TravelPlan plan){
        try{
            String msg = planMgmtService.updateTravelPlan(plan);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{planId}")
    public ResponseEntity<?> removeTravelPlanById(@PathVariable Integer planId){
        try{
            String msg = planMgmtService.deleteTravelPlan(planId);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<?> removeTravelPlanByPlanId(@PathVariable Integer planId,@PathVariable String status){
        try{
            String msg = planMgmtService.changeTravelPlanByStatus(planId,status);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
