package com.streaming.analytics.analytics.content.datastream.domain;


import com.streaming.analytics.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.analytics.content.statistics.domain.Statistics;
import com.streaming.analytics.analytics.shared.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "datastream")
public class DatastreamJpa extends Auditable {

    private Long id;
    private String feed;
    private List<Datapoint> datapointList;
    private Statistics statistics;

    public DatastreamJpa(Datastream datastream) {
        if (datastream == null) return;
        this.setId(datastream.getId());
        this.setFeed(datastream.getFeed());
        this.setDatapointList(datastream.getDatapointList());
        this.setStatistics(datastream.getStatistics());
    }

}
