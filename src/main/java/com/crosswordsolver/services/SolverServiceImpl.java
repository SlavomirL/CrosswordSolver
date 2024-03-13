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
    public List<String> buildWords(List<String> letters) throws IOException {
        List<String> onlyLetters = prepareLetters(letters);
        System.out.println(onlyLetters.toString());
        return wordBuilderService.findWords(onlyLetters);
    }

    @Override
    public List<String> buildAllWords(List<String> letters) throws IOException {
        List<String> onlyLetters = prepareLetters(letters);
        return wordBuilderService.findAllWords(onlyLetters);
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

    @Override
    public List<String> toLowercase(List<String> letters) {
        for (int i = 0; i < letters.size(); i++) {
            String letter = letters.get(i).toLowerCase();
            letters.set(i, letter);
        }
        System.out.println(letters.toString());
        return letters;
    }

    @Override
    public List<String> prepareLetters(List<String> letters) {
        List<String> noBlanks = removeBlanks(letters);
        List<String> allLowercase = toLowercase(noBlanks);
        return allLowercase;
    }

}