package com.blakebr0.mysticalagriculture.client.tesr;

import com.blakebr0.mysticalagriculture.block.ModBlocks;
import com.blakebr0.mysticalagriculture.tileentity.InfusionAltarTileEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.lwjgl.opengl.GL14;

public class InfusionAltarRenderer extends TileEntityRenderer<InfusionAltarTileEntity> {
    @Override
    public void render(InfusionAltarTileEntity tile, double x, double y, double z, float partialTicks, int destroyStage) {
        ItemStackHandler inventory = tile.getInventory();
        ItemStack stack = inventory.getStackInSlot(1).isEmpty() ? inventory.getStackInSlot(0) : inventory.getStackInSlot(1);
        if (!stack.isEmpty()) {
            GlStateManager.pushMatrix();
            GlStateManager.translated(x + 0.5D, y + 1.1D, z + 0.5D);
            float scale = stack.getItem() instanceof BlockItem ? 0.95F : 0.75F;
            GlStateManager.scalef(scale, scale, scale);
            double tick = System.currentTimeMillis() / 800.0D;
            GlStateManager.translated(0.0D, Math.sin(tick % (2 * Math.PI)) * 0.065D, 0.0D);
            GlStateManager.rotatef((float) ((tick * 40.0D) % 360), 0, 1, 0);
            GlStateManager.disableLighting();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.GROUND);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableLighting();
            GlStateManager.popMatrix();
        }

        double posX = Minecraft.getInstance().getRenderManager().renderPosX;
        double posY = Minecraft.getInstance().getRenderManager().renderPosY;
        double posZ = Minecraft.getInstance().getRenderManager().renderPosZ;

        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GL14.glBlendColor(1.0F, 1.0F, 1.0F, 0.25F);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.CONSTANT_ALPHA, GlStateManager.DestFactor.ONE_MINUS_CONSTANT_ALPHA);

        tile.getPedestalPositions().forEach(pos -> {
            if (this.getWorld().isAirBlock(pos)) {
                GlStateManager.pushMatrix();
                GlStateManager.translated(-posX, -posY, -posZ);
                GlStateManager.translated(pos.getX(), pos.getY(), pos.getZ() + 1);
                Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
                Minecraft.getInstance().getBlockRendererDispatcher().renderBlockBrightness(ModBlocks.INFUSION_PEDESTAL.getDefaultState(), 1.0F);
                GlStateManager.color4f(1F, 1F, 1F, 1F);
                GlStateManager.popMatrix();
            }
        });

        GL14.glBlendColor(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    @Override
    public boolean isGlobalRenderer(InfusionAltarTileEntity tile) {
        return true;
    }
}
