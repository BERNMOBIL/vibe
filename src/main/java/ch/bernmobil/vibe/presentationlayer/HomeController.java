package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    private final BusinessLogic businessLogic;

    @Autowired
    public HomeController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/search/{stopName}")
    public String searchStop(Model model, @PathVariable("stopName") String stopName) {
        List<Stop> stopList = businessLogic.findStops(stopName);
        model.addAttribute("stopList", stopList);
        return "home";
    }
}