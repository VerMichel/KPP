package org.MyWebService.calculation;

public class DryMassCalculation extends Calculation{
    private Double dryMassAnswer;

    public DryMassCalculation(double solutionMass, double percentage, double dryMassAnswer) {
        this.solutionMass = solutionMass;
        this.percentage = percentage;
        this.dryMassAnswer = dryMassAnswer;
    }
    public double getSolutionMass() { return solutionMass; }
    public void setSolutionMass(double solutionMass) { this.solutionMass = solutionMass; }
    public double getDryMassAnswer() { return dryMassAnswer.doubleValue(); }
}