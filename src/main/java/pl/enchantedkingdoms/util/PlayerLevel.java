package pl.enchantedkingdoms.util;

public class PlayerLevel {
    public static int getMoneyForNewLevel(int lastLevel, int newLevel) {
        int dif = newLevel - lastLevel;
        int sum = 0;
        for(int i = lastLevel + 1; i <= newLevel; i++) {
            if(i < 5) sum += 100;
            else if(i < 10) sum += 200;
            else if(i < 25) sum += 300;
            else if(i < 50) sum += 400;
            else if(i < 100) sum += 500;
        }
        return sum;
    }
}
