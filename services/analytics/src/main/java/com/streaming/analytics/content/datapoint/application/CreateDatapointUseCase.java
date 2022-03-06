package com.streaming.analytics.content.datapoint.application;

import com.streaming.analytics.content.datapoint.application.port.CreateDatapointPort;
import com.streaming.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.content.datapoint.infrastructure.repository.port.SaveDatapointPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateDatapointUseCase implements CreateDatapointPort {

  private SaveDatapointPort saveDatapointPort;

  @Override
  public Datapoint create(Datapoint datapoint) throws Exception {
    return saveDatapointPort.save(datapoint);
  }
}
