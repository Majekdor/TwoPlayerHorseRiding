package com.github.kovalski.util;
import com.github.kovalski.data.YamlConfig;
import org.bukkit.ChatColor;

public class MessageUtil {

    private final YamlConfig messages;

    public MessageUtil(YamlConfig messages) {
        this.messages = messages;
    }

    public enum Messages {
        ERROR_NO_PERM,
        CMD_RELOAD,
        ENABLED_WALK_MODE,
        DISABLED_WALK_MODE,
        ERROR_MAXIMUM_HEALTH_NOT_FOUND,
        ERROR_MOUNT_NOT_FOUND,
        ERROR_ONLY_PLAYERS,
        ERROR_ALREADY_SLOW,
        ERROR_CANNOT_LOCK,
        MOUNT_LOCKED,
        MOUNT_UNLOCKED,
        ERROR_NOT_ALLOWED_ENTITY,
        ERROR_BACKSEAT_LOCKED,
        ERROR_NOT_ALLOWED_IN_TOWNS
    }

    public String getMessage(Messages messageName) {

        String string = switch (messageName) {
            case ERROR_NO_PERM -> messages.getString("error_no_perm");
            case CMD_RELOAD -> messages.getString("cmd_reload");
            case ENABLED_WALK_MODE -> messages.getString("enabled_walk_mode");
            case DISABLED_WALK_MODE -> messages.getString("disabled_walk_mode");
            case ERROR_MAXIMUM_HEALTH_NOT_FOUND -> messages.getString("error_maximum_health_not_found");
            case ERROR_MOUNT_NOT_FOUND -> messages.getString("error_mount_not_found");
            case ERROR_ONLY_PLAYERS -> messages.getString("error_only_players");
            case ERROR_ALREADY_SLOW -> messages.getString("error_already_slow");
            case ERROR_CANNOT_LOCK -> messages.getString("error_cannot_lock");
            case MOUNT_LOCKED -> messages.getString("mount_locked");
            case ERROR_NOT_ALLOWED_ENTITY -> messages.getString("error_not_allowed_entity");
            case MOUNT_UNLOCKED -> messages.getString("mount_unlocked");
            case ERROR_BACKSEAT_LOCKED -> messages.getString("error_backseat_locked");
            case ERROR_NOT_ALLOWED_IN_TOWNS -> messages.getString("error_not_allowed_in_towns");
        };

        return format(getPrefix()+" "+string);
    }

    public String getPrefix() {
        return messages.getString("prefix");
    }

    public String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public YamlConfig getMessages() {
        return messages;
    }
}
