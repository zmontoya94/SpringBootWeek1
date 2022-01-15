package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchJeepTest extends FetchJeepTestSupport {

  @Test
  void testQuary() {

    JeepModel model = JeepModel.GLADIATOR;
    String trim = "Rubicon";
    String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
    ResponseEntity<Jeep> response = getRestTemplate().getForEntity(uri, Jeep.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
