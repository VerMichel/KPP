package org.MyWebService.service.myService;

import org.MyWebService.cache.Cache;
import org.MyWebService.cache.ForCache.DryForCache;
import org.MyWebService.cache.ForCache.SolutionForCache;
import org.MyWebService.calculation.DryMassCalculation;
import org.MyWebService.calculation.SolutionMassCalculation;
import org.MyWebService.counter.CounterDry;
import org.MyWebService.counter.CounterSol;
import org.MyWebService.counter.CounterTotal;
import org.MyWebService.restController.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;



@Service
public class MyService {
    private static final Logger logger = Logger.getLogger(String.valueOf(RestController.class));
    @Autowired
    private Cache cache;
    public MyService(){
    }

    public Cache getCache() { return cache; }

    public DryMassCalculation onlyCalculateTesting_dry(double solutionMass, double percentage) {
        return new DryMassCalculation(solutionMass, percentage, Math.abs(solutionMass*percentage)/100);
    }

    public DryMassCalculation calculate_dry(double solutionMass, double percentage) {
        CounterDry.add();
        CounterTotal.add();
        double answer_dry = 0;
        DryForCache forCache = new DryForCache(solutionMass, percentage);
        if (cache.getResult_dry(forCache) != null)
            answer_dry = cache.getResult_dry(forCache);
        else {
            percentage /=100;
            answer_dry = solutionMass*percentage;
            cache.putResult_dry(forCache, answer_dry);
        }
        DryMassCalculation calculation_dry =new DryMassCalculation(solutionMass, percentage, answer_dry);
        logger.info(String.format("Dry mass: %f", calculation_dry.getDryMassAnswer()));
        return calculation_dry;

        }


    public SolutionMassCalculation onlyCalculateTesting_sol(double dryMass, double percentage) {
        return new SolutionMassCalculation(dryMass, percentage, Math.abs(dryMass/percentage)/100);
    }

    public SolutionMassCalculation calculate_sol(double dryMass, double percentage) {
        CounterSol.add();
        CounterTotal.add();
        double answer_sol = 0;
        SolutionForCache forCache = new SolutionForCache(dryMass, percentage);
        if (cache.getResult_sol(forCache) != null)
            answer_sol = cache.getResult_sol(forCache);
        else {
            percentage /=100;
            answer_sol = dryMass/percentage;
            cache.putResult_sol(forCache, answer_sol);
        }
        SolutionMassCalculation calculation_sol = new SolutionMassCalculation(dryMass, percentage, answer_sol);
        logger.info(String.format("Solution mass: %f", calculation_sol.getSolutionMassAnswer()));
        return calculation_sol;

    }
}
