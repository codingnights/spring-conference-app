package com.capgemini.codingnight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SampleController {

    @Autowired
    private ApplicationContext context;

//    @Autowired
//    private Singleton singleton;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    Test home(@RequestBody(required = false) Test test1) {
        return test1;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    Singleton htome(@RequestParam String value) {
        return (Singleton) context.getBean("singleton");
//        return singleton;
    }
}

class Test {
    public String name = "testclass";
}
