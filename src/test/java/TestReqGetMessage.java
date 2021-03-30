import com.operation.api.controllers.TopsecretApiController;
import com.operation.api.exceptions.AllMessagesAreEmptyException;
import com.operation.api.exceptions.InvalidRequestException;
import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.implementations.ReqGetLocation;
import com.operation.api.requirements.implementations.ReqGetMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestReqGetMessage {

    @InjectMocks
    private TopsecretApiController controller;
    @InjectMocks
    private ReqGetMessage reqGetMessage;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyRunOkMessagesSameSize(){
        ArrayList<String> kenobiMessage = new ArrayList<>();
        kenobiMessage.add("este");
        kenobiMessage.add("");
        kenobiMessage.add("");
        kenobiMessage.add("mensaje");
        kenobiMessage.add("");

        ArrayList<String> skywalkerMessage = new ArrayList<>();
        skywalkerMessage.add("");
        skywalkerMessage.add("es");
        skywalkerMessage.add("");
        skywalkerMessage.add("");
        skywalkerMessage.add("secreto");

        ArrayList<String> satoMessage = new ArrayList<>();
        satoMessage.add("este");
        satoMessage.add("");
        satoMessage.add("un");
        satoMessage.add("");
        satoMessage.add("secreto");

        GetMessageRequest getMessageRequest = GetMessageRequest.builder()
                .kenobiMessage(kenobiMessage)
                .skywalkerMessage(skywalkerMessage)
                .satoMessage(satoMessage)
                .build();

        String result = reqGetMessage.ejecutar(getMessageRequest);
        Assert.assertEquals("este es un mensaje secreto", result);
    }

    @Test
    public void verifyRunOkMessagesDifferentSize(){
        ArrayList<String> kenobiMessage = new ArrayList<>();
        kenobiMessage.add("");
        kenobiMessage.add("");
        kenobiMessage.add("este");
        kenobiMessage.add("");
        kenobiMessage.add("");
        kenobiMessage.add("mensaje");
        kenobiMessage.add("");

        ArrayList<String> skywalkerMessage = new ArrayList<>();
        skywalkerMessage.add("");
        skywalkerMessage.add("");
        skywalkerMessage.add("es");
        skywalkerMessage.add("");
        skywalkerMessage.add("");
        skywalkerMessage.add("secreto");

        ArrayList<String> satoMessage = new ArrayList<>();
        satoMessage.add("este");
        satoMessage.add("");
        satoMessage.add("un");
        satoMessage.add("");
        satoMessage.add("secreto");

        GetMessageRequest getMessageRequest = GetMessageRequest.builder()
                .kenobiMessage(kenobiMessage)
                .skywalkerMessage(skywalkerMessage)
                .satoMessage(satoMessage)
                .build();

        String result = reqGetMessage.ejecutar(getMessageRequest);
        Assert.assertEquals("este es un mensaje secreto", result);
    }

    @Test (expected = InvalidRequestException.class)
    public void verifyRunNullError(){
        reqGetMessage.ejecutar(null);
    }

    @Test (expected = AllMessagesAreEmptyException.class)
    public void verifyRunEmptyRequestError(){
        GetMessageRequest getMessageRequest = GetMessageRequest
                .builder()
                .kenobiMessage(new ArrayList<>())
                .skywalkerMessage(new ArrayList<>())
                .satoMessage(new ArrayList<>())
                .build();
        reqGetMessage.ejecutar(getMessageRequest);
    }

}
