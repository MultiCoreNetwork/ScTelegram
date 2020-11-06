package it.multicoredev.stgi.scarpet.values;

import net.minecraft.entity.Entity;

import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.ChatLocation;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;
import org.telegram.telegrambots.meta.api.objects.ChatPhoto;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Dice;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.LoginUrl;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.ProximityAlertTriggered;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.Venue;
import org.telegram.telegrambots.meta.api.objects.Video;
import org.telegram.telegrambots.meta.api.objects.VideoNote;
import org.telegram.telegrambots.meta.api.objects.Voice;
import org.telegram.telegrambots.meta.api.objects.games.Animation;
import org.telegram.telegrambots.meta.api.objects.games.CallbackGame;
import org.telegram.telegrambots.meta.api.objects.games.Game;
import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.passport.PassportData;
import org.telegram.telegrambots.meta.api.objects.passport.PassportFile;
import org.telegram.telegrambots.meta.api.objects.payments.Invoice;
import org.telegram.telegrambots.meta.api.objects.payments.OrderInfo;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingAddress;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingQuery;
import org.telegram.telegrambots.meta.api.objects.payments.SuccessfulPayment;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;

import java.util.List;

import carpet.script.value.EntityValue;
import carpet.script.value.ListValue;
import carpet.script.value.NullValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;
import it.multicoredev.stgi.scarpet.values.telegram.AnimationValue;
import it.multicoredev.stgi.scarpet.values.telegram.AudioValue;
import it.multicoredev.stgi.scarpet.values.telegram.CallbackGameValue;
import it.multicoredev.stgi.scarpet.values.telegram.CallbackQueryValue;
import it.multicoredev.stgi.scarpet.values.telegram.ChatLocationValue;
import it.multicoredev.stgi.scarpet.values.telegram.ChatPermissionsValue;
import it.multicoredev.stgi.scarpet.values.telegram.ChatPhotoValue;
import it.multicoredev.stgi.scarpet.values.telegram.ChatValue;
import it.multicoredev.stgi.scarpet.values.telegram.ChosenInlineQueryValue;
import it.multicoredev.stgi.scarpet.values.telegram.ContactValue;
import it.multicoredev.stgi.scarpet.values.telegram.DiceValue;
import it.multicoredev.stgi.scarpet.values.telegram.DocumentValue;
import it.multicoredev.stgi.scarpet.values.telegram.GameValue;
import it.multicoredev.stgi.scarpet.values.telegram.InlineKeyboardMarkupValue;
import it.multicoredev.stgi.scarpet.values.telegram.InlineQueryValue;
import it.multicoredev.stgi.scarpet.values.telegram.InvoiceValue;
import it.multicoredev.stgi.scarpet.values.telegram.LocationValue;
import it.multicoredev.stgi.scarpet.values.telegram.LoginUrlValue;
import it.multicoredev.stgi.scarpet.values.telegram.MaskPositionValue;
import it.multicoredev.stgi.scarpet.values.telegram.MessageEntityValue;
import it.multicoredev.stgi.scarpet.values.telegram.MessageValue;
import it.multicoredev.stgi.scarpet.values.telegram.OrderInfoValue;
import it.multicoredev.stgi.scarpet.values.telegram.PassportDataValue;
import it.multicoredev.stgi.scarpet.values.telegram.PassportFileValue;
import it.multicoredev.stgi.scarpet.values.telegram.PhotoSizeValue;
import it.multicoredev.stgi.scarpet.values.telegram.PollAnswerValue;
import it.multicoredev.stgi.scarpet.values.telegram.PollValue;
import it.multicoredev.stgi.scarpet.values.telegram.PreCheckoutQueryValue;
import it.multicoredev.stgi.scarpet.values.telegram.ProximityAlertTriggeredValue;
import it.multicoredev.stgi.scarpet.values.telegram.ShippingAddressValue;
import it.multicoredev.stgi.scarpet.values.telegram.ShippingQueryValue;
import it.multicoredev.stgi.scarpet.values.telegram.StickerValue;
import it.multicoredev.stgi.scarpet.values.telegram.SuccessfulPaymentValue;
import it.multicoredev.stgi.scarpet.values.telegram.UserValue;
import it.multicoredev.stgi.scarpet.values.telegram.VenueValue;
import it.multicoredev.stgi.scarpet.values.telegram.VideoNoteValue;
import it.multicoredev.stgi.scarpet.values.telegram.VideoValue;
import it.multicoredev.stgi.scarpet.values.telegram.VoiceValue;

import static java.util.stream.Collectors.toList;

public class NullableValue {
    public static Value string(String arg) {
        if (arg != null) return new StringValue(arg);
        return new NullValue();
    }

    public static Value numeric(Double arg) {
        if (arg != null) return new NumericValue(arg);
        return new NullValue();
    }

    public static Value numeric(Integer arg) {
        if (arg != null) return new NumericValue(arg);
        return new NullValue();
    }

    public static Value numeric(Boolean arg) {
        if (arg != null) return new NumericValue(arg);
        return new NullValue();
    }

    public static Value numeric(Long arg) {
        if (arg != null) return new NumericValue(arg);
        return new NullValue();
    }

    public static Value entity(Entity arg) {
        if (arg != null) return new EntityValue(arg);
        return new NullValue();
    }

    // TELEGRAM //
    public static Value chatPhoto(ChatPhoto arg) {
        if (arg != null) return new ChatPhotoValue(arg);
        return new NullValue();
    }

    public static Value message(Message arg) {
        if (arg != null) return new MessageValue(arg);
        return new NullValue();
    }

    public static Value user(User arg) {
        if (arg != null) return new UserValue(arg);
        return new NullValue();
    }

    public static Value chat(Chat arg) {
        if (arg != null) return new ChatValue(arg);
        return new NullValue();
    }

    public static Value chatPermissions(ChatPermissions arg) {
        if (arg != null) return new ChatPermissionsValue(arg);
        return new NullValue();
    }

    public static Value chatLocation(ChatLocation arg) {
        if (arg != null) return new ChatLocationValue(arg);
        return new NullValue();
    }

    public static Value location(Location arg) {
        if (arg != null) return new LocationValue(arg);
        return new NullValue();
    }

    public static Value inlineQuery(InlineQuery arg) {
        if (arg != null) return new InlineQueryValue(arg);
        return new NullValue();
    }

    public static Value chosenInlineQuery(ChosenInlineQuery arg) {
        if (arg != null) return new ChosenInlineQueryValue(arg);
        return new NullValue();
    }

    public static Value callbackQuery(CallbackQuery arg) {
        if (arg != null) return new CallbackQueryValue(arg);
        return new NullValue();
    }

    public static Value shippingQuery(ShippingQuery arg) {
        if (arg != null) return new ShippingQueryValue(arg);
        return new NullValue();
    }

    public static Value preCheckoutQuery(PreCheckoutQuery arg) {
        if (arg != null) return new PreCheckoutQueryValue(arg);
        return new NullValue();
    }

    public static Value poll(Poll arg) {
        if (arg != null) return new PollValue(arg);
        return new NullValue();
    }

    public static Value pollAnswer(PollAnswer arg) {
        if (arg != null) return new PollAnswerValue(arg);
        return new NullValue();
    }

    public static Value orderInfo(OrderInfo arg) {
        if (arg != null) return new OrderInfoValue(arg);
        return new NullValue();
    }

    public static Value shippingAddress(ShippingAddress arg) {
        if (arg != null) return new ShippingAddressValue(arg);
        return new NullValue();
    }

    public static Value messageEntitylist(List<MessageEntity> arg) {
        if (arg != null)
            return new ListValue(arg.stream().map(MessageEntityValue::new).collect(toList()));
        return new NullValue();
    }

    public static Value animation(Animation arg) {
        if (arg != null)
            return new AnimationValue(arg);
        return new NullValue();
    }

    public static Value photoSize(PhotoSize arg) {
        if (arg != null)
            return new PhotoSizeValue(arg);
        return new NullValue();
    }

    public static Value audio(Audio arg) {
        if (arg != null)
            return new AudioValue(arg);
        return new NullValue();
    }

    public static Value document(Document arg) {
        if (arg != null)
            return new DocumentValue(arg);
        return new NullValue();
    }

    public static Value photoSizeList(List<PhotoSize> arg) {
        if (arg != null)
            return new ListValue(arg.stream().map(PhotoSizeValue::new).collect(toList()));
        return new NullValue();
    }

    public static Value sticker(Sticker arg) {
        if (arg != null)
            return new StickerValue(arg);
        return new NullValue();
    }

    public static Value maskPosition(MaskPosition arg) {
        if (arg != null)
            return new MaskPositionValue(arg);
        return new NullValue();
    }

    public static Value video(Video arg) {
        if (arg != null)
            return new VideoValue(arg);
        return new NullValue();
    }

    public static Value videoNote(VideoNote arg) {
        if (arg != null)
            return new VideoNoteValue(arg);
        return new NullValue();
    }

    public static Value voice(Voice arg) {
        if (arg != null)
            return new VoiceValue(arg);
        return new NullValue();
    }

    public static Value contact(Contact arg) {
        if (arg != null)
            return new ContactValue(arg);
        return new NullValue();
    }

    public static Value dice(Dice arg) {
        if (arg != null)
            return new DiceValue(arg);
        return new NullValue();
    }

    public static Value game(Game arg) {
        if (arg != null)
            return new GameValue(arg);
        return new NullValue();
    }

    public static Value venue(Venue arg) {
        if (arg != null)
            return new VenueValue(arg);
        return new NullValue();
    }

    public static Value userList(List<User> arg) {
        if (arg != null)
            return new ListValue(arg.stream().map(UserValue::new).collect(toList()));
        return new NullValue();
    }

    public static Value invoice(Invoice arg) {
        if (arg != null)
            return new InvoiceValue(arg);
        return new NullValue();
    }

    public static Value successfulPayment(SuccessfulPayment arg) {
        if (arg != null)
            return new SuccessfulPaymentValue(arg);
        return new NullValue();
    }

    public static Value passportData(PassportData arg) {
        if (arg != null)
            return new PassportDataValue(arg);
        return new NullValue();
    }

    public static Value passportFile(PassportFile arg) {
        if (arg != null)
            return new PassportFileValue(arg);
        return new NullValue();
    }

    public static Value passportFileList(List<PassportFile> arg) {
        if (arg != null)
            return new ListValue(arg.stream().map(PassportFileValue::new).collect(toList()));
        return new NullValue();
    }

    public static Value proximityAllertTriggered(ProximityAlertTriggered arg) {
        if (arg != null)
            return new ProximityAlertTriggeredValue(arg);
        return new NullValue();
    }

    public static Value inlineKeyboardMarkup(InlineKeyboardMarkup arg) {
        if (arg != null)
            return new InlineKeyboardMarkupValue(arg);
        return new NullValue();
    }

    public static Value loginUrl(LoginUrl arg) {
        if (arg != null)
            return new LoginUrlValue(arg);
        return new NullValue();
    }

    public static Value callbackGame(CallbackGame arg) {
        if (arg != null)
            return new CallbackGameValue(arg);
        return new NullValue();
    }
}