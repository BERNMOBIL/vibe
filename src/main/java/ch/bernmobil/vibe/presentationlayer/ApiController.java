package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.presentationlayer.viewmodel.DeparturesViewModel;
import ch.bernmobil.vibe.presentationlayer.viewmodel.Converter;
import ch.bernmobil.vibe.presentationlayer.viewmodel.ScheduleViewModel;
import ch.bernmobil.vibe.presentationlayer.viewmodel.StopViewModel;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {
    @Value("${bernmobil.locale.timezone}")
    public String timezone;

    private final BusinessLogic businessLogic;

    @Autowired
    public ApiController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @RequestMapping("departures/{stopId}")
    public DeparturesViewModel departures(@PathVariable("stopId") UUID stopId) {
        List<ScheduleViewModel> nextDepartures = Converter
            .convertScheduleList(businessLogic
                .getDeparturesByStopId(stopId, LocalTime.now(ZoneId.of(timezone))));
        StopViewModel stop = Converter.convertStop(businessLogic.getStopById(stopId));
        return new DeparturesViewModel(stop, nextDepartures);
    }

    @RequestMapping("departures/{stopId}/at/{time}")
    public ResponseEntity<DeparturesViewModel> departuresAtTime(@PathVariable("stopId")UUID stopId, @PathVariable("time") String time) {
        LocalTime localTime;
        try {
            localTime = LocalTime.parse(time);
        } catch (DateTimeParseException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        List<ScheduleViewModel> nextDepartures = Converter
            .convertScheduleList(businessLogic
                .getDeparturesByStopId(stopId, localTime));
        StopViewModel stop = Converter.convertStop(businessLogic.getStopById(stopId));
        DeparturesViewModel viewModel = new DeparturesViewModel(stop, nextDepartures);
        return ResponseEntity.ok(viewModel);
    }
}