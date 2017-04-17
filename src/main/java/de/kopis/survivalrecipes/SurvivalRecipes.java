package de.kopis.survivalrecipes;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SurvivalRecipes.MODID, version = SurvivalRecipes.VERSION)
public class SurvivalRecipes
{
    public static final String MODID = "survivalrecipes";
    public static final String VERSION = "1.1";

    public class ItemElytraBase extends Item {
        public ItemElytraBase()
        {
            this.maxStackSize = 1;
            this.setMaxDamage(432);
            this.setCreativeTab(CreativeTabs.TRANSPORTATION);
            BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
            setUnlocalizedName("elytra_base");
        }
    }

    public class ItemElytraPart extends Item {
        public ItemElytraPart()
        {
            this.maxStackSize = 1;
            this.setMaxDamage(432);
            this.setCreativeTab(CreativeTabs.TRANSPORTATION);
            BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
            setUnlocalizedName("elytra_part");
        }
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // items: elytra base
        Item elytraBase = new ItemElytraBase();
        registerItem(elytraBase, "elytra_base");
        // items: elytra part
        Item elytraPart = new ItemElytraPart();
        registerItem(elytraPart, "elytra_part");

        // recipe: saddle
        GameRegistry.addRecipe(new ItemStack(Items.SADDLE, 1), new Object[] {"X#X", "XXX", "#Y#", 'X', Items.LEATHER, 'Y', Items.IRON_INGOT});
        // recipe: elytra base
        GameRegistry.addRecipe(new ItemStack(elytraBase, 1), new Object[] {"XX#", "XY#", "XY#", 'X', Items.BLAZE_ROD, 'Y', Items.PAPER});
        // recipe: elytra part
        GameRegistry.addRecipe(new ItemStack(elytraPart, 1), new Object[] {"XXX", "XYX", "XXX", 'X', Items.EMERALD, 'Y', elytraBase});
        // recipe: elytra
        GameRegistry.addRecipe(new ItemStack(Items.ELYTRA, 1), new Object[] {"XX", 'X', elytraPart});
        // recipe: name tag
        GameRegistry.addRecipe(new ItemStack(Items.NAME_TAG, 1), new Object[] {"##Y", "#Z#", "X##", 'X', Items.IRON_INGOT, 'Y', Items.STRING, 'Z', Items.LEATHER});

        // smelting: rotten flesh -> leather
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.LEATHER, 1), 1);
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
