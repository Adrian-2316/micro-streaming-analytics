package com.streaming.analytics.analytics.content.datastream.infrastructure.controller.dto.output;


import com.streaming.analytics.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.analytics.content.datastream.domain.Datastream;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SimpleDatastreamOutputDTO implements Serializable {

    protected Long id;
    protected String feed;
    protected List<Datapoint> datapointList;

    public SimpleDatastreamOutputDTO(Datastream datastream) {
        this.setId(datastream.getId());
        this.setFeed(datastream.getFeed());
        this.setDatapointList(datastream.getDatapointList());
    }
}

