package ch.bernmobil.vibe.testenvironment;

import static org.mockito.Mockito.mock;

import ch.bernmobil.vibe.service.UpdateTimestampService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ServiceConfiguration {
    @Bean
    @Primary
    public UpdateTimestampService updateTimestampService() {
        return mock(UpdateTimestampService.class);
    }
}
