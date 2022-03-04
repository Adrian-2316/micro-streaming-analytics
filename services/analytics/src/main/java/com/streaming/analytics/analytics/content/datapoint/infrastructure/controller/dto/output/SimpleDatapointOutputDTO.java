package com.streaming.analytics.analytics.content.datapoint.infrastructure.controller.dto.output;


import com.streaming.analytics.analytics.content.datapoint.domain.Datapoint;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SimpleDatapointOutputDTO implements Serializable {
    protected Long at;
    protected Long from;
    protected Double value;

    public SimpleDatapointOutputDTO(Datapoint datapoint) {
        this.setAt(datapoint.getAt());
        this.setFrom(datapoint.getFrom());
        this.setValue(datapoint.getValue());
    }
}

