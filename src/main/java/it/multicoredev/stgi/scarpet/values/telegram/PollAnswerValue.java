package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;

import java.util.Arrays;

import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;

import static java.util.stream.Collectors.toList;

public class PollAnswerValue extends ScTelegramValue {
    public PollAnswerValue(PollAnswer pollAnswer) {
        super(Arrays.asList(
                new StringValue("poll_id"),    new StringValue(pollAnswer.getPollId()),
                new StringValue("user"),       new UserValue(pollAnswer.getUser()),
                new StringValue("option_ids"), new ListValue(pollAnswer.getOptionIds().stream().map(NumericValue::new).collect(toList()))
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_poll_answer";
    }
}
