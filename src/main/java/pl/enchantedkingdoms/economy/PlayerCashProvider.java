package pl.enchantedkingdoms.economy;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerCashProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerCash> PLAYER_CASH = CapabilityManager.get(new CapabilityToken<PlayerCash>() { });

    private PlayerCash cash = null;
    private final LazyOptional<PlayerCash> optional = LazyOptional.of(this::createPlayerCash);

    private PlayerCash createPlayerCash(){
        if(this.cash == null){
            this.cash = new PlayerCash();
        }

        return this.cash;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_CASH) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerCash().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerCash().saveNBTData(nbt);
    }
}
