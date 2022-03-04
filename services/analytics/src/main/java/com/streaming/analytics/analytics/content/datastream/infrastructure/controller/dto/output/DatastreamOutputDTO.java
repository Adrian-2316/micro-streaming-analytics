package com.streaming.analytics.analytics.content.datastream.infrastructure.controller.dto.output;


import com.streaming.analytics.analytics.content.datastream.domain.Datastream;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DatastreamOutputDTO extends SimpleDatastreamOutputDTO
        implements Serializable {

    public DatastreamOutputDTO(Datastream datastream) {
        super(datastream);

    }
}

