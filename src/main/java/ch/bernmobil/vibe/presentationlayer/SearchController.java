package ch.bernmobil.vibe.presentationlayer;

import static java.util.stream.Collectors.toList;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/search")
public class SearchController {
    private final BusinessLogic businessLogic;

    @Autowired
    public SearchController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @RequestMapping(value = "/{stopName}", method = RequestMethod.GET)
    public String searchStop(Model model, @PathVariable("stopName") String stopName) {
        List<Stop> stopList = businessLogic.findStops(stopName);
        model.addAttribute("stopList", stopList);
        return "home";
    }

    @RequestMapping(value = "/delays", method = RequestMethod.GET)
    public String searchDelays(Model model) {
        Collection<ScheduleUpdate> allUpdates = businessLogic.getAllScheduleUpdates();
        LocalTime now = LocalTime.now();

        List<ScheduleUpdate> actualDelays = allUpdates
            .stream()
            .filter(u -> u.getActualDeparture() != null && u.getActualDeparture().isAfter(now))
            .sorted((u1, u2) -> u1.getActualDeparture().isAfter(u2.getActualDeparture()) ? 1 : -1)
            .collect(toList());


        model.addAttribute("delays", actualDelays);
        return "delays";
    }
}