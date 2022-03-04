package com.streaming.analytics.analytics.content.datapoint.infrastructure.repository.port;

import com.streaming.analytics.analytics.content.datapoint.domain.Datapoint;

public interface FindDatapointPort {
    Datapoint findById(String id) throws Exception;
}
