package com.operation.api.requirements.implementations;

import com.operation.api.exceptions.InvalidRequestException;
import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.HandleRequirement;
import org.springframework.stereotype.Component;

@Component
public class ReqGetLongestMessageSize extends HandleRequirement<GetMessageRequest, Integer> {

    @Override
    protected Integer run(GetMessageRequest request) {
        //Validation
        if (request == null){
            throw new InvalidRequestException();
        }

        //Excecution
        int longestSize = request.getKenobiMessage().size();
        if(request.getKenobiMessage().size() < request.getSkywalkerMessage().size())
            longestSize = request.getSkywalkerMessage().size();
        if(request.getSkywalkerMessage().size() < request.getSatoMessage().size())
            longestSize = request.getSatoMessage().size();

        return longestSize;
    }
}
