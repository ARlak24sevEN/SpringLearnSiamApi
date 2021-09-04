package com.example.siamtest.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void success_get_user_id_1() {
//        UserResponse result = restTemplate.getForObject("/users/1", UserResponse.class);
//        assertEquals(1, result.getId());
//        assertEquals("Jengweb", result.getName());
//        assertEquals("jengweb@gmail.com", result.getEmail());

        TableUser jengweb = new TableUser(1, "Jengweb", "jengweb@gmail.com");
        when(userRepository.findById(1))
                .thenReturn(Optional.of(jengweb));
        // Test
        UserResponse result
                = restTemplate.getForObject("/users/1", UserResponse.class);
        assertEquals(1, result.getId());
        assertEquals("Jengweb", result.getName());
        assertEquals("jengweb@gmail.com", result.getEmail());
    }

}