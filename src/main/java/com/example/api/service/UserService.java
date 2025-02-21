package com.example.api.service;

import com.example.api.controller.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private RestTemplate template;

    private static final String URL = "https://jsonplaceholder.typicode.com/users";

    public List<User> getUsers(){

        ResponseEntity<User[]> response  = template.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});

        log.info("Status code: [{}]", response.getStatusCode());
        log.info("Users gotten: [{}]", (Object) response.getBody());

        return Arrays.asList(response.getBody());

    }

    /**
     * This method uses HttpClient to consume the API users.
     *
     * @return an instance of string like json format.
     */
    public String getUsers2() {

        String strResponse = "";

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(URL))
                    .timeout(Duration.ofSeconds(10))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            log.info("Status code: [{}]", response.statusCode());
            log.info("Users gotten through HttpClient: [{}]", response.body());

            strResponse = response.body();

        } catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("Error: [{}]", e.getMessage());
        }

        return strResponse;

    }

}
