package pl.enchantedkingdoms.economy;

import net.minecraft.nbt.CompoundTag;

public class PlayerCash {
    private int cash;
    private final int MIN_CASH = 0;

    public int getCash(){
        return cash;
    }

    public void addCash(int add){
        this.cash += add;
    }

    public void subtractCash(int sub) throws NotEnoughCashException {
        if(sub > this.cash) throw new NotEnoughCashException();
        this.cash -= sub;
    }

    public void copyFrom(PlayerCash source) {
        this.cash = source.cash;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("cash", this.cash);
    }

    public void loadNBTData(CompoundTag nbt){
        this.cash = nbt.getInt("cash");
    }
    public static class NotEnoughCashException extends Exception {

    }
}
