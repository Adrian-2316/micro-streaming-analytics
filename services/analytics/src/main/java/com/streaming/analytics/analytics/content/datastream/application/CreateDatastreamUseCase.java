package com.streaming.analytics.analytics.content.datastream.application;


import com.streaming.analytics.analytics.content.datastream.application.port.CreateDatastreamPort;
import com.streaming.analytics.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.analytics.content.datastream.infrastructure.repository.port.SaveDatastreamPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateDatastreamUseCase implements CreateDatastreamPort {

    private SaveDatastreamPort saveDatastreamPort;

    @Override
    public Datastream create(Datastream datastream)
            throws Exception {
        return saveDatastreamPort.save(datastream);
    }
}
