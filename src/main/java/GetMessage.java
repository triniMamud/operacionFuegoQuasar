import models.requests.GetMessageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetMessage {

    public String getMessage (GetMessageRequest getMessageRequest) {

        ArrayList<String> kenobiMessage = getMessageRequest.getMessages().get(0);
        ArrayList<String> skywalkerMessage = getMessageRequest.getMessages().get(1);
        ArrayList<String> satoMessage = getMessageRequest.getMessages().get(2);

        List<String> concatedMessage = Stream.concat(kenobiMessage.stream(),Stream.concat(skywalkerMessage.stream(), satoMessage.stream())).collect(Collectors.toList());

        return String.join(" ", concatedMessage.stream().distinct().collect(Collectors.toList()));
    }
}
