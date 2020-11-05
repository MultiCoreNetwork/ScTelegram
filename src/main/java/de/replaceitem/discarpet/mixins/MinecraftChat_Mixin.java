package de.replaceitem.discarpet.mixins;


import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

import de.replaceitem.discarpet.EventInteface;
import de.replaceitem.discarpet.ScarpetEvents;

@Mixin(MinecraftServer.class)
public class MinecraftChat_Mixin {
	@Inject(at = @At("RETURN"),method = "sendSystemMessage(Lnet/minecraft/text/Text;Ljava/util/UUID;)V")
	public void redirectChatToScarpet(Text message, UUID senderUuid, CallbackInfo ci) {
		((EventInteface) ScarpetEvents.CHAT_MESSAGE).onChatMessage(message, senderUuid);
	}
}
