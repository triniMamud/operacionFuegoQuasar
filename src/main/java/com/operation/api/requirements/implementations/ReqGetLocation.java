package com.operation.api.requirements.implementations;

import com.operation.api.exceptions.InvalidRequestException;
import com.operation.api.exceptions.PositionNotFoundException;
import com.operation.api.models.*;
import com.operation.api.requirements.HandleRequirement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ReqGetLocation extends HandleRequirement<Float[], Position> {

    @Override
    protected Position run(Float[] request) {
        //Validation
        if (request == null){
            throw new InvalidRequestException();
        }

        //Excecution
        ArrayList<Position> kenobiDiameter = new ArrayList<>();
        ArrayList<Position> skywalkerDiameter = new ArrayList<>();
        ArrayList<Position> satoDiameter = new ArrayList<>();

        KenobiSatellite kenobiSatellite = new KenobiSatellite(request[0]);
        SkywalkerSatellite skywalkerSatellite = new SkywalkerSatellite(request[1]);
        SatoSatellite satoSatellite = new SatoSatellite(request[2]);

        Position currentCoordinateKenobi = Position.builder().build();
        Position currentCoordinateSkywalker = Position.builder().build();
        Position currentCoordinateSato = Position.builder().build();

        IntStream.range(0, 360).forEach(i -> {
            currentCoordinateKenobi.setX((kenobiSatellite.getPosition().getX() + (float)(Math.cos(i)*kenobiSatellite.getDistance())));
            currentCoordinateKenobi.setY((kenobiSatellite.getPosition().getY() + (float)(Math.sin(i)*kenobiSatellite.getDistance())));
            kenobiDiameter.add(currentCoordinateKenobi);

            currentCoordinateSkywalker.setX((skywalkerSatellite.getPosition().getX()+ (float)(Math.cos(i)*skywalkerSatellite.getDistance())));
            currentCoordinateSkywalker.setY((skywalkerSatellite.getPosition().getY() + (float)(Math.sin(i)*skywalkerSatellite.getDistance())));
            skywalkerDiameter.add(currentCoordinateSkywalker);

            currentCoordinateSato.setX((satoSatellite.getPosition().getX() + (float)(Math.cos(i)*satoSatellite.getDistance())));
            currentCoordinateSato.setY((satoSatellite.getPosition().getY() + (float)(Math.sin(i)*satoSatellite.getDistance())));
            satoDiameter.add(currentCoordinateSato);
        });

        List<Position> shipPosition = IntStream
                .range(0, kenobiDiameter.size())
                .filter(i -> kenobiDiameter.contains(skywalkerDiameter.get(i)) && kenobiDiameter.contains(satoDiameter.get(i)))
                .mapToObj(i -> satoDiameter.get(i))
                .collect(Collectors.toList());

        if (shipPosition.isEmpty()){
            throw new PositionNotFoundException();
        }

        return shipPosition.get(0);
    }
}

