package com.github.kovalski.listener;

import com.github.kovalski.event.HorseDismountEvent;
import com.github.kovalski.event.HorseMountEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class BukkitListener implements Listener {

    @EventHandler
    public void onMount(VehicleEnterEvent event) {
        if (event.getVehicle() instanceof LivingEntity horse){
            Bukkit.getPluginManager().callEvent(new HorseMountEvent(event.getEntered(), horse, horse.getLocation()));
        }
    }

    @EventHandler
    public void onVehicleExit(VehicleExitEvent event) {
        if (event.getVehicle() instanceof LivingEntity horse){
            Bukkit.getPluginManager().callEvent(new HorseDismountEvent(event.getExited(), horse, horse.getLocation(), HorseDismountEvent.DismountType.DISMOUNT));
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        LivingEntity horse = event.getEntity();
        // TODO: 12/10/21 Rewrite for the possibility of multiple passengers
        Bukkit.getPluginManager().callEvent(new HorseDismountEvent(event.getEntity().getPassenger(), horse, horse.getLocation(), HorseDismountEvent.DismountType.DEATH));
    }

}
