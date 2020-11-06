package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.games.Game;

import java.util.Arrays;

import carpet.script.value.ListValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

import static java.util.stream.Collectors.toList;


public class GameValue extends ScTelegramValue {
    public GameValue(Game game) {
        super(Arrays.asList(
                new StringValue("title"),         new StringValue(game.getTitle()),
                new StringValue("description"),   new StringValue(game.getDescription()),
                new StringValue("photo"),         new ListValue(game.getPhoto().stream().map(PhotoSizeValue::new).collect(toList())),
                new StringValue("text"),          NullableValue.string(game.getText()),
                new StringValue("text_entities"), NullableValue.messageEntitylist(game.getEntities()),
                new StringValue("animation"),     NullableValue.animation(game.getAnimation())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_game";
    }
}
