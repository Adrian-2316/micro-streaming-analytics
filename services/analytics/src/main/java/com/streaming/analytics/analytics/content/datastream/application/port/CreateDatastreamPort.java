package com.streaming.analytics.analytics.content.datastream.application.port;


import com.streaming.analytics.analytics.content.datastream.domain.Datastream;

public interface CreateDatastreamPort {
    Datastream create(Datastream datastream) throws Exception;
}
