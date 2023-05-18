package idusw.springboot.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HttpSession httpSession;

    @GetMapping("/")
    public String goHome(Model model) {
        return "main/index";
    }

    @GetMapping("/tables")
    public String getTables() { return "admin/tables"; }

    @GetMapping("/buttons")
    public String getButtons() { return "admin/buttons"; }

    @GetMapping("/cards")
    public String getCards() { return "admin/cards"; }
}
