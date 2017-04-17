package de.kopis.survivalrecipes.proxy;

import de.kopis.survivalrecipes.items.ItemElytraBase;
import de.kopis.survivalrecipes.items.ItemElytraPart;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalRecipesProxy {
    Item elytraBase = new ItemElytraBase();
    Item elytraPart = new ItemElytraPart();

    public void init()
    {
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

    public void preInit() {
        init();
    }

    public void load() {
    }

    public void postInit() {

    }
}
