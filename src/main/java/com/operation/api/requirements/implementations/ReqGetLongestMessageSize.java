package com.operation.api.requirements.implementations;

import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.HandleRequirement;
import org.springframework.stereotype.Component;

@Component
public class ReqGetLongestMessageSize extends HandleRequirement<GetMessageRequest, Integer> {

    @Override
    protected Integer run(GetMessageRequest request) {
        int longestSize = request.getMessages().get(0).size();
        if(request.getMessages().get(0).size() > request.getMessages().get(1).size())
            longestSize = request.getMessages().get(1).size();
        if(request.getMessages().get(1).size() > request.getMessages().get(2).size())
            longestSize = request.getMessages().get(2).size();

        return longestSize;
    }
}
