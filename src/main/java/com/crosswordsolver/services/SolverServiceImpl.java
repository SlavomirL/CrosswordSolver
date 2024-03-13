package com.crosswordsolver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolverServiceImpl implements SolverService {

    private final CrosswordService crosswordService;
    private final WordBuilderService wordBuilderService;

    @Override
    public List<String> solveCrossword(Integer wordLength, List<String> letters) {
        String inputString = crosswordService.buildString(letters);
        int lowerIndex = crosswordService.findLowerIndex(wordLength);
        int upperIndex = crosswordService.findUpperIndex(wordLength);
        return crosswordService.findWords(lowerIndex, upperIndex, inputString);
    }

    @Override
    public List<String> buildWord(List<String> letters) throws IOException {
        List<String> onlyLetters = removeBlanks(letters);
        return wordBuilderService.findWords(onlyLetters);
    }

    @Override
    public List<String> removeBlanks(List<String> letters) {
        Iterator<String> iterator = letters.iterator();
        while (iterator.hasNext()) {
            String letter = iterator.next();
            if (letter.isBlank()) {
                iterator.remove();
            }
        }
        return letters;
    }

}