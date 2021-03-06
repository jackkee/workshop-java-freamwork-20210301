package com.example.kbtg.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void success_get_user_id() {
        UserResponse response = restTemplate.getForObject("/user/1", UserResponse.class);
        assertEquals(1, response.getId());
        assertEquals("JacK", response.getName());
        assertEquals(30, response.getAge());

        UserResponse expected = new UserResponse(1, "JacK", 30);
        assertEquals(expected, response);
    }

}