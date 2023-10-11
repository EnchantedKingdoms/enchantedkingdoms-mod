package pl.enchantedkingdoms.event;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import pl.enchantedkingdoms.EnchantedKingdoms;
import pl.enchantedkingdoms.economy.PlayerCashProvider;
import pl.enchantedkingdoms.util.PlayerLevel;

@Mod.EventBusSubscriber(modid = EnchantedKingdoms.MOD_ID)
public class ModEvents {


    @SubscribeEvent
    public static void addAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerCashProvider.PLAYER_CASH).isPresent()) {
                event.addCapability(new ResourceLocation(EnchantedKingdoms.MOD_ID, "properties"), new PlayerCashProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getEntity().sendSystemMessage(Component.literal("U died and store cash: " + event.getOriginal().getCapability(PlayerCashProvider.PLAYER_CASH).isPresent()));
//        event.getOriginal().sendSystemMessage(Component.literal("U died and store cash"));

        event.getOriginal().getCapability(PlayerCashProvider.PLAYER_CASH).ifPresent(oldStore -> {

//            event.getOriginal().getCapability(PlayerCashProvider.PLAYER_CASH).ifPresent(newStore -> {
//                newStore.copyFrom(oldStore);
//
//            });
            event.getEntity().getCapability(PlayerCashProvider.PLAYER_CASH).ifPresent(newStore -> {
                newStore.copyFrom(oldStore);
            });
        });
    }

    @SubscribeEvent
    public static void addAttachCapabilitiesPlayer(PlayerXpEvent.LevelChange event) {
        Player p = event.getEntity();
        // p.sendSystemMessage(Component.literal("" + event.isCancelable()));
        int levels = event.getLevels();
        p.getCapability(PlayerCashProvider.PLAYER_CASH).ifPresent(playerCash -> {
                int cashToAdd = PlayerLevel.getMoneyForNewLevel(p.experienceLevel - levels, p.experienceLevel);
                playerCash.addCash(cashToAdd);
                p.sendSystemMessage(Component.literal("Dostałeś " + cashToAdd + "$"));
            }
        );
    }

}

