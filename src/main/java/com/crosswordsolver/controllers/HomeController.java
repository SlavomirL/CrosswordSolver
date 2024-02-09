package com.crosswordsolver.controllers;

import com.crosswordsolver.services.CrosswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/crossword-solver")
public class HomeController {

    private final CrosswordService crosswordService;

    @GetMapping("/home")
    public String displayCrosswordSolverHomePage() {
        return "home-view";
    }

    @PostMapping("home")
    public String selectWordLength(@RequestParam(name = "wordLength", required = false) Integer wordLength, RedirectAttributes redirectAttributes) {
        String displayString = crosswordService.testMethod(wordLength);
        System.out.println(displayString);
        redirectAttributes.addFlashAttribute("stringToShow", displayString);


        return "redirect:/crossword-solver/home";
    }

}