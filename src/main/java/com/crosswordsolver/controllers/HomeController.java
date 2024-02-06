package com.crosswordsolver.controllers;

import com.crosswordsolver.services.CrosswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/crossword-solver")
public class HomeController {

    private final CrosswordService crosswordService;

    @GetMapping("/home")
    public String displayCrosswordSolverHomePage() {
        return "home-view";
    }

}