package com.capgemini.codingnight;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Lazy
@Component
public class Singleton {
    public String name = "A" + new Random().nextInt();
    public LocalDateTime date = LocalDateTime.now();
}
