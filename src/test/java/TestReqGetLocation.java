import com.operation.api.exceptions.InvalidRequestException;
import com.operation.api.exceptions.PositionNotFoundException;
import com.operation.api.requirements.implementations.ReqGetLocation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TestReqGetLocation {

    @InjectMocks
    private ReqGetLocation reqGetLocation;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test (expected = PositionNotFoundException.class)
    public void verifyPositionNotFoundError(){

        Float[] distances = {200f, 300f, 500f};
        reqGetLocation.ejecutar(distances);
    }

    @Test (expected = InvalidRequestException.class)
    public void verifyRunError(){
        reqGetLocation.ejecutar(null);
    }
}
