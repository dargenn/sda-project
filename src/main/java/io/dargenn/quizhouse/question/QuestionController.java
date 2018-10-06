package io.dargenn.quizhouse.question;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/questions")
    public String findAll(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "questions";
    }
}
