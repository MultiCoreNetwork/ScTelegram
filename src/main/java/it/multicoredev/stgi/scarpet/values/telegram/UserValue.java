package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;


public class UserValue extends MapValue {
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
        return "sctelegram_user";
    }
}
