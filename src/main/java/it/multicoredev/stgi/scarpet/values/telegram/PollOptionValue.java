package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.polls.PollOption;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;

public class PollOptionValue extends ScTelegramValue {
    public PollOptionValue(PollOption pollOption) {
        super(Arrays.asList(
                new StringValue("text"),        new StringValue(pollOption.getText()),
                new StringValue("voter_count"), new NumericValue(pollOption.getVoterCount())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_poll_option";
    }
}
