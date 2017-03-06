package ch.bernmobil.vibe.presentationlayer;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Trip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessLogic service;

    @Test
    public void rootMessage() throws Exception {
        String subStringOnPage = "Hello Mock";
        String requestPath = "/";

        when(service.getName()).thenReturn(subStringOnPage);

        mockMvc
                .perform(get(requestPath))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(subStringOnPage)));
    }

    @Test
    public void nextTrip() throws Exception {
        String requestPath = "/nexttrip/Generic Stop";
        StopTime stopTimeMock = new StopTime();
        String mockDeparture = "12:00:00";
        stopTimeMock.setDepartureTime(mockDeparture);
        Trip tripMock = new Trip();
        String mockStopName = "Concrete Stop";
        tripMock.setTripHeadsign(mockStopName);
        List<StopTime> expected = Collections.singletonList(stopTimeMock);
        when(service.getNextDeparturesByStopName(Mockito.anyString())).thenReturn(expected);
        mockMvc
                .perform(get(requestPath))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().string(containsString(mockDeparture)));

    }
}
