package com.streaming.analytics.analytics.content.datapoint.infrastructure.repository;


import com.streaming.analytics.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.analytics.content.datapoint.domain.DatapointJpa;
import com.streaming.analytics.analytics.content.datapoint.infrastructure.repository.jpa.DatapointRepositoryJpa;
import com.streaming.analytics.analytics.content.datapoint.infrastructure.repository.port.SaveDatapointPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveDatapointRepository implements SaveDatapointPort {

    private DatapointRepositoryJpa datapointRepositoryJpa;

    @Override
    public Datapoint save(Datapoint datapoint) {
        DatapointJpa datapointJpa = new DatapointJpa(datapoint);
        datapointRepositoryJpa.save(datapointJpa);
        return new Datapoint(datapointJpa);
    }
}

