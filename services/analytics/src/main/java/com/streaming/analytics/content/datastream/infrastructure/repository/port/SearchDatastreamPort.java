package com.streaming.analytics.content.datastream.infrastructure.repository.port;


import com.streaming.analytics.content.datastream.domain.Datastream;

import java.util.List;

public interface SearchDatastreamPort {
  List<Datastream> search();
}
