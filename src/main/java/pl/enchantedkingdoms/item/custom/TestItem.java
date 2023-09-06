package pl.enchantedkingdoms.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class TestItem extends Item {
    public TestItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide) return InteractionResult.SUCCESS;

        BlockPos positionClicked = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        boolean foundBlock = false;
        for(int i = 0; i <= positionClicked.getY() + 64; i++){
            BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

            if(isValuableBlock(state)){
                player.sendSystemMessage(Component.literal("Found valuable ore!"));
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> p.broadcastBreakEvent(p.getUsedItemHand()));
                return InteractionResult.SUCCESS;
            }
        }

        player.sendSystemMessage(Component.literal("Not valuable ore found!"));
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> p.broadcastBreakEvent(p.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.GOLD_ORE) || state.is(Blocks.COPPER_ORE);
    }
}
