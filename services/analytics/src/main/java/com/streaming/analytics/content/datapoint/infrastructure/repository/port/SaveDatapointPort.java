package com.streaming.analytics.content.datapoint.infrastructure.repository.port;

import com.streaming.analytics.content.datapoint.domain.Datapoint;

public interface SaveDatapointPort {
  Datapoint save(Datapoint datapoint) throws Exception;
}
