package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class UserValue extends ScTelegramValue {
    public UserValue(User user) {
        super(Arrays.asList(
                new StringValue("id"),                          new NumericValue(user.getId()),
                new StringValue("is_bot"),                      new NumericValue(user.getIsBot()),
                new StringValue("first_name"),                  new StringValue(user.getFirstName()),
                new StringValue("last_name"),                   NullableValue.string(user.getLastName()),
                new StringValue("username"),                    NullableValue.string(user.getUserName()),
                new StringValue("language_code"),               NullableValue.string(user.getLanguageCode()),
                new StringValue("can_join_groups"),             NullableValue.numeric(user.getCanJoinGroups()),
                new StringValue("can_read_all_group_messages"), NullableValue.numeric(user.getCanReadAllGroupMessages()),
                new StringValue("supports_inline_queries"),     NullableValue.numeric(user.getSupportInlineQueries())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_user";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "is_bot",
            "can_join_groups",
            "can_read_all_group_messages",
            "supports_inline_queries"
    );
}
