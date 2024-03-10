package com.crosswordsolver.services;

import java.io.IOException;
import java.util.List;

public interface WordBuilderService {
    String[] loadFileContent() throws IOException;

    List<String> findWords(List<String> letters);

    void backtrack(List<String> letters,  int index, StringBuilder path, List<String> result);
}
