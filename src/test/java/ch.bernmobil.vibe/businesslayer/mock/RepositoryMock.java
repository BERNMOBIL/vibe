package ch.bernmobil.vibe.businesslayer.mock;

import ch.bernmobil.vibe.businesslayer.mock.data.StopTimeMockData;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mock;
import org.mockito.Mockito;

public abstract class RepositoryMock<EntityType, RepositoryType> {
    protected RepositoryType mock;
    protected List<EntityType> dataSource;

    public RepositoryMock(Class<RepositoryType> classType){
        mock = Mockito.mock(classType);
        createDataSource();
        configureMock();
    }

    private void createDataSource() {
        dataSource = new ArrayList<>();

        for(int i = 0; i < StopTimeMockData.ids.length; i++) {
            dataSource.add(getMockObject(i));
        }
    }

    protected abstract EntityType getMockObject(int index);
    protected abstract void configureMock();

    public RepositoryType getMock() {
        return mock;
    }

    public List<EntityType> getDataSource() {
        return dataSource;
    }

}
