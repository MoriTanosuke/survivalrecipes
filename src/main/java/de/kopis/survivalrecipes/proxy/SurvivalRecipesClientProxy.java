package de.kopis.survivalrecipes.proxy;

import de.kopis.survivalrecipes.SurvivalRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalRecipesClientProxy extends SurvivalRecipesProxy {
    @Override
    public void preInit() {
        super.preInit();

        CreativeTabs tab = new CreativeTabs(SurvivalRecipes.MODID) {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.ELYTRA);
            }
        };
        elytraBase.setCreativeTab(tab);
        elytraPart.setCreativeTab(tab);

        // items: elytra base
        registerRenderer(elytraBase);
        // items: elytra part
        registerRenderer(elytraPart);
    }

    private void registerRenderer(final Item item) {
        registerRenderer(item, item.getRegistryName());
    }


    /**
     * Registers an {@link Item} in the {@link GameRegistry} and registers a
     * {@link ModelResourceLocation} using the mod prefix and given itemName.
     *
     * @param item     new {@link Item} to register
     * @param itemName name to use for items and inventory resource
     */
    private void registerRenderer(final Item item, final ResourceLocation itemName) {
        // required in order for the renderer to know how to render your items.
        // Likely to change in the near future.
        final ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(itemName, "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, DEFAULT_ITEM_SUBTYPE,
                itemModelResourceLocation);
    }
}
