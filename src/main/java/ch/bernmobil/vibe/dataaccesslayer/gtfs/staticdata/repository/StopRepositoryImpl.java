package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class StopRepositoryImpl implements StopRepositoryCustom {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Stop> findAllByUpdateAndName(Timestamp update, String name) {
        Query query = entityManager.createNativeQuery("SELECT * FROM stop WHERE update = :update AND upper(name) LIKE :name ORDER BY name ASC", Stop.class)
            .setParameter("name", "%" + name.toUpperCase() + "%")
            .setParameter("update", update);

        List<Stop> result = query.getResultList();
        return result;

    }
}
