package com.github.kovalski.listener;

import com.github.kovalski.HorseManager;
import com.github.kovalski.TwoPlayerHorseRiding;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import com.github.kovalski.stand.StandMoveHandler;

public class PlayerListener implements Listener {

    private static final TwoPlayerHorseRiding instance = TwoPlayerHorseRiding.getInstance();
    private final HorseManager horseManager = instance.getHorseManager();

    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Entity horse = event.getRightClicked();
        if (horseManager.isTwoPlayerAllowedEntity(horse)) {
            StandMoveHandler.sitBackSeat(horse, player);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (player.getVehicle() != null) {
            StandMoveHandler.removeIfExist(player.getVehicle());
        }
    }

    // TODO: 12/10/21 The fuck is this?
    /*
    @EventHandler(priority = EventPriority.MONITOR)
    public void onTeleport(PlayerTeleportEvent event){
        Player player = event.getPlayer();
        LivingEntity horse = (LivingEntity) player.getVehicle();
        Bukkit.broadcastMessage(String.valueOf(event.getCause()));
        if (horse == null){
            return;
        }
        if (horseManager.isTwoPlayerAllowedEntity(horse)){
            switch (event.getCause()){
                case COMMAND:
                    Bukkit.getPluginManager().callEvent(new HorseDismountEvent(horse, event.getTo(), HorseDismountEvent.DismountType.TELEPORT));
                default:
                    Bukkit.getPluginManager().callEvent(new HorseDismountEvent(horse, event.getTo(), HorseDismountEvent.DismountType.DISMOUNT));
            }
        }
    }
     */
}
