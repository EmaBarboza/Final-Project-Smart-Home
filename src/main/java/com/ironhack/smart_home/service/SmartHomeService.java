package com.ironhack.smart_home.service;

//import com.ironhack.smart_home.exception.SmartHomeApiException;
//import com.scorsaro.hellorc.model.WordDefinition;
//import com.scorsaro.hellorc.exception.DictionaryApiException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClient;
//
//import java.util.List;
//
//@Service
//public class SmartHomeService {
//
//    private final RestClient restClient;
//
//    public SmartHomeService(RestClient.Builder builder, @Value("https://api.open-meteo.com/v1/forecast?" +
//            "latitude=52.52&longitude=13.41" +
//            "&current=temperature_2m," +
//            "wind_speed_10m&hourly=temperature_2m," +
//            "relative_humidity_2m," +
//            "wind_speed_10m") String baseUrl) {
//        this.restClient = builder
//                .baseUrl(baseUrl)
//                .build();
//    }
//
//    public List<WordDefinition> getWordDefinition(String word) {
//        return restClient.get()
//                .uri("/entries/en/{word}", word)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
//                    throw new SmartHomeApiException("Word not found", HttpStatus.NOT_FOUND);
//                })
//                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
//                    throw new SmartHomeApiException("Dictionary API is currently unavailable", HttpStatus.SERVICE_UNAVAILABLE);
//                })
//                .body(new ParameterizedTypeReference<List<WordDefinition>>() {});
//    }
//
//    public String getApiStatus() {
//        return restClient.get()
//                .uri("/")
//                .retrieve()
//                .toBodilessEntity()
//                .getStatusCode()
//                .is2xxSuccessful() ? "UP" : "DOWN";
////    }
//}
