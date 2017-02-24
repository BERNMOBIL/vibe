package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.IBusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private final IBusinessLogic businessLogic;

    public HomeController(IBusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("name", businessLogic.getName());
        return "home";
    }



}