package com.bankonline.service;

import com.bankonline.controller.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

        log.info("Users gotten: [{}]", response.getBody());

        return Arrays.asList(response.getBody());

    }

}
