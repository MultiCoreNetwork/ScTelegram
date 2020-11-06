package it.multicoredev.stgi.mixins;

import it.multicoredev.stgi.scarpet.ScarpetTelegramEvents;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.UUID;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServer_chatEventMixin {
    @Shadow
    public abstract Iterable<ServerWorld> getWorlds();

    @Inject(at = @At("RETURN"),method = "sendSystemMessage(Lnet/minecraft/text/Text;Ljava/util/UUID;)V")
    public void redirectChatToScarpet(Text message, UUID senderUuid ,CallbackInfo ci) {
        Iterator worlds = this.getWorlds().iterator();
        Entity entity = null;
        while(worlds.hasNext() && entity == null) {
            entity = ((ServerWorld)worlds.next()).getEntity(senderUuid);
        }
        ScarpetTelegramEvents.CHAT_MESSAGE.onChatMessage(message,entity);
    }
}