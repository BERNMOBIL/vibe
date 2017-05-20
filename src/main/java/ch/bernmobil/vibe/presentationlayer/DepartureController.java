package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.time.LocalTime;
import java.time.ZoneId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("departures")
public class DepartureController {
    @Value("${bernmobil.locale.timezone}")
    public String timezone;

    private final BusinessLogic businessLogic;

    @Autowired
    public DepartureController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }


    @RequestMapping("/static/{stopId}")
    public String departures(Model model, @PathVariable("stopId") UUID stopId) {
        List<Schedule> nextDepartures = businessLogic.getDeparturesByStopId(stopId,
            LocalTime.now(ZoneId.of(timezone)));
        Stop stop = businessLogic.getStopById(stopId);
        model.addAttribute("departure", stop.getName());
        model.addAttribute("nextDepartures", nextDepartures);

        return "departureOverview";
    }

    @RequestMapping("/static/{stopId}/at/{time}")
    public String departuresAtTime(Model model,
            @PathVariable("stopId")UUID stopId,
            @PathVariable("time") String time) {
        LocalTime localTime = LocalTime.parse(time);
        List<Schedule> nextDepartures = businessLogic.getDeparturesByStopId(stopId, localTime);
        Stop stop = businessLogic.getStopById(stopId);
        model.addAttribute("departure", stop.getName());
        model.addAttribute("nextDepartures", nextDepartures);

        return "departureOverview";
    }

    @RequestMapping("/{stopId}")
    public String getHtml(@PathVariable("stopId") UUID stopId) {
        Stop stop = businessLogic.getStopById(stopId);
        Stop newStop = businessLogic.getLatestStop(stop);
        if(newStop.equals(stop)) {
            return "nextDepartures";
        }
        return "redirect:/" + newStop.getId();
    }
}