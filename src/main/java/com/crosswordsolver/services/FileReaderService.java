package com.crosswordsolver.services;

import java.io.IOException;

public interface FileReaderService {

    String[] loadFileContent() throws IOException;

}