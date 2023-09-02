package pl.enchantedkingdoms.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import pl.enchantedkingdoms.EnchantedKingdoms;

public class ModItemsCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnchantedKingdoms.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENCHANTED_KINGDOMS_ITEMS_TAB = CREATIVE_MODE_TABS.register("enchantedkingdoms_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TEST_ITEM.get()))
                    .title(Component.translatable("creativetab.enchantedkingdoms_items_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TEST_ITEM.get());
                    })
                    .build());


    public static final RegistryObject<CreativeModeTab> ENCHANTED_KINGDOMS_BLOCKS_TAB = CREATIVE_MODE_TABS.register("enchantedkingdoms_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TEST_ITEM.get()))
                    .title(Component.translatable("creativetab.enchantedkingdoms_blocks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TEST_ITEM.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
