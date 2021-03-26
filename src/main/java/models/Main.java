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
        kenobiMessage.add("un");
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



        List<String> shipPositions = IntStream
                .range(0, satoMessage.size())
                .filter(i -> skywalkerMessage.contains(satoMessage.get(i)))
                .mapToObj(i -> satoMessage.get(i))
                .collect(Collectors.toList());

        System.out.println(shipPositions);

        ArrayList<Position> kenobiDiameter = new ArrayList<>();
        ArrayList<Position> skywalkerDiameter = new ArrayList<>();
        ArrayList<Position> satoDiameter = new ArrayList<>();

        KenobiSatellite kenobiSatellite = new KenobiSatellite(900);
        SkywalkerSatellite skywalkerSatellite = new SkywalkerSatellite(900);
        SatoSatellite satoSatellite = new SatoSatellite(900);

        Position currentCoordinateKenobi = Position.builder().build();
        Position currentCoordinateSkywalker = Position.builder().build();
        Position currentCoordinateSato = Position.builder().build();

        for (int i = 0; i < 360; i++) {
            currentCoordinateKenobi.setX((kenobiSatellite.getPosition().getX() + (float)(Math.cos(i)*kenobiSatellite.getDistance())));
            currentCoordinateKenobi.setY((kenobiSatellite.getPosition().getY() + (float)(Math.sin(i)*kenobiSatellite.getDistance())));
            kenobiDiameter.add(currentCoordinateKenobi);

            currentCoordinateSkywalker.setX((skywalkerSatellite.getPosition().getX()+ (float)(Math.cos(i)*skywalkerSatellite.getDistance())));
            currentCoordinateSkywalker.setY((skywalkerSatellite.getPosition().getY() + (float)(Math.sin(i)*skywalkerSatellite.getDistance())));
            skywalkerDiameter.add(currentCoordinateSkywalker);

            currentCoordinateSato.setX((satoSatellite.getPosition().getX() + (float)(Math.cos(i)*satoSatellite.getDistance())));
            currentCoordinateSato.setY((satoSatellite.getPosition().getY() + (float)(Math.sin(i)*satoSatellite.getDistance())));
            satoDiameter.add(currentCoordinateSato);
        }

        skywalkerDiameter.toArray();

        ArrayList<Position> pos1 = new ArrayList<>();
        ArrayList<Position> pos2 = new ArrayList<>();
        ArrayList<Position> pos3 = new ArrayList<>();

        pos1.add(Position.builder().x((float) 1).y((float) 2).build());
        pos1.add(Position.builder().x((float) 2).y((float) 1).build());

        pos2.add(Position.builder().x((float) 1).y((float) 2).build());
        pos2.add(Position.builder().x((float) 0).y((float) 0).build());

        pos3.add(Position.builder().x((float) 1).y((float) 2).build());
        pos3.add(Position.builder().x((float) 3).y((float) 2).build());

        ArrayList<Position> subArray = new ArrayList<>();

        pos1.forEach(position -> {
            if (pos2.contains(position))
                        subArray.add(position);
            System.out.println(pos2.contains(position));
                }
        );

        List<Position> shipPositionss = IntStream
                .range(0, subArray.size())
                .filter(i -> {
                    System.out.println(satoDiameter.contains(subArray.get(i)));
                    return satoDiameter.contains(subArray.get(i));
                })
                .mapToObj(i -> {
                    System.out.println(satoDiameter.get(0).getX());
                    System.out.println(satoDiameter.get(i).getX());
                    System.out.println(satoDiameter.get(i).getY());
                    return satoDiameter.get(i);
                })
                .collect(Collectors.toList());

        System.out.println(shipPositionss);
    }




}
