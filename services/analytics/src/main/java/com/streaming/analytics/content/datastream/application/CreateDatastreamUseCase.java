package com.streaming.analytics.content.datastream.application;

import com.streaming.analytics.content.datastream.application.port.CreateDatastreamPort;
import com.streaming.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.content.datastream.infrastructure.repository.port.SaveDatastreamPort;
import com.streaming.analytics.content.statistics.domain.Statistics;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateDatastreamUseCase implements CreateDatastreamPort {

  private SaveDatastreamPort saveDatastreamPort;

  @Override
  public Datastream create(Datastream datastream) throws Exception {
    setRelatedEntities(datastream);
    return saveDatastreamPort.save(datastream);
  }

  private void setRelatedEntities(Datastream datastream) {
    if (datastream.getDatapointList() != null && !datastream.getDatapointList().isEmpty()) {
      Statistics statistics = new Statistics();
      datastream.setStatistics(statistics.calculate(datastream.getDatapointList()));
    }
  }
}
