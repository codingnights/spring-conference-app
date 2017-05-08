package com.capgemini.codingnight;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

//@Controller
@RestController
@EnableAutoConfiguration
public class SampleController {

//    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

//    @RequestMapping("/haas")
    @ResponseBody
    public String fooBar() {
        return "Haaaa";
    }

    /**
     *  Request Example: http://localhost:8080/Hello/Wesley?number=1
     * @param name
     * @param number
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/Hello/{name}")
    public Response hello (@PathVariable String name, @RequestParam int number) throws JsonProcessingException {
        System.out.println(name + ": " + number);
        
        return "Wesley".equals(name) ?  new Hello2(name) :  new Hello();
    }
}


interface Response {

}

class Hello2 implements Response {
    private String bar;
    private String foo;
    public String name;

    public Hello2 () {
        bar = "foo";
        foo = "bar";
    }

    public Hello2 (String name) {
        this.name = name;
    }

    public String getFoo() {
        return foo;
    }
}

class Hello implements Response {

    private String bar;
    private String foo;

    public Hello () {
        foo = "foo";
        bar = "bar";
    }

    public String getFoo() {
        return foo;
    }
}