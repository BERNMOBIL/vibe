package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.StopTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private final BusinessLogic businessLogic;

    public HomeController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("name", businessLogic.getName());
        return "home";
    }

    @RequestMapping("/nexttrip/{stopName}")
    public String nextTrip(Model model, @PathVariable("stopName") String stopName) {
        List<StopTime> allTrips = businessLogic.getNextDeparturesByStopName(stopName);
        model.addAttribute("allTrips", allTrips);
        return "home";
    }
}