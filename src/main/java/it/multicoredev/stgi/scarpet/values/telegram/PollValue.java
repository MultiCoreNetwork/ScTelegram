package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.polls.Poll;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

import static java.util.stream.Collectors.toList;

public class PollValue extends ScTelegramValue {
    public PollValue(Poll poll) {
        super(Arrays.asList(
                new StringValue("id"),                      new StringValue(poll.getId()),
                new StringValue("question"),                new StringValue(poll.getQuestion()),
                new StringValue("options"),                 new ListValue(poll.getOptions().stream().map(PollOptionValue::new).collect(toList())),
                new StringValue("total_voter_count"),       new NumericValue(poll.getTotalVoterCount()),
                new StringValue("is_closed"),               new NumericValue(poll.getIsClosed()),
                new StringValue("is_anonymous"),            new NumericValue(poll.getIsAnonymous()),
                new StringValue("type"),                    new StringValue(poll.getType()),
                new StringValue("allows_multiple_answers"), new NumericValue(poll.getAllowMultipleAnswers()),
                new StringValue("correct_option_id"),       NullableValue.numeric(poll.getCorrectOptionId()),
                new StringValue("explanation"),             NullableValue.string(poll.getExplanation()),
                new StringValue("explanation_entities"),    NullableValue.messageEntitylist(poll.getExplanationEntities()),
                new StringValue("open_period"),             NullableValue.numeric(poll.getOpenPeriod()),
                new StringValue("close_date"),              NullableValue.numeric(poll.getCloseDate())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_poll";
    }


    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "is_closed",
            "is_anonymous",
            "allows_multiple_answers"
    );
}
