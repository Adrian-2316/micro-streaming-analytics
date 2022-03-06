package com.streaming.analytics.analytics.content.datapoint.infrastructure.controller.dto.output;


import com.streaming.analytics.analytics.content.datapoint.domain.Datapoint;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DatapointOutputDTO extends SimpleDatapointOutputDTO
        implements Serializable {

    public DatapointOutputDTO(Datapoint datapoint) {
        super(datapoint);
    }
}

