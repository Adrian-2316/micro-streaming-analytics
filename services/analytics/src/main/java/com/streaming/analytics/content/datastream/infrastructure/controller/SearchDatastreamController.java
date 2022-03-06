package com.streaming.analytics.content.datastream.infrastructure.controller;

import com.streaming.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.content.datastream.infrastructure.controller.dto.output.DatastreamOutputDTO;
import com.streaming.analytics.content.datastream.infrastructure.repository.port.SearchDatastreamPort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = {"Datastream"})
@SwaggerDefinition(tags = {@Tag(name = "Datastream", description = "Datastream endpoints")})
@RequestMapping("api/v0/datastream")
@AllArgsConstructor
public class SearchDatastreamController {
  private final SearchDatastreamPort searchDatastreamPort;

  @ApiOperation(value = "Search datastream", notes = "Collect data form datastream database.")
  @GetMapping("search")
  public List<DatastreamOutputDTO> search() {
    List<Datastream> searchDatastream = searchDatastreamPort.search();
    return searchDatastream.stream().map(DatastreamOutputDTO::new).collect(Collectors.toList());
  }
}
