package me.btelnyy.rightclickforname.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scoreboard.Team;

import me.btelnyy.rightclickforname.RightClickForName;
import me.btelnyy.rightclickforname.constants.ConfigData;
import me.btelnyy.rightclickforname.service.Utils;
import me.btelnyy.rightclickforname.service.file_manager.Configuration;
import me.btelnyy.rightclickforname.service.file_manager.FileID;

public class EventListener implements Listener {
    private static final Configuration language = RightClickForName.getInstance().getFileManager().getFile(FileID.LANGUAGE).getConfiguration();
    
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEntityEvent event){
        if(event.getRightClicked().getType() != EntityType.PLAYER){
            return;
        }
        Player player = event.getPlayer();
        Player target = (Player) event.getRightClicked();
        if(ConfigData.getInstance().useUsernames){
            if(ConfigData.getInstance().showTeamColor){
                Team team = Bukkit.getScoreboardManager().getMainScoreboard().getEntryTeam(target.getName());
                ChatColor color = ChatColor.WHITE;
                if(team != null){
                    color = team.getColor();
                    Utils.sendActionBarMessage(player, color + language.getString("name_format").replace("{playername}", target.getName()));
                    return;
                }
            }
            Utils.sendActionBarMessage(player, Utils.colored(language.getString("name_format").replace("{playername}", target.getName())));
            return;
        }
        if(!ConfigData.getInstance().useUsernames){
            Utils.sendActionBarMessage(player, language.getString("name_format").replace("{playername}", target.getDisplayName()));
            return;
        }
    }
}
