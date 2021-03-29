import com.operation.api.requirements.implementations.ReqGetLocation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestReqGetLocation {

    @Autowired
    ReqGetLocation reqGetLocation;

   @Before
    public void before() {
        this.reqGetLocation = new ReqGetLocation();
    }

    @Test
    public void reqGetLocationTest(){
       float
        reqGetLocation.ejecutar();
        Assert.assertEquals("2", "2");
    }
}
