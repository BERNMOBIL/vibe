package ch.bernmobil.vibe.businesslayer;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.testenvironment.MockDataConfiguration;
import ch.bernmobil.vibe.testenvironment.RepositoryConfiguration;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ActiveProfiles("TestConfiguration")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class, MockDataConfiguration.class})
public class BusinessLogicTest {

    private BusinessLogic businessLogic;


    @Test
    public void testFindStops() {
        List<Stop> stops = businessLogic.findStops("Rapperswil");
        assertThat(stops.size(), is(2));
    }

    @Autowired
    public void setBusinessLogic(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }
}
