package com.streaming.analytics.analytics.content.datapoint.domain;


import com.streaming.analytics.analytics.content.shared.Auditable;
import lombok.*;

import static com.streaming.analytics.analytics.content.shared.ObjectUtil.copyProperties;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Datapoint extends Auditable {

    private Long from;
    private Long at;
    private Double value;

    private DatapointJpa datapointJpa;

    public Datapoint(DatapointJpa datapointJpa) {
        if (datapointJpa == null) return;
        this.datapointJpa = datapointJpa;
        this.setAt(datapointJpa.getAt());
        this.setFrom(datapointJpa.getFrom());
        this.setValue(datapointJpa.getValue());
    }

    public void update(Datapoint datapoint) {
        copyProperties(
                datapoint,
                this,
                new String[]{"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"});
    }
}
