package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.presentationlayer.dto.Converter;
import ch.bernmobil.vibe.presentationlayer.dto.DeparturesDto;
import ch.bernmobil.vibe.presentationlayer.dto.ScheduleDto;
import ch.bernmobil.vibe.presentationlayer.dto.StopDto;
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
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@RestController
@RequestMapping("api")
public class ApiController {
    @Value("${bernmobil.locale.timezone}")
    private String timezone;

    private final BusinessLogic businessLogic;
    private final Converter converter;

    @Autowired
    public ApiController(BusinessLogic businessLogic, Converter converter) {
        this.businessLogic = businessLogic;
        this.converter = converter;
    }

    /**
     * Get the next ten departures for a selected stop.
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                String.format("%s is not a valid time. A valid time could be \"10:10\" or \"10:15:30\". See ISO-8601 for more details.", time));
        }
        return getDepartures(stopId, localTime, pageSize);
    }

    /**
     * Returns a {@link ResponseEntity} with either the result or a appropriate error message. The
     * method checks, if the given {@link UUID} is valid, if there is a newer version of the {@link Stop}
     * corresponding to the id and then converts all model to DTOs to minimize network overhead.
     * @param stopId of the {@link Stop} to which the departures are searched.
     * @param localTime from which the departures are returned.
     * @param pageSize of the the result.
     * @return {@link ResponseEntity} which either contains a {@link DeparturesDto} or a {@link String}
     * if an error occurred while processing.
     */
    private ResponseEntity getDepartures(UUID stopId, LocalTime localTime, int pageSize) {
        Stop stop = businessLogic.getStopById(stopId);
        if(stop == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Stop with id \"%s\" does not exist.", stopId));
        }
        stop = businessLogic.getNewestStopVersion(stop);
        if(stop == null) {
            return ResponseEntity.status(HttpStatus.GONE)
                .body(String.format("Stop with id \"%s\" is not available anymore. Please do another search for this stop", stopId));
        }
        List<Schedule> departureList = businessLogic.getDeparturesByStopId(stop.getId(), localTime, pageSize);
        List<ScheduleDto> nextDepartures = converter.convertScheduleList(departureList);
        StopDto stopDto = converter.convertStop(stop);
        DeparturesDto viewModel = new DeparturesDto(stopDto, nextDepartures);
        return ResponseEntity.ok(viewModel);
    }
}
