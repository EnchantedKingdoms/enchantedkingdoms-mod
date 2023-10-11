package pl.enchantedkingdoms.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import pl.enchantedkingdoms.economy.PlayerCashProvider;

import java.util.function.Supplier;

public class TestC2SPacket {
    public TestC2SPacket() {

    }

    public TestC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // SERVER SIDE
            ServerPlayer player = context.getSender();
            ServerLevel level = (ServerLevel) player.level();
            player.getCapability(PlayerCashProvider.PLAYER_CASH).ifPresent((cash) -> {
                player.sendSystemMessage(Component.literal("Masz tyle hajsu: " + cash.getCash()));
            });
        });

        return true;
    }
}
