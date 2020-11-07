package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.ProximityAlertTriggered;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;

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
        return "telegram_game";
    }
}
