package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Dice;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;


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
        return "telegram_dice";
    }
}
