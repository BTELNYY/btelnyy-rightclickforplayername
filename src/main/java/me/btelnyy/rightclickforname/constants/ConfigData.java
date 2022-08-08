package me.btelnyy.rightclickforname.constants;

import me.btelnyy.rightclickforname.service.file_manager.Configuration;

public class ConfigData {
    private static ConfigData instance;

    public boolean canOnlySeeSameTeamNames = false;
    public boolean useUsernames = true;
    public boolean showTeamColor = true;

    public void load(Configuration config) {
        instance = this;
        canOnlySeeSameTeamNames = config.getBoolean("can_only_see_same_team_names");
        useUsernames = config.getBoolean("use_username");
        showTeamColor = config.getBoolean("show_team_color");
    }
    public static ConfigData getInstance(){
        return instance;
    }
}
