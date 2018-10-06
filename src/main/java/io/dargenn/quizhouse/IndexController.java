package io.dargenn.quizhouse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(Model model) {
        System.out.println("fhuewhiufhw");
        model.addAttribute("tekst", "jkefhwiuhfiewhiufhiwh");
        return "index";
    }
}
