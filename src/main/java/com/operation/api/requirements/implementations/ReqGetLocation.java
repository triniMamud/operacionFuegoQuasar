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

        IntStream.range(0, 360).forEach(i -> {
            Position positionKenobi = Position.builder()
                    .x((float)(kenobiSatellite.getPosition().getX() + kenobiSatellite.getDistance() * Math.cos(i)))
                    .y((float)(kenobiSatellite.getPosition().getY() + kenobiSatellite.getDistance() * Math.sin(i)))
                    .build();
            kenobiDiameter.add(positionKenobi);

            Position positionSkywalker = Position.builder()
                    .x((float)(skywalkerSatellite.getPosition().getX() + skywalkerSatellite.getDistance() * Math.cos(i)))
                    .y((float)(skywalkerSatellite.getPosition().getY() + skywalkerSatellite.getDistance() * Math.sin(i)))
                    .build();
            skywalkerDiameter.add(positionSkywalker);

            Position positionSato = Position.builder()
                    .x((float)(satoSatellite.getPosition().getX() + satoSatellite.getDistance() * Math.cos(i)))
                    .y((float)(satoSatellite.getPosition().getY() + satoSatellite.getDistance() * Math.sin(i)))
                    .build();
            satoDiameter.add(positionSato);
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

