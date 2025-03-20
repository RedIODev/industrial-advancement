package dev.redio.industrialadvancement.core.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public interface TierItem {
    static List<TierItem> TIER_ITEMS = new ArrayList<TierItem>();

    public static int getGlobalMaxTier() {
        int maxTier = 0;
        for (TierItem item : TIER_ITEMS) {
            maxTier = Math.max(maxTier, item.getMaxTier());
        }
        return maxTier;
    }
    
    default void addTierInformation(ItemStack stack, List informationStrings) {
        informationStrings.add("Tier: " + getTier(stack));
    }

    int getTier(ItemStack stack);

    void setTier(ItemStack stack, int tier);

    int getMaxTier();
}
