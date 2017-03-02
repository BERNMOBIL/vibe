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
@RequestMapping("departures")
public class DepartureController {

    @Autowired
    private final BusinessLogic businessLogic;

    public DepartureController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }


    @RequestMapping("/{departureName}")
    public String departures(Model model, @PathVariable("departureName") String departureName) {
        List<StopTime> nextDepartures = businessLogic.getNextDeparturesByStopName(departureName);

        model.addAttribute("departure", departureName);
        model.addAttribute("nextDepartures", nextDepartures);

        return "departureOverview";
    }



}