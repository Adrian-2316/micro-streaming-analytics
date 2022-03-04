package com.streaming.analytics.analytics.content.datapoint.infrastructure.controller;


import com.streaming.analytics.analytics.content.datapoint.application.port.CreateDatapointPort;
import com.streaming.analytics.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.analytics.content.datapoint.infrastructure.controller.dto.input.DatapointInputDTO;
import com.streaming.analytics.analytics.content.datapoint.infrastructure.controller.dto.output.DatapointOutputDTO;
import com.streaming.analytics.analytics.content.datapoint.infrastructure.controller.dto.output.SimpleDatapointOutputDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = {"Datapoint"})
@SwaggerDefinition(tags = {
        @Tag(name = "Datapoint", description = "Datapoint endpoints")
})
@RequestMapping("api/v0/datapoints")
public class CreateDatapointController {

    private CreateDatapointPort createDatapointPort;

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public SimpleDatapointOutputDTO create(
            @RequestParam(name = "style", defaultValue = "full") String style,
            @RequestBody DatapointInputDTO datapointInputDTO)
            throws Exception {
        Datapoint datapoint =
                datapointInputDTO.datapoint(new Datapoint());
        Datapoint createdDatapoint =
                createDatapointPort.create(datapoint);
        return getDTO(createdDatapoint, style);
    }

    private SimpleDatapointOutputDTO getDTO(Datapoint datapoint, String style) {
        return style.equals("simple")
                ? new SimpleDatapointOutputDTO(datapoint)
                : new DatapointOutputDTO(datapoint);
    }
}

