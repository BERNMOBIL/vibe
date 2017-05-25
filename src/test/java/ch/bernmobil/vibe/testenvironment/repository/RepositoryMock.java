package ch.bernmobil.vibe.testenvironment.repository;

import java.util.List;
import org.mockito.Mockito;

/**
 * Base mock repository class
 * @param <E> Entity type
 * @param <R> Repository class type
 */
public abstract class RepositoryMock<E, R> {
    protected R mock;
    protected final List<E> dataSource;


    public RepositoryMock(Class<R> classType, List<E> dataSource){
        mock = Mockito.mock(classType);
        this.dataSource = dataSource;
        configureMock();
    }

    protected abstract void configureMock();

    public R getMock() {
        return mock;
    }

}
