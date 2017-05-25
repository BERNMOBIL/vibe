package ch.bernmobil.vibe.testenvironment.repository;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Route;
import ch.bernmobil.vibe.dataaccesslayer.repository.RouteRepository;
import ch.bernmobil.vibe.testenvironment.data.RouteMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteRepositoryMock extends RepositoryMock<Route, RouteRepository>{

    @Autowired
    public RouteRepositoryMock(RouteMockData routeMockData){
        super(RouteRepository.class, routeMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
