package cm.adacorp.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/index")
    public String home(Model model){
        model.addAttribute("message-test","Hi test offline Thymeleaf");
        return "index2";
    }
}
