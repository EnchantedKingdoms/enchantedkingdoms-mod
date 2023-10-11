package pl.enchantedkingdoms.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import pl.enchantedkingdoms.EnchantedKingdoms;

public class CashHudOverlay {
    private static final ResourceLocation CASH_ICON = new ResourceLocation(EnchantedKingdoms.MOD_ID,
            "textures/cash/cash.png");

    public static final IGuiOverlay HUD_CASH = ((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        int x = screenWidth / 2;
        int y = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CASH_ICON);
        guiGraphics.blit(CASH_ICON, x, y, 0, 0, 16, 16);
    });
}
