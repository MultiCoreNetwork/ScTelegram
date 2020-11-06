package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class MaskPositionValue extends ScTelegramValue {
    public MaskPositionValue(MaskPosition maskPosition) {
        super(Arrays.asList(
                new StringValue("point"),   new StringValue(maskPosition.getPoint()),
                new StringValue("x_shift"), new NumericValue(maskPosition.getXShift()),
                new StringValue("y_shift"), new NumericValue(maskPosition.getYShift()),
                new StringValue("scale"),   new NumericValue(maskPosition.getScale())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_mask_position";
    }
}
