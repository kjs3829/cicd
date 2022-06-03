package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@AllArgsConstructor
@RestController
public class ProfileController {
    private final Environment environment;

    @GetMapping("/profile")
    public String profile() {
        return Arrays.stream(environment.getActiveProfiles())
                .findFirst()
                .orElse("");
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }
}
