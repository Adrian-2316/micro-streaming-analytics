package com.streaming.device.content.datastream.domain;


import com.streaming.device.content.datapoint.domain.Datapoint;
import com.streaming.device.wrapper.Wrapper;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Datastream implements Serializable {

    private Long id;
    private String feed;
    private List<Datapoint> datapointList;

    public void generateRandomData(Wrapper<Datastream> generatedRandomData) {
        Random rd = new Random();
        this.setId((long) rd.nextInt(9999999));
        this.setFeed("auto_generated_feed");
        List<Datapoint> datapoints = new ArrayList<>();
        for (int i = 0; i < rd.nextInt(10); i++) {
            Datapoint datapoint = new Datapoint();
            final int millisInDay = 24 * 60 * 60 * 1000;
            datapoint.setFrom((long) rd.nextInt(millisInDay));
            datapoint.setAt((long) rd.nextInt(millisInDay));
            datapoint.setValue(rd.nextDouble());
            datapoints.add(datapoint);
        }
        generatedRandomData.setData(this);
        generatedRandomData.getData().setDatapointList(datapoints);
    }
}
