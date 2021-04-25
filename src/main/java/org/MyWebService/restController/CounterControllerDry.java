package org.MyWebService.restController;

import org.MyWebService.counter.CounterDry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterControllerDry {
    @GetMapping("/countDry")
    public  int getCount() {
        return CounterDry.get();
    }
}