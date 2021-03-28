package models;

import com.operation.api.models.KenobiSatellite;
import com.operation.api.models.Position;
import com.operation.api.models.SatoSatellite;
import com.operation.api.models.SkywalkerSatellite;

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
        skywalkerMessage.add("este");
        skywalkerMessage.add("es");
        skywalkerMessage.add("un");
        skywalkerMessage.add("mensaje");

        ArrayList<String> satoMessage = new ArrayList<>();
        satoMessage.add("");
        satoMessage.add("");
        satoMessage.add("");
        satoMessage.add("es");
        satoMessage.add("");
        satoMessage.add("mensaje");

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

        System.out.println(String.join(" ", array));

    }




}
