package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.RouteMockData;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Route;
import ch.bernmobil.vibe.dataaccesslayer.repository.RouteRepository;


public class RouteRepositoryMock extends RepositoryMock<Route, RouteRepository>{

    public RouteRepositoryMock(){
        super(RouteRepository.class, RouteMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}