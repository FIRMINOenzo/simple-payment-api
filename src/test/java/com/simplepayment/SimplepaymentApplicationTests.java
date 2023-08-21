package com.simplepayment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimplepaymentApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnATransfer() {
        ResponseEntity<String> response = restTemplate.getForEntity("/transfer/1", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());

        Number id = documentContext.read("$.id");
        assertThat(id).isEqualTo(1);

        Number sender_id = documentContext.read("$.sender.id");
        assertThat(sender_id).isEqualTo(1);

        Number receiver_id = documentContext.read("$.receiver.id");
        assertThat(receiver_id).isEqualTo(2);
    }

    @Test
    void shouldReturnANotFoundGetForTransfer() {
        ResponseEntity<String> response = restTemplate.getForEntity("/transfer/10000", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
