package org.MyWebService.restController;

import org.MyWebService.counter.CounterTotal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterControllerTotal {
    @GetMapping("/countTotal")
    public  int getCount() {
        return CounterTotal.get();
    }
}
