package com.github.kovalski.task;

import com.github.kovalski.stand.StandMove;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ExampleStandMove extends StandMove {

    public ExampleStandMove(Player rider, Entity horse, ArmorStand stand) {
        super(rider, horse, stand);
    }

    //Override seatLocation and setup new location
    @Override
    public Location getSeatLocation() {
        return null;
    }
}
