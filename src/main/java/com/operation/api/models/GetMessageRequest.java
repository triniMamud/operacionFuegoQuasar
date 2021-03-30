package com.operation.api.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class GetMessageRequest {
    private ArrayList<String> kenobiMessage;
    private ArrayList<String> skywalkerMessage;
    private ArrayList<String> satoMessage;

}