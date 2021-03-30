package com.operation.api.requirements.implementations;

import com.operation.api.exceptions.InvalidRequestException;
import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.HandleRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ReqSetMessagesSameSize extends HandleRequirement<GetMessageRequest, GetMessageRequest> {

    /*@Autowired
    ReqGetLongestMessageSize reqGetLongestMessageSize;*/
    ReqGetLongestMessageSize reqGetLongestMessageSize = new ReqGetLongestMessageSize();

    @Override
    protected GetMessageRequest run(GetMessageRequest request) {
        //Validation
        if (request == null){
            throw new InvalidRequestException();
        }

        //Excecution
        while (request.getKenobiMessage().size() < reqGetLongestMessageSize.run(request)) {
            request.getKenobiMessage().add(0, "");
        }
        while (request.getSkywalkerMessage().size() < reqGetLongestMessageSize.run(request)) {
            request.getSkywalkerMessage().add(0, "");
        }
        while (request.getSatoMessage().size() < reqGetLongestMessageSize.run(request)) {
            request.getSatoMessage().add(0, "");
        }

        return request;
    }
}
