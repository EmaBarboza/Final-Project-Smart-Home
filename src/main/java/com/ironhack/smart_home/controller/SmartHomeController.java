package com.ironhack.smart_home.controller;

//import com.ironhack.smart_home.service.SmartHomeService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//public class SmartHomeController {
//
//    private final SmartHomeService smartHomeService;
//
//    public DictionaryController(DictionaryService dictionaryService) {
//        this.dictionaryService = dictionaryService;
//    }
//
//    @GetMapping("/define/{word}")
//    public ResponseEntity<List<WordDefinition>> getDefinition(@PathVariable String word) {
//        List<WordDefinition> definitions = dictionaryService.getWordDefinition(word);
//        return ResponseEntity.ok(definitions);
//    }
//
//    @ExceptionHandler(DictionaryApiException.class)
//    public ResponseEntity<String> handleDictionaryApiException(DictionaryApiException e) {
//        return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
//    }
//
//    @GetMapping("/status")
//    public ResponseEntity<String> getApiStatus() {
//        String status = dictionaryService.getApiStatus();
//        return ResponseEntity.ok("Dictionary API Status: " + status);
////    }
//}
