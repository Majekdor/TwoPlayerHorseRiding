package com.github.kovalski.task;

import com.github.kovalski.stand.StandMove;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class DonkeyStandMove extends StandMove {

    public DonkeyStandMove(Player rider, Entity horse, ArmorStand stand) {
        super(rider, horse, stand);
    }
}
