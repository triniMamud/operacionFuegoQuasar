package com.operation.api.requirements.implementations;

import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.HandleRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ReqGetMessage extends HandleRequirement<GetMessageRequest, String> {

    @Autowired
    ReqGetLongestMessageSize reqGetLongestMessageSize;

    @Override
    protected String run(GetMessageRequest request) {
        ArrayList<String> kenobiMessage = request.getMessages().get(0);
        ArrayList<String> skywalkerMessage = request.getMessages().get(1);
        ArrayList<String> satoMessage = request.getMessages().get(2);

        List<String> message = new ArrayList<>();

        for (int i = 0; i < reqGetLongestMessageSize.run(request); i++) {
            if (kenobiMessage.get(i) != "")
                message.add(kenobiMessage.get(i));
            else if (skywalkerMessage.get(i) != "")
                message.add(skywalkerMessage.get(i));
            else if (satoMessage.get(i) != "")
                message.add(satoMessage.get(i));
        }

        return String.join(" ", message.stream().distinct().collect(Collectors.toList()));

    }
}
