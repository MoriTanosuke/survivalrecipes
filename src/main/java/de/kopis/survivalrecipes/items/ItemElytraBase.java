package de.kopis.survivalrecipes.items;

import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ItemElytraBase extends Item {
    public ItemElytraBase() {
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
        setUnlocalizedName("elytra_base");
    }
}
