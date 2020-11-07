package it.multicoredev.stgi;

import carpet.script.CarpetExpression;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;

import org.apache.commons.io.IOUtils;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.CarpetScriptServer;
import carpet.script.bundled.BundledModule;

import it.multicoredev.stgi.config.BotConfig;
import it.multicoredev.stgi.config.Config;
import it.multicoredev.stgi.scarpet.ScarpetTelegramEvents;
import it.multicoredev.stgi.scarpet.functions.telegram.Bot;
import it.multicoredev.stgi.scarpet.functions.telegram.Chats;
import it.multicoredev.stgi.scarpet.functions.telegram.FileDownload;
import it.multicoredev.stgi.scarpet.functions.telegram.Members;
import it.multicoredev.stgi.scarpet.functions.telegram.Messages;
import it.multicoredev.stgi.scarpet.functions.telegram.Stickers;
import it.multicoredev.stgi.telegram.TelegramBot;
import it.multicoredev.stgi.telegram.TelegramEventHandler;

public class ScTelegram implements CarpetExtension {
    public static final String MOD_ID = "sctelegram";
    public static final String MOD_NAME = "ScTelegram";
    public static final String MOD_VERSION = "0.0.2";

    public static TelegramBotsApi telegramBotsApi;
    public static Map<String,TelegramBot> telegramBots;

    static {
        CarpetServer.manageExtension(new ScTelegram());
        CarpetScriptServer.registerBuiltInScript(sctelegramDefaultScript("sctelegram_event_test", false));
        CarpetScriptServer.registerBuiltInScript(sctelegramDefaultScript("chat_message_event_test", false));
    }

    public static BundledModule sctelegramDefaultScript(String scriptName, boolean isLibrary) {
        BundledModule module = new BundledModule(scriptName.toLowerCase(Locale.ROOT), null, false);
        try {
            module = new BundledModule(scriptName.toLowerCase(Locale.ROOT),
                    IOUtils.toString(
                            Objects.requireNonNull(BundledModule.class.getClassLoader().getResourceAsStream("assets/sctelegram/scripts/" + scriptName + (isLibrary ? ".scl" : ".sc"))),
                            StandardCharsets.UTF_8
                    ), isLibrary);
        } catch (NullPointerException | IOException e) {
        }
        return module;
    }

    public void registerBots() {
        try {
            Path configDir = FabricLoader.getInstance().getConfigDir().normalize();
            Files.createDirectories(configDir);
            Path configFile = configDir.resolve("sctelegram.json").normalize();
            Config.load(configFile.toFile());
            System.out.println("File di config loaded from " + configFile);
            Config.getInstance().toFile(configFile.toFile());
            for (BotConfig s : Config.getInstance().BOTS) {
                try {
                    TelegramBot telegramBot = new TelegramBot(s.BOT_USERNAME, s.BOT_TOKEN, new TelegramEventHandler(s.BOT_USERNAME));
                    telegramBots.put(s.BOT_USERNAME, telegramBot);
                    telegramBotsApi.registerBot(telegramBot);
                    System.out.println("Collegamento a " + s.BOT_USERNAME + " avvenuto con successo.");
                } catch (TelegramApiException e) {
                    System.err.println("Problemi nel collegamento a " + s.BOT_USERNAME + ".");
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    System.err.println("Problemi nel collegamento a " + s.BOT_USERNAME + ".");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restartBots() {
        try {
            telegramBots = new HashMap<>();
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            registerBots();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onGameStarted() {
        restartBots();
    }

    public static void noop() {
        ScarpetTelegramEvents.noop();
    }

    @Override
    public void onReload(MinecraftServer server) {
        restartBots();
    }

    @Override
    public void onServerClosed(MinecraftServer server) {
    }

    @Override
    public void scarpetApi(CarpetExpression expression) {
        Bot.apply(expression.getExpr());
        Chats.apply(expression.getExpr());
        FileDownload.apply(expression.getExpr());
        Members.apply(expression.getExpr());
        Messages.apply(expression.getExpr());
        Stickers.apply(expression.getExpr());
    }
}
