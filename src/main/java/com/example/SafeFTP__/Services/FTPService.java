package com.example.SafeFTP__.Services;


import com.example.SafeFTP__.Models.RegistrationModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FTPService {

    private final HttpService httpService;

    public FTPService(HttpService httpService) {
        this.httpService = httpService;
    }

    public Mono<String> register(RegistrationModel registrationModel) {
        var url = "search";
        return httpService.post(url, registrationModel)
                .onErrorMap(error -> {
                    throw new RuntimeException("Error during registration", error);
                });
    }



}
