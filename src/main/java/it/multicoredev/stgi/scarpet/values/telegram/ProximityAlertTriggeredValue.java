package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.ProximityAlertTriggered;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.games.Game;

import java.util.Arrays;

import carpet.script.value.ListValue;
import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

import static java.util.stream.Collectors.toList;

public class ProximityAlertTriggeredValue extends ScTelegramValue {
    public ProximityAlertTriggeredValue(ProximityAlertTriggered proximityAlertTriggered) {
        super(Arrays.asList(
                new StringValue("traveler"), new UserValue(proximityAlertTriggered.getTraveler()),
                new StringValue("watcher"),  new UserValue(proximityAlertTriggered.getWatcher()),
                new StringValue("distance"), new NumericValue(proximityAlertTriggered.getDistance())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_game";
    }
}
