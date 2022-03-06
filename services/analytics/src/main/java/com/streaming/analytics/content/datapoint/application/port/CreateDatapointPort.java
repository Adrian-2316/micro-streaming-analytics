package com.streaming.analytics.content.datapoint.application.port;

import com.streaming.analytics.content.datapoint.domain.Datapoint;

public interface CreateDatapointPort {
  Datapoint create(Datapoint datapoint) throws Exception;
}
