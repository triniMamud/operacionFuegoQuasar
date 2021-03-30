import com.operation.api.controllers.TopsecretApiController;
import com.operation.api.exceptions.InvalidRequestException;
import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.implementations.ReqGetLongestMessageSize;
import com.operation.api.requirements.implementations.ReqSetMessagesSameSize;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class TestReqGetLongestMessageSize {

    @InjectMocks
    private TopsecretApiController controller;
    @InjectMocks
    private ReqGetLongestMessageSize reqGetLongestMessageSize;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyRunOk (){
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

        int result = reqGetLongestMessageSize.ejecutar(getMessageRequest);

        Assert.assertEquals(7, result);
    }

    @Test (expected = InvalidRequestException.class)
    public void verifyRunError(){
        reqGetLongestMessageSize.ejecutar(null);
    }
}
