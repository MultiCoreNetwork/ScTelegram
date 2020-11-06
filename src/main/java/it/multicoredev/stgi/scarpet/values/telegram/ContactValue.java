package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Contact;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class ContactValue extends ScTelegramValue {
    public ContactValue(Contact contact) {
        super(Arrays.asList(
                new StringValue("phone_number"), new StringValue(contact.getPhoneNumber()),
                new StringValue("first_name"),   new StringValue(contact.getFirstName()),
                new StringValue("last_name"),    NullableValue.string(contact.getLastName()),
                new StringValue("user_id"),      NullableValue.numeric(contact.getUserID()),
                new StringValue("vcard"),        NullableValue.string(contact.getVCard())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_contact";
    }
}
