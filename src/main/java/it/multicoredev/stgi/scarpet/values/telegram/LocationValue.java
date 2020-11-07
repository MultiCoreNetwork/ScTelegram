package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Location;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class LocationValue extends ScTelegramValue {
    public LocationValue(Location location) {
        super(Arrays.asList(
                new StringValue("longitude"),              new NumericValue(location.getLongitude()),
                new StringValue("latitude"),               new NumericValue(location.getLatitude()),
                new StringValue("horizontal_accuracy"),    NullableValue.numeric(location.getHorizontalAccuracy()),
                new StringValue("live_period"),            NullableValue.numeric(location.getLivePeriod()),
                new StringValue("heading"),                NullableValue.numeric(location.getHeading()),
                new StringValue("proximity_alert_radius"), NullableValue.numeric(location.getProximityAlertDistance())
        ));
    }

    @Override
    public String getTypeString() {
        return "telegram_location";
    }
}
