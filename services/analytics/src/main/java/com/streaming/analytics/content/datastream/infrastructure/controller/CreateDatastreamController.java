package com.streaming.analytics.content.datastream.infrastructure.controller;

import com.streaming.analytics.content.datastream.application.port.CreateDatastreamPort;
import com.streaming.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.content.datastream.infrastructure.controller.dto.input.DatastreamInputDTO;
import com.streaming.analytics.content.datastream.infrastructure.controller.dto.output.DatastreamOutputDTO;
import com.streaming.analytics.content.datastream.infrastructure.controller.dto.output.SimpleDatastreamOutputDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = {"Datastream"})
@SwaggerDefinition(tags = {@Tag(name = "Datastream", description = "Datastream endpoints")})
@RequestMapping("api/v0/datastreams")
public class CreateDatastreamController {

  private CreateDatastreamPort createDatastreamPort;

  @PostMapping
  @Transactional(rollbackFor = Exception.class)
  public SimpleDatastreamOutputDTO create(
      @RequestParam(name = "style", defaultValue = "full") String style,
      @RequestBody DatastreamInputDTO datastreamInputDTO)
      throws Exception {
    Datastream datastream = datastreamInputDTO.datastream(new Datastream());
    Datastream createdDatastream = createDatastreamPort.create(datastream);
    return getDTO(createdDatastream, style);
  }

  private SimpleDatastreamOutputDTO getDTO(Datastream datastream, String style) {
    return style.equals("simple")
        ? new SimpleDatastreamOutputDTO(datastream)
        : new DatastreamOutputDTO(datastream);
  }
}
