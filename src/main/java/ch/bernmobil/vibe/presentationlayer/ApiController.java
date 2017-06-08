package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.presentationlayer.viewmodel.Converter;
import ch.bernmobil.vibe.presentationlayer.viewmodel.DeparturesViewModel;
import ch.bernmobil.vibe.presentationlayer.viewmodel.ScheduleViewModel;
import ch.bernmobil.vibe.presentationlayer.viewmodel.StopViewModel;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides access to relevant data for the departure view. This controller returns JSON structures
 * for any request.
 */
@RestController
@RequestMapping("api")
public class ApiController {
    @Value("${bernmobil.locale.timezone}")
    public String timezone;

    private final BusinessLogic businessLogic;
    private final Converter converter;

    @Autowired
    public ApiController(BusinessLogic businessLogic, Converter converter) {
        this.businessLogic = businessLogic;
        this.converter = converter;
    }

    /**
     * Get the ten next departures for a selected stop.
     * @param stopId The ID from where the vehicles depart
     * @return JSON object containing all departures with relevant information or, on exception,
     * a HTTP status code corresponding to the error.
     */
    @RequestMapping(value = "/departures/{stopId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity apiDepartures(@PathVariable("stopId") UUID stopId,
                                                          @RequestParam(name = "size", defaultValue = "10") int pageSize) {
        return getDepartures(stopId, LocalTime.now(ZoneId.of(timezone)), pageSize);
    }

    /**
     * Get the ten next departures for a selected stop at a specific time.
     * @param stopId The ID from where the vehicles depart
     * @param time A time string formatted as HH:mm
     * @return JSON object containing all departures with relevant information or, on exception,
     * a HTTP status code corresponding to the error.
     */
    @RequestMapping(value ="/departures/{stopId}/at/{time}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity apiDeparturesAtTime(@PathVariable("stopId")UUID stopId,
                                                                   @PathVariable("time") String time,
                                                                   @RequestParam(name = "size", defaultValue = "10") int pageSize) {
        LocalTime localTime;
        try {
            localTime = LocalTime.parse(time);
        } catch (DateTimeParseException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return getDepartures(stopId, localTime, pageSize);
    }

    private ResponseEntity getDepartures(UUID stopId, LocalTime localTime, int pageSize) {
        Stop stop = businessLogic.getStopById(stopId);
        if(stop == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This id does not exist anymore.");
        }
        stop = businessLogic.getNewestStopEntity(stop);
        List<ScheduleViewModel> nextDepartures =
                converter.convertScheduleList(businessLogic.getDeparturesByStopId(stop.getId(), localTime, pageSize));
        StopViewModel stopViewModel = converter.convertStop(businessLogic.getStopById(stop.getId()));
        DeparturesViewModel viewModel = new DeparturesViewModel(stopViewModel, nextDepartures);
        return ResponseEntity.ok(viewModel);
    }
}
