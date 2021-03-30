package com.operation.api.requirements.implementations;

import com.operation.api.exceptions.AllMessagesAreEmptyException;
import com.operation.api.exceptions.InvalidRequestException;
import com.operation.api.exceptions.MessageIncompleteException;
import com.operation.api.exceptions.MessageNotDecoded;
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

    @Override
    protected String run(GetMessageRequest request) {
        //Validations
        if (request == null){
            throw new InvalidRequestException();
        }
        if(request.getKenobiMessage().isEmpty() && request.getSkywalkerMessage().isEmpty() && request.getSatoMessage().isEmpty()){
            throw new AllMessagesAreEmptyException();
        }

        //Excecution
        ReqSetMessagesSameSize reqSetMessagesSameSize = new ReqSetMessagesSameSize();
        ReqGetLongestMessageSize reqGetLongestMessageSize = new ReqGetLongestMessageSize();
        List<String> kenobiMessage = reqSetMessagesSameSize.run(request).getKenobiMessage();
        List<String> skywalkerMessage = reqSetMessagesSameSize.run(request).getSkywalkerMessage();
        List<String> satoMessage = reqSetMessagesSameSize.run(request).getSatoMessage();

        List<String> messageList = new ArrayList<>();

        for (int i = 0; i < reqGetLongestMessageSize.run(request); i++) {
            if (!kenobiMessage.get(i).equals(""))
                messageList.add(kenobiMessage.get(i));
            else if (!skywalkerMessage.get(i).equals(""))
                messageList.add(skywalkerMessage.get(i));
            else if (!satoMessage.get(i).equals(""))
                messageList.add(satoMessage.get(i));
        }

        System.out.println(kenobiMessage);
        System.out.println(skywalkerMessage);
        System.out.println(satoMessage);

        if (messageList.isEmpty()){
            throw new MessageNotDecoded();
        }
        if (messageList.size() != reqGetLongestMessageSize.run(request)){
            throw new MessageIncompleteException();
        }

        return String.join(" ", messageList.stream().distinct().collect(Collectors.toList()));
    }
}
