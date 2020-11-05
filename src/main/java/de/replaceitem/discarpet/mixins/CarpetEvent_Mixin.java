package de.replaceitem.discarpet.mixins;

import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.Mixin;

import java.util.UUID;

import carpet.script.CarpetEventServer;
import de.replaceitem.discarpet.EventInteface;

@Mixin(CarpetEventServer.Event.class)
public class CarpetEvent_Mixin implements EventInteface {
    public void onChatMessage(Text text, UUID senderUuid) {
    }
}
