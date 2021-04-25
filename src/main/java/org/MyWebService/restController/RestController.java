package org.MyWebService.restController;

import org.MyWebService.cache.ForCache.DryForCache;
import org.MyWebService.cache.ForCache.SolutionForCache;
import org.MyWebService.calculation.SolutionMassCalculation;
import org.MyWebService.calculation.DryMassCalculation;
import org.MyWebService.exceptions.DataValidationException;
import org.MyWebService.service.myService.MyService;
import org.MyWebService.service.croudService.CroudService;
import org.MyWebService.jpaRepository.AnswersRepository;
import org.MyWebService.entityes.AnswerEntity;
import org.MyWebService.cache.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
//import javax.validation.constraints.Min;
import java.util.List;
import java.util.logging.Logger;

@org.springframework.web.bind.annotation.RestController
public class RestController{
    private static final String FAKE_UNCHECKED_EXCEPTION = "Fake unchecked exception";
    private static final Logger logger = Logger.getLogger(String.valueOf(RestController.class));
    private static final String WRONG_RANGE_ERROR = "Percentage must to be between 0 and 100. Mass must be positive";

    @Autowired
    MyService myService;
    @Autowired
    CroudService croudService;
    @Autowired
    AnswersRepository answersRepository;

    @GetMapping("/getAnswers_dry")
    public List<AnswerEntity> getEmployee(){
        return answersRepository.findAll();
    }

    @PostMapping("/putAnswersDry")
    public void createEmployee_dry() {
        int id = 0;
        Cache cache = myService.getCache();
        for (DryForCache dfc : cache.getQueries_dry()) {
            AnswerEntity entity = new AnswerEntity();
            entity.setAnswerId(id++);
            entity.setAsnwer_value(cache.getResult_dry(dfc));
            answersRepository.save(entity);
        }
        cache.clear_dry();
    }

    @PostMapping("/postFirstDry")
    public ResponseEntity croudAnswer_dry(@RequestBody List<DryForCache> queryList_dry) {
        return ResponseEntity.ok(croudService.croudCalculation_dry(queryList_dry));
    }

    @PostMapping("/postSecondDry")
    public ResponseEntity croudAggregation_dry(@RequestBody List<DryForCache> queryList_dry) {
        return ResponseEntity.ok(croudService.croudAggregation_dry(queryList_dry));
    }

    @GetMapping("/task1")

    public ResponseEntity calculate1(
            @RequestParam double solutionMass,
            @RequestParam double percentage
    )throws DataValidationException{

        DryMassCalculation dryMassCalculation = myService.calculate_dry(solutionMass, percentage);

       if (percentage <= 0 || percentage > 100 || solutionMass <= 0) {
            logger.info(WRONG_RANGE_ERROR);
            throw new DataValidationException();
        }
        if (solutionMass > 9999 || solutionMass > 9999) {
            logger.info(FAKE_UNCHECKED_EXCEPTION);
            throw new RuntimeException();
        }


        return ResponseEntity.ok(dryMassCalculation);
    }










    @PostMapping("/putAnswersSol")
    public void createEmployee_sol() {
        int id = 0;
        Cache cache = myService.getCache();
        for (SolutionForCache sfc : cache.getQueries_sol()) {
            AnswerEntity entity = new AnswerEntity();
            entity.setAnswerId(id++);
            entity.setAsnwer_value(cache.getResult_sol(sfc));
            answersRepository.save(entity);
        }
        cache.clear_dry();
    }

    @PostMapping("/postFirstSol")
    public ResponseEntity croudAnswer_sol(@RequestBody List<SolutionForCache> queryList_sol) {
        return ResponseEntity.ok(croudService.croudCalculation_sol(queryList_sol));
    }

    @PostMapping("/postSecondSol")
    public ResponseEntity croudAggregation_sol(@RequestBody List<SolutionForCache> queryList_sol) {
        return ResponseEntity.ok(croudService.croudAggregation_sol(queryList_sol));
    }

    @GetMapping("/task2")
    public ResponseEntity calculate2(
            @RequestParam double dryMass,
            @RequestParam double percentage
    )throws DataValidationException{
       SolutionMassCalculation solutionMassCalculation = myService.calculate_sol(dryMass, percentage);

        if (percentage <= 0 || percentage > 100 || dryMass <= 0) {
            logger.info(WRONG_RANGE_ERROR);
            throw new DataValidationException();
        }
        if (dryMass > 9999 || dryMass > 9999) {
            logger.info(FAKE_UNCHECKED_EXCEPTION);
            throw new RuntimeException();
        }
        return ResponseEntity.ok(solutionMassCalculation);
    }


}