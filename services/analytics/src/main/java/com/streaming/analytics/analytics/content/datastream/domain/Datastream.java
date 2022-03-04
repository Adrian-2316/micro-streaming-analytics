package com.streaming.analytics.analytics.content.datastream.domain;


import com.streaming.analytics.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.analytics.content.shared.Auditable;
import lombok.*;

import java.util.List;

import static com.streaming.analytics.analytics.content.shared.ObjectUtil.copyProperties;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Datastream extends Auditable {

    private Long id;
    private String feed;
    private List<Datapoint> datapointList;

    private DatastreamJpa datastreamJpa;

    public Datastream(DatastreamJpa datastreamJpa) {
        if (datastreamJpa == null) return;
        this.datastreamJpa = datastreamJpa;
        this.setId(datastreamJpa.getId());
        this.setFeed(datastreamJpa.getFeed());
        this.setDatapointList(datastreamJpa.getDatapointList());
    }

    public void update(Datastream datastream) {
        copyProperties(
                datastream,
                this,
                new String[]{"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"});
    }
}
