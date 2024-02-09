package com.crosswordsolver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrosswordService {

    public String testMethodConcat(List<String> letters) {
        StringBuilder sb = new StringBuilder();
        for (String letter: letters) {
            if(letter.equals(" ") || letter == null || letter.isBlank()) {
                sb.append("_");
            } else {
                sb.append(letter);
            }
        }
        return sb.toString();
    }
}
