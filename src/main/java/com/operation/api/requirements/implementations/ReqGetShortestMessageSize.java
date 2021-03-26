package com.operation.api.requirements.implementations;

import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.HandleRequirement;

public class ReqGetShortestMessageSize extends HandleRequirement<GetMessageRequest, Integer> {

    @Override
    protected Integer run(GetMessageRequest request) {
        int shortestSize = request.getMessages().get(0).size();
        if(request.getMessages().get(0).size() > request.getMessages().get(1).size())
            shortestSize = request.getMessages().get(1).size();
        if(request.getMessages().get(1).size() > request.getMessages().get(2).size())
            shortestSize = request.getMessages().get(2).size();

        return shortestSize;
    }
}
