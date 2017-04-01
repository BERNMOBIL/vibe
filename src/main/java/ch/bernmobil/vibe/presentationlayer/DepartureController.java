package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.time.LocalTime;
import java.time.ZoneId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("departures")
public class DepartureController {

    private final BusinessLogic businessLogic;

    @Autowired
    public DepartureController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }


    @RequestMapping("/{stopId}")
    public String departures(Model model, @PathVariable("stopId") long stopId) {
        List<Schedule> nextDepartures = businessLogic.getDeparturesByStopId(stopId, LocalTime.now(
            ZoneId.of("Europe/Paris")));
        Stop stop = businessLogic.getStopById(stopId);
        model.addAttribute("departure", stop.getName());
        model.addAttribute("nextDepartures", nextDepartures);

        return "departureOverview";
    }

    @RequestMapping("/{stopId}/at/{time}")
    public String departuresAtTime(Model model,
            @PathVariable("stopId")long stopId,
            @PathVariable("time") String time) {
        LocalTime localTime = LocalTime.parse(time);
        List<Schedule> nextDepartures = businessLogic.getDeparturesByStopId(stopId, localTime);
        Stop stop = businessLogic.getStopById(stopId);
        model.addAttribute("departure", stop.getName());
        model.addAttribute("nextDepartures", nextDepartures);

        return "departureOverview";
    }
}