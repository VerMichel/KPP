package org.MyWebService.service.croudService;

import org.MyWebService.cache.ForCache.DryForCache;
import org.MyWebService.cache.ForCache.SolutionForCache;
import org.MyWebService.calculation.*;
import org.MyWebService.service.myService.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CroudService {
    @Autowired
    MyService myService;

    public List<DryMassCalculation> croudCalculation_dry(List<DryForCache> forCacheList_dry) {
        return forCacheList_dry
                .stream()
                .map(d -> myService.calculate_dry(d.getSolutionMass(), d.getPercentage()))
                .collect(Collectors.toList());
    }
    public DoubleSummaryStatistics croudAggregation_dry(List<DryForCache> forCacheList_dry) {
        return croudCalculation_dry(forCacheList_dry)
                .stream()
                .collect(Collectors.summarizingDouble(DryMassCalculation::getDryMassAnswer));
    }


    public List<SolutionMassCalculation> croudCalculation_sol(List<SolutionForCache> forCacheList_sol) {
        return forCacheList_sol
                .stream()
                .map(s -> myService.calculate_sol(s.getDryMass(), s.getPercentage()))
                .collect(Collectors.toList());
    }
    public DoubleSummaryStatistics croudAggregation_sol(List<SolutionForCache> forCacheList_sol) {
        return croudCalculation_sol(forCacheList_sol)
                .stream()
                .collect(Collectors.summarizingDouble(SolutionMassCalculation::getSolutionMassAnswer));
    }
}
