package ch.bernmobil.vibe.testenvironment.data;

import java.util.List;

public abstract class TestData<T> {
    protected List<T> dataSource;

    public List<T> getDataSource() {
        return dataSource;
    }

    public T get(int index) {
        return dataSource.get(index);
    }
}
