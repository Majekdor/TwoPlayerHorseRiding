package com.github.kovalski.task;

import com.github.kovalski.stand.StandMove;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class HorseStandMove extends StandMove {

    public HorseStandMove(Player rider, Entity horse, ArmorStand stand) {
        super(rider, horse, stand);
    }
}
