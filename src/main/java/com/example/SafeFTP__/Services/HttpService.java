package com.example.SafeFTP__.Services;

import com.example.SafeFTP__.Models.RegistrationModel;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpService {

    private final WebClient webClient;

    public HttpService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.thecatapi.com/v1/images/").build();
    }

    public Mono<String> post(String url, RegistrationModel registrationModel) {
        return webClient.post()
                .uri(url)
                .bodyValue(registrationModel)
                .retrieve()
                .onStatus(status -> !status.is2xxSuccessful(),
                        response -> Mono.error(new RuntimeException("Registration failed at HTTP level" + response.toString())))
                .bodyToMono(String.class);
    }

    public Mono<String> put(String url, RegistrationModel registrationModel) {
        return webClient.put()
                .uri(url)
                .bodyValue(registrationModel)
                .retrieve()
                .onStatus(status -> !status.is2xxSuccessful(),
                        response -> Mono.error(new RuntimeException("Registration failed at HTTP level" + response.toString())))
                .bodyToMono(String.class);
    }

    public Mono<String> delete(String url, Object token) {
        return webClient.post()
                .uri(url)
                .bodyValue(token)
                .retrieve()
                .onStatus(status -> !status.is2xxSuccessful(),
                        response -> Mono.error(new RuntimeException("Registration failed at HTTP level" + response.toString())))
                .bodyToMono(String.class);
    }

    public Mono<String> postFile(String url, Object file) {
        return webClient.post()
                .uri(url)
                .bodyValue(file)
                .retrieve()
                .onStatus(status -> !status.is2xxSuccessful(),
                        response -> Mono.error(new RuntimeException("Registration failed at HTTP level" + response.toString())))
                .bodyToMono(String.class);
    }
}
