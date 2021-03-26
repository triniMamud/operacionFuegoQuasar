package com.operation.api.requirements.implementations;

import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.HandleRequirement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReqGetMessage extends HandleRequirement<GetMessageRequest, String> {

    @Override
    protected String run(GetMessageRequest request) {
        ArrayList<String> kenobiMessage = request.getMessages().get(0);
        ArrayList<String> skywalkerMessage = request.getMessages().get(1);
        ArrayList<String> satoMessage = request.getMessages().get(2);

        List<String> concatedMessage = Stream.concat(kenobiMessage.stream(),Stream.concat(skywalkerMessage.stream(), satoMessage.stream())).collect(Collectors.toList());

        return String.join(" ", concatedMessage.stream().distinct().collect(Collectors.toList()));

    }
}
