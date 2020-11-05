package de.replaceitem.discarpet;

import net.minecraft.text.Text;

import java.util.UUID;

public interface EventInteface {
    void onChatMessage(Text text, UUID senderUuid);
}
