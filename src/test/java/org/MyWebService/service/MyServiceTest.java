package org.MyWebService.service;

import org.MyWebService.calculation.DryMassCalculation;
import org.MyWebService.calculation.SolutionMassCalculation;
import org.MyWebService.service.myService.MyService;
import org.junit.Assert;
import org.junit.Test;

public class MyServiceTest {


    @Test
    public void calculate1() throws Exception {
        MyService myService = new MyService();
       DryMassCalculation trueAnswer = myService.calculate_dry(200, 25);
        Assert.assertEquals(50, trueAnswer.getDryMassAnswer(),0);

    }
    @Test
    public void calculate2() throws Exception {
        MyService myService = new MyService();
        SolutionMassCalculation trueAnswer = myService.calculate_sol(50, 20);
        Assert.assertEquals(250, trueAnswer.getSolutionMassAnswer(),0);
    }
}

