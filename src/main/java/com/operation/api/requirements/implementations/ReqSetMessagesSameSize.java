package com.operation.api.requirements.implementations;

import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.HandleRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ReqSetMessagesSameSize extends HandleRequirement<GetMessageRequest, GetMessageRequest> {

    @Autowired
    ReqGetLongestMessageSize reqGetLongestMessageSize;

    @Override
    protected GetMessageRequest run(GetMessageRequest request) {
        for (int i = 0 ; i < request.getMessages().size(); i++) {
            while (request.getMessages().get(i).size() < reqGetLongestMessageSize.run(request)) {
                request.getMessages().get(i).add(0, "");
            }
        }
        return request;
    }
}
