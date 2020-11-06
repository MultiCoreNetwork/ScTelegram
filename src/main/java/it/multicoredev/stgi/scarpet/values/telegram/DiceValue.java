package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Dice;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;


public class DiceValue extends ScTelegramValue {
    public DiceValue(Dice dice) {
        super(Arrays.asList(
                new StringValue("emoji"), new StringValue(dice.getEmoji()),
                new StringValue("value"), new NumericValue(dice.getValue())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_dice";
    }
}
