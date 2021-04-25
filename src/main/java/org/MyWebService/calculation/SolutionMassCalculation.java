package org.MyWebService.calculation;

public class SolutionMassCalculation extends Calculation{
    private double solutionMassAnswer;
    public SolutionMassCalculation(double dryMass, double percentage, double solutionMassAnswer) {
        this.dryMass = dryMass;
        this.percentage = percentage;
        this.solutionMassAnswer = solutionMassAnswer;
    }
    public double getDryMass() { return dryMass; }
    public void setDryMatterMass(double dryMass) { this.dryMass = dryMass; }
    public double getSolutionMassAnswer() { return solutionMassAnswer; }
}