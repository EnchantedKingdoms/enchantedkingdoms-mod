package pl.enchantedkingdoms.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import pl.enchantedkingdoms.EnchantedKingdoms;
import pl.enchantedkingdoms.item.custom.TestItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnchantedKingdoms.MOD_ID);

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new TestItem(new Item.Properties().durability(10)));

    public static final RegistryObject<Item> BLACK_CRYSTAL = ITEMS.register("black_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLACK_BLADE = ITEMS.register("black_blade",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLACK_PICKAXE = ITEMS.register("black_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLACK_STAFF = ITEMS.register("black_staff",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUN_PICKAXE = ITEMS.register("sun_pickaxe",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
