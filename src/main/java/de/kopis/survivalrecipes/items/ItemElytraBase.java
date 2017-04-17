package de.kopis.survivalrecipes.items;

import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ItemElytraBase extends Item {
    public ItemElytraBase() {
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
        setUnlocalizedName("elytra_base");
        setRegistryName("elytra_base");
    }
}
