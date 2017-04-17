package de.kopis.survivalrecipes.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalRecipesClientProxy extends SurvivalRecipesProxy {
    @Override
    public void preInit() {
        super.preInit();

        // items: elytra base
        registerItem(elytraBase, "elytra_base");
        // items: elytra part
        registerItem(elytraPart, "elytra_part");
    }


    /**
     * Registers an {@link Item} in the {@link GameRegistry} and registers a
     * {@link ModelResourceLocation} using the mod prefix and given itemName.
     *
     * @param item     new {@link Item} to register
     * @param itemName name to use for items and inventory resource
     */
    private void registerItem(final Item item, final String itemName) {
        // required in order for the renderer to know how to render your items.
        // Likely to change in the near future.
        final ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("survivalrecipes:" + itemName);
        final int DEFAULT_ITEM_SUBTYPE = 0;
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, DEFAULT_ITEM_SUBTYPE,
                itemModelResourceLocation);
        GameRegistry.register(item, itemModelResourceLocation);
    }
}
