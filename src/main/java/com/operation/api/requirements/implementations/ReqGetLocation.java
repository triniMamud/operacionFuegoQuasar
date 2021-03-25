package com.operation.api.requirements.implementations;

import com.operation.api.models.*;
import com.operator.api.requirements.HandleRequirement;

import java.util.ArrayList;

public class ReqGetLocation extends HandleRequirement<GetLocationRequest, Position> {


    @Override
    protected Position run(GetLocationRequest request) {
        ArrayList<Position> kenobiDiameter = new ArrayList<>();
        ArrayList<Position> skywalkerDiameter = new ArrayList<>();
        ArrayList<Position> satoDiameter = new ArrayList<>();

        KenobiSatellite kenobiSatellite = new KenobiSatellite(request.getDistances().get(0));
        SkywalkerSatellite skywalkerSatellite = new SkywalkerSatellite(request.getDistances().get(1));
        SatoSatellite satoSatellite = new SatoSatellite(request.getDistances().get(2));

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

