package ch.bernmobil.vibe.presentationlayer;

import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Provides access to the client side template which uses {@link ApiController} to display
 * departures
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Controller
@RequestMapping("departures")
public class DepartureController {

    /**
     * Returns only a static template which then access the {@link ApiController}.
     * @param stopId as a dummy variable which is automatically passed to the front-end.
     * @return {@link String} matching the filename of a template.
     */
    @RequestMapping(value = "/{stopId}", method = RequestMethod.GET)
    public String getHtml(@PathVariable("stopId") UUID stopId) {
        return "nextDepartures";
    }
}