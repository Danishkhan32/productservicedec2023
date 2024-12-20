package com.scaler.productservicedec2023.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/hello")
public class Hellocontroller {

    @GetMapping("/say/{name}/{times}")
    public String sayHello(@PathVariable("name") String name ,
                           @PathVariable("times") int times) {
       String answer = "" ;
       for (int i = 0; i < times; ++i) {
           answer += "Hello" + name;
           answer += "<br>";
       }
    return answer;

    }
}
