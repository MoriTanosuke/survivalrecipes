package de.kopis.survivalrecipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SurvivalRecipes.MODID, version = SurvivalRecipes.VERSION)
public class SurvivalRecipes
{
    public static final String MODID = "survivalrecipes";
    public static final String VERSION = "1.0";
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // recipe: saddle
        GameRegistry.addRecipe(new ItemStack(Items.SADDLE, 1), new Object[] {"X#X", "XXX", "#Y#", 'X', Items.LEATHER, 'Y', Items.IRON_INGOT});
        // smelting: rotten flesh -> leather
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.LEATHER, 1), 1);
    }
}
