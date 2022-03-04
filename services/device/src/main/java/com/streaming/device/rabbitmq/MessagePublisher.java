package com.streaming.device.rabbitmq;


import com.streaming.device.content.datastream.domain.Datastream;
import com.streaming.device.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"Device"})
@SwaggerDefinition(tags = {
        @Tag(name = "Device", description = "Device endpoints")
})
@RequestMapping("api/v0/device")
public class MessagePublisher {

    private final RabbitTemplate template;

    public MessagePublisher(RabbitTemplate template) {
        this.template = template;
    }


    @PostMapping("/signal")
    public void sendSignal(@RequestBody Wrapper<Datastream> data) {
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, data);
    }

    @Scheduled(fixedDelay = 10000)
    @PostMapping("/periodicSignal")
    public void sendSignal() {
        Wrapper<Datastream> generatedRandomData = new Wrapper<>();
        Datastream datastream = new Datastream();
        datastream.generateRandomData(generatedRandomData);
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, generatedRandomData);
    }
}
