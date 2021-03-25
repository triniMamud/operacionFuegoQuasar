import models.*;
import models.requests.GetLocationRequest;

import java.util.ArrayList;

public class GetLocation {

    public Position getLocation (GetLocationRequest getLocationRequest) {
        ArrayList<Position> kenobiDiameter = new ArrayList<Position>();
        ArrayList<Position> skywalkerDiameter = new ArrayList<Position>();
        ArrayList<Position> satoDiameter = new ArrayList<Position>();

        KenobiSatellite kenobiSatellite = new KenobiSatellite(500);
        SkywalkerSatellite skywalkerSatellite = new SkywalkerSatellite(600);
        SatoSatellite satoSatellite = new SatoSatellite(900);

        Position currentCoordinateKenobi = Position.builder().build();
        Position currentCoordinateSkywalker = Position.builder().build();
        Position currentCoordinateSato = Position.builder().build();

        for (int i = 0; i < 360; i++) {
            currentCoordinateKenobi.setX((float) (-500 + (Math.cos(i)*kenobiSatellite.getDistance())));
            currentCoordinateKenobi.setY((float) (-200 + (Math.sin(i)*kenobiSatellite.getDistance())));
            kenobiDiameter.add(currentCoordinateKenobi);

            currentCoordinateSkywalker.setX((float) (100 + (Math.cos(i)*skywalkerSatellite.getDistance())));
            currentCoordinateSkywalker.setY((float) (-100 + (Math.sin(i)*skywalkerSatellite.getDistance())));
            skywalkerDiameter.add(currentCoordinateSkywalker);

            currentCoordinateSato.setX((float) (500 + (Math.cos(i)*satoSatellite.getDistance())));
            currentCoordinateSato.setY((float) (100 + (Math.sin(i)*satoSatellite.getDistance())));
            satoDiameter.add(currentCoordinateSato);
        }

        ArrayList<Position> subArray = new ArrayList<Position>();
        skywalkerDiameter.toArray();

        kenobiDiameter.forEach(position -> {
                    if (skywalkerDiameter.contains(position))
                        subArray.add(position);
                }
        );

        Position emisorPosition = Position.builder().build();

        for (int i = 0; i < subArray.size(); i++) {
            if(satoDiameter.contains(subArray.get(i))){
                emisorPosition = Position.builder().x(subArray.get(i).getX()).y(subArray.get(i).getY()).build();
            }
        }

        return emisorPosition;
    }
}
