package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    private final BusinessLogic businessLogic;

    @Autowired
    public HomeController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search/{stopName}", method = RequestMethod.GET)
    public String searchStop(Model model, @PathVariable("stopName") String stopName) {
        List<Stop> stopList = businessLogic.findStops(stopName);
        model.addAttribute("stopList", stopList);
        return "home";
    }
}