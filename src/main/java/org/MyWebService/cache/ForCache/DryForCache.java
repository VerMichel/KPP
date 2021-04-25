package org.MyWebService.cache.ForCache;

public class DryForCache extends ForCache {
    public DryForCache(double solutionMass, double percentage) {
        this.solutionMass = solutionMass;
        this.percentage = percentage;
    }
    public double getSolutionMass() {
        return solutionMass;
    }
}