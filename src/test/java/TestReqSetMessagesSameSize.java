import com.operation.api.controllers.TopsecretApiController;
import com.operation.api.exceptions.InvalidRequestException;
import com.operation.api.models.GetMessageRequest;
import com.operation.api.requirements.implementations.ReqGetMessage;
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
public class TestReqSetMessagesSameSize {
    @InjectMocks
    private TopsecretApiController controller;
    @InjectMocks
    private ReqSetMessagesSameSize reqSetMessagesSameSize;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyOkRun(){
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

        GetMessageRequest result = reqSetMessagesSameSize.ejecutar(getMessageRequest);

        Assert.assertEquals(7, result.getKenobiMessage().size());
        Assert.assertEquals(7, result.getSkywalkerMessage().size());
        Assert.assertEquals(7, result.getSatoMessage().size());

    }

    @Test (expected = InvalidRequestException.class)
    public void verifyErrorRun(){
        reqSetMessagesSameSize.ejecutar(null);
    }
}
