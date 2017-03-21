package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
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
    public String home(Model model) {
        model.addAttribute("name", "test");
        return "home";
    }

    @RequestMapping("/nexttrip/{stopName}")
    public String nextTrip(Model model, @PathVariable("stopName") String stopName) {
       // List<ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime> allTrips = businessLogic.getNextDeparturesByStopName(stopName);
        //model.addAttribute("allTrips", allTrips);
        return "home";
    }
}