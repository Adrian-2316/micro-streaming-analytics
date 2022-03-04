package com.streaming.device.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Wrapper<T> {

    private String version;
    private T data;
}
