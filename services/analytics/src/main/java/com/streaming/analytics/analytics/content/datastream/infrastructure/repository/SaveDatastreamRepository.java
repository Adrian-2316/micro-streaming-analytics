package com.streaming.analytics.analytics.content.datastream.infrastructure.repository;


import com.streaming.analytics.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.analytics.content.datastream.domain.DatastreamJpa;
import com.streaming.analytics.analytics.content.datastream.infrastructure.repository.jpa.DatastreamRepositoryJpa;
import com.streaming.analytics.analytics.content.datastream.infrastructure.repository.port.SaveDatastreamPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveDatastreamRepository implements SaveDatastreamPort {

    private DatastreamRepositoryJpa datastreamRepositoryJpa;


    @Override
    public Datastream save(Datastream datastream) {
        DatastreamJpa datastreamJpa = new DatastreamJpa(datastream);
        datastreamRepositoryJpa.save(datastreamJpa);
        return new Datastream(datastreamJpa);
    }
}

