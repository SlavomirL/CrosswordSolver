package com.crosswordsolver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrosswordService {

    public String testMethod(int wordLength) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < wordLength; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}
