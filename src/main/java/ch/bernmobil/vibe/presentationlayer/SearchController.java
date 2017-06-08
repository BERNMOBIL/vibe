package ch.bernmobil.vibe.presentationlayer;

import static java.util.stream.Collectors.toList;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller which provides methods to query through the transit data.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Value("${bernmobil.locale.timezone}")
    public String timezone;

    private final BusinessLogic businessLogic;

    @Autowired
    public SearchController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    /**
     * Search for a stop name, or just a substring of the stop name. This method is only for
     * demonstration purposes.
     * @param model which is injected by the framework to be filled with values, which are processed
     * by the Thymeleaf template engine.
     * @param stopName Name or substring of a name.
     * @return Template with all stops which are beginning with the searched string.
     */
    @RequestMapping(value = "/{stopName}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String searchStop(Model model, @PathVariable("stopName") String stopName) {
        List<Stop> stopList = businessLogic.findStops(stopName);
        model.addAttribute("stopList", stopList);
        return "home";
    }

    /**
     * Search for the next delays from now. This method in only for demonstration purposes.
     * @param model which is injected by the framework to be filled with values, which are processed
     * by the Thymeleaf template engine.
     * @return Template with the next delayed departures.
     */
    @RequestMapping(value = "/delays", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String searchDelays(Model model) {
        Collection<ScheduleUpdate> allUpdates = businessLogic.getNextScheduleUpdates();
        LocalTime now = LocalTime.now(ZoneId.of(timezone));

        List<ScheduleUpdate> actualDelays = allUpdates
            .stream()
            .filter(u -> u.getActualDeparture() != null)
            .filter(u -> u.getActualDeparture().isAfter(now))
            .sorted(Comparator.comparing(ScheduleUpdate::getActualDeparture))
            .collect(toList());

        model.addAttribute("delays", actualDelays);
        return "delays";
    }
}