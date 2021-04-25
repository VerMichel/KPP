package org.MyWebService.cache;

import org.MyWebService.cache.ForCache.DryForCache;
import org.MyWebService.cache.ForCache.SolutionForCache;
import org.MyWebService.restController.RestController;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import java.util.Set;
import java.util.logging.Logger;




@Component
public class Cache {
    private static final Logger logger = Logger.getLogger(String.valueOf(RestController.class));
    private final Map<DryForCache, Double> resultMap_dry = new HashMap<>();

    public Double getResult_dry(DryForCache dryMassCalculation) {
        Double result_dry = resultMap_dry.get(dryMassCalculation);
        if (result_dry != null) {
            logger.info("Received result: " + result_dry);
        }
        return result_dry;
    }

    public void clear_dry() {
        resultMap_dry.clear();
    }

    public Set<DryForCache> getQueries_dry() {
        return resultMap_dry.keySet();
    }

    public void putResult_dry(DryForCache dryMassCalculation, Double result) {
        logger.info("In cache: " + result);
        resultMap_dry.put(dryMassCalculation, result);
    }




    private final Map<SolutionForCache, Double> resultMap_sol = new HashMap<>();
    public Double getResult_sol(SolutionForCache solutionMassCalculation) {
        Double result_solution = resultMap_sol.get(solutionMassCalculation);
        if (result_solution != null) {
            logger.info("Received result: " + result_solution);
        }
        return result_solution;
    }

    public void clear_sol() {
        resultMap_sol.clear();
    }

    public Set<SolutionForCache> getQueries_sol() {
        return resultMap_sol.keySet();
    }

    public void putResult_sol(SolutionForCache solutionMassCalculation, Double result) {
        logger.info("In cache: " + result);
        resultMap_sol.put(solutionMassCalculation, result);
    }
}


