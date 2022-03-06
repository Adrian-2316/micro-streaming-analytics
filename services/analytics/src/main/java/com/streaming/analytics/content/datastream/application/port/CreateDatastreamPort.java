package com.streaming.analytics.content.datastream.application.port;

import com.streaming.analytics.content.datastream.domain.Datastream;

public interface CreateDatastreamPort {
  Datastream create(Datastream datastream) throws Exception;
}
