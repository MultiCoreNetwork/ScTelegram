package it.multicoredev.stgi.config;

import com.google.gson.annotations.SerializedName;

public class BotConfig {
    @SerializedName("bot_username")
    public final String BOT_USERNAME;
    @SerializedName("bot_token")
    public final String BOT_TOKEN;

    public BotConfig(String bot_username, String bot_token) {
        BOT_USERNAME = bot_username;
        BOT_TOKEN = bot_token;
    }
}
