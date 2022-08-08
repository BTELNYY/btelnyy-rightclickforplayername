package me.btelnyy.rightclickforname.service;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Utils {
    /*
    Allows you to use colours in messages like
    "&cHello!"
    Which would be red
     */
    public static String coloured(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static String colored(String str) {
        return coloured(str);
    }

    public static String buildMessage(String[] parts, boolean ignorefirst) {
        String message = "";
        if(ignorefirst){
            String[] yourArray = Arrays.copyOfRange(parts, 1, parts.length);
            for(String part : yourArray){
                message += part + " ";
            }
        }else{
            for (String part : parts) {
                message += part + " ";
            }
        }
        return message;
    }
    public static void sendActionBarMessage(Player player, String message){
        player.spigot().sendMessage(
            ChatMessageType.ACTION_BAR,
            new TextComponent(message));
    }
}
