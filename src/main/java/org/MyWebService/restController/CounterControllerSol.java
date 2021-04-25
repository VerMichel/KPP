package org.MyWebService.restController;

import org.MyWebService.counter.CounterSol;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterControllerSol {
    @GetMapping("/countSol")
    public  int getCount() {
        return CounterSol.get();
    }
}