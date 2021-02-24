package it.academy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMyController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/page2")
    public String Page2() {
        return "page2";
    }
}
