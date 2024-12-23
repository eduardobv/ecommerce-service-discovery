package com.ecommerce.servicediscovery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EcommerceServiceDiscoveryApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	void eurekaServerShouldStart() {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + port + "/eureka/apps", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}

}
