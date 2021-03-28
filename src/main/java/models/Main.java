package models;

import com.operation.api.models.*;
import com.operation.api.requirements.implementations.ReqGetLongestMessageSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> kenobiMessage = new ArrayList<>();
        kenobiMessage.add("");
        kenobiMessage.add("");
        kenobiMessage.add("este");
        kenobiMessage.add("");
        kenobiMessage.add("un ");
        kenobiMessage.add("mensaje");

        ArrayList<String> skywalkerMessage = new ArrayList<>();
        skywalkerMessage.add("");
        skywalkerMessage.add("");
        skywalkerMessage.add("");
        skywalkerMessage.add("este");
        skywalkerMessage.add("es");
        skywalkerMessage.add("un");
        skywalkerMessage.add("mensaje");

        ArrayList<String> satoMessage = new ArrayList<>();
        System.out.println(satoMessage.isEmpty()
                );

        int longest = kenobiMessage.size();
        if(kenobiMessage.size() < skywalkerMessage.size())
            longest = skywalkerMessage.size();
        if(skywalkerMessage.size() < satoMessage.size())
            longest = satoMessage.size();

        System.out.println(longest);

        while (kenobiMessage.size() < longest) {
            kenobiMessage.add(0, "");
        }
        while (skywalkerMessage.size() < longest) {
            skywalkerMessage.add(0, "");
        }
        while (satoMessage.size() < longest) {
            satoMessage.add(0, "");
        }
        System.out.println(kenobiMessage);
        System.out.println(skywalkerMessage);
        System.out.println(satoMessage);

        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < longest; i++) {
            if (kenobiMessage.get(i) != "")
                array.add(kenobiMessage.get(i));
            else if (skywalkerMessage.get(i) != "")
                array.add(skywalkerMessage.get(i));
            else if (satoMessage.get(i) != "")
                array.add(satoMessage.get(i));
        }


        String shipMessage = null;
        Position shipPosition = Position.builder().build();

        GetMessageRequest getMessageRequest = GetMessageRequest
                .builder()
                .kenobiMessage(body.getSatellites().get(0).getMessage())
                .skywalkerMessage(body.getSatellites().get(1).getMessage())
                .satoMessage(body.getSatellites().get(2).getMessage())
                .build();

        Float[] distances = {
                body.getSatellites().get(0).getDistance(),
                body.getSatellites().get(1).getDistance(),
                body.getSatellites().get(2).getDistance(),
        };

        shipMessage = reqGetMessage.ejecutar(getMessageRequest);
        shipPosition = reqGetLocation.ejecutar(distances);

        DataShipResponse dataShipResponse = DataShipResponse.builder().message(shipMessage).position(shipPosition).build();

        if (dataShipResponse == null)
            return ResponseEntity.status(404).build();

        return ResponseEntity.ok(dataShipResponse);


    }




}
