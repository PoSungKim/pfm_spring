package com.pfm.Spring_Backend.service;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestTemplateService {
    // products > 서비스 API > 검색 > 지역

    public String NaverAPI() {

        String query = "갈비집";

        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com").path("/v1/search/local.xml")
                .queryParam("query", query).queryParam("display", 10).queryParam("start", 1)
                .queryParam("sort", "random").encode(StandardCharsets.UTF_8).build().toUri();

        RequestEntity<Void> req = RequestEntity.get(uri).header("X-Naver-Client-Id", "OnGI930GSc14eZu0XVq2")
                .header("X-Naver-Client-Secret", "REip7mhuVT").build();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();
    }
}