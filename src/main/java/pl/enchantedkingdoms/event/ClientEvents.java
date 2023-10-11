package pl.enchantedkingdoms.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import pl.enchantedkingdoms.EnchantedKingdoms;
import pl.enchantedkingdoms.client.CashHudOverlay;
import pl.enchantedkingdoms.networking.ModMessages;
import pl.enchantedkingdoms.networking.packet.TestC2SPacket;
import pl.enchantedkingdoms.util.KeyBinding;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = EnchantedKingdoms.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.SHOWING_CASH_KEY.consumeClick()) {
                ModMessages.sendToServer(new TestC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = EnchantedKingdoms.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.SHOWING_CASH_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("cash", CashHudOverlay.HUD_CASH);
        }
    }
}
