package com.service.tac.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {
    Info info = new Info()
        .title("TAC SWAGGER")
        .version(springdocVersion)
        .description("금융상품을 나의 소비 정보를 기반으로 경험 및 비교해 볼 수 있는 서비스");

    return new OpenAPI()
        .components(new Components())
        .info(info);
  }
}