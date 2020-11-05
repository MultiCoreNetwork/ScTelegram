package it.multicoredev.stgi;

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
import java.util.Locale;
import java.util.Objects;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.CarpetScriptServer;
import carpet.script.bundled.BundledModule;
import it.multicoredev.stgi.config.BotConfig;
import it.multicoredev.stgi.config.Config;
import it.multicoredev.stgi.scarpet.ScarpetTelegramEvents;
import it.multicoredev.stgi.telegram.TelegramBot;
import it.multicoredev.stgi.telegram.TelegramEventHandler;

public class ScTelegram implements CarpetExtension {
    public static final String MOD_ID = "sctelegram";
    public static final String MOD_NAME = "ScTelegram";
    public static final String MOD_VERSION = "0.0.1";

    public TelegramBotsApi telegramBotsApi;

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
                    telegramBotsApi.registerBot(new TelegramBot(s.BOT_USERNAME, s.BOT_TOKEN, new TelegramEventHandler(s.BOT_USERNAME)));
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
}
