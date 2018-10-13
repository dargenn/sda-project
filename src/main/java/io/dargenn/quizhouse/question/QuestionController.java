package io.dargenn.quizhouse.question;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/questions")
    public String init(Model model) {
        model.addAttribute("questions", questionService.findAll());
        model.addAttribute("question", new Question());
        return "questions";
    }

    @PostMapping(value = "/questions/add")
    public String addQuestion(@Valid Question question, Model model) {
        questionService.save(question);
        return init(model);
    }

    @GetMapping(value = "/questions/remove/{id}")
    public String removeQuestion(@PathVariable Long id, Model model) {
        questionService.deleteById(id);
        return init(model);
    }

    @GetMapping(value = "/questions/edit/{id}")
    public String editQuestion(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        return "questionEdit";
    }

    @PostMapping(value = "/questions/edit")
    public String editQuestion(Question question, Model model) {
        question.getAnswers().forEach(answer -> answer.setQuestion(question));
        questionService.save(question);
        return init(model);
    }
}
