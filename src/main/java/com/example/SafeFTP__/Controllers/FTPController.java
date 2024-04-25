package com.example.SafeFTP__.Controllers;

import com.example.SafeFTP__.Models.RegistrationModel;
import com.example.SafeFTP__.Services.FTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class FTPController {

    private final FTPService ftpService;

    @Autowired
    public FTPController(FTPService ftpService) {
        this.ftpService = ftpService;
    }



    @PostMapping("/register")
    public Mono<ResponseEntity<String>> register(@RequestBody RegistrationModel registrationModel) {
        return ftpService.register(registrationModel)
                .map(result -> result.length() > 0
                        ? ResponseEntity.ok("Registration successful")
                        : ResponseEntity.badRequest().body("Registration failed"))
                .onErrorResume(e -> Mono.just(ResponseEntity.internalServerError().body("An error occurred during registration: " + e.getMessage())));
    }
}

