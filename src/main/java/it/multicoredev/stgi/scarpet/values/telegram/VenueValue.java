package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Venue;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class VenueValue extends ScTelegramValue {
    public VenueValue(Venue venue) {
        super(Arrays.asList(
                new StringValue("location"),          new LocationValue(venue.getLocation()),
                new StringValue("title"),             new StringValue(venue.getTitle()),
                new StringValue("address"),           new StringValue(venue.getAddress()),
                new StringValue("foursquare_id"),     NullableValue.string(venue.getFoursquareId()),
                new StringValue("foursquare_type"),   NullableValue.string(venue.getFoursquareType()),
                new StringValue("google_place_id"),   NullableValue.string(venue.getGooglePlaceId()),
                new StringValue("google_place_type"), NullableValue.string(venue.getGooglePlaceType())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_venue";
    }
}
