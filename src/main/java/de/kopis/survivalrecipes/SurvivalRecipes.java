package de.kopis.survivalrecipes;

import de.kopis.survivalrecipes.proxy.SurvivalRecipesProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = SurvivalRecipes.MODID, version = SurvivalRecipes.VERSION)
public class SurvivalRecipes
{
    public static final String MODID = "@@MOD_ID@@";
    public static final String VERSION = "@@MOD_VERSION@@";

    @Mod.Instance(MODID)
    public static SurvivalRecipes instance;

    @SidedProxy(clientSide = "de.kopis.survivalrecipes.proxy.SurvivalRecipesClientProxy", serverSide = "de.kopis.survivalrecipes.proxy.SurvivalRecipesServerProxy")
    public static SurvivalRecipesProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.load();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
