package com.streaming.analytics.content.datastream.infrastructure.repository.port;

import com.streaming.analytics.content.datastream.domain.Datastream;

public interface SaveDatastreamPort {
  Datastream save(Datastream datastream) throws Exception;
}
