package com.streaming.analytics.content.datapoint.infrastructure.repository.port;

import com.streaming.analytics.content.datapoint.domain.Datapoint;

import java.util.List;

public interface SearchDatapointPort {
  List<Datapoint> search();
}
