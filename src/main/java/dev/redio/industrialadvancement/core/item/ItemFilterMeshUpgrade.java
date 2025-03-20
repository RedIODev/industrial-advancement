package dev.redio.industrialadvancement.core.item;

import java.util.List;

import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.tile.TileEntityPurifyer;
import dev.redio.industrialadvancement.core.util.ItemUtil;
import dev.redio.industrialadvancement.core.util.TierItem;
import ic2.api.item.IMachineUpgradeItem;
import ic2.api.tile.IMachine;
import ic2.api.tile.IMachine.UpgradeType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemFilterMeshUpgrade extends Item implements IMachineUpgradeItem {

    private static final String NAME = "filter_mesh_upgrade";
    private static final IIcon[] TIERS = new IIcon[3];//[TierItem.getGlobalMaxTier()-1];

    public ItemFilterMeshUpgrade() {
        setCreativeTab(RegistryCreativeTab.base_tab);
        setHasSubtypes(true);
        setUnlocalizedName(NAME);
        //setMaxDamage(TIERS.length);
        setMaxStackSize(16);
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        if (damage > TIERS.length) return null;
        return TIERS[damage];
    }

    @Override
    public void registerIcons(IIconRegister register) {
        String baseName = ItemUtil.textureName(NAME) + "_tier_";
        for (int i = 0; i < TIERS.length; i++) {
            TIERS[i] = register.registerIcon(baseName + (i+2));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack item) {
        return super.getUnlocalizedName(item) + "_tier_" + (item.getItemDamage()+2);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List subItems) {
        for (int i = 0; i < TIERS.length; i++) {
            subItems.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public double getEnergyDemandMultiplier(ItemStack upgrade, IMachine machine) {
        if (!(machine instanceof TileEntityPurifyer)) return 1;
        return 1.0 + (upgrade.getItemDamage()+1) * 0.6;
    
    }

    @Override
    public double getEnergyStorageMultiplier(ItemStack arg0, IMachine arg1) {
        return 1;
    }

    @Override
    public int getExtraEnergyDemand(ItemStack arg0, IMachine arg1) {
        return 0;
    }

    @Override
    public int getExtraEnergyStorage(ItemStack arg0, IMachine arg1) {
        return 0;
    }

    @Override
    public int getExtraProcessTime(ItemStack upgrade, IMachine machine) {
        if (!(machine instanceof TileEntityPurifyer)) return 1;
        return (upgrade.getItemDamage() + 1)*100;
    }

    @Override
    public int getExtraTier(ItemStack upgrade, IMachine machine) {
        if (!(machine instanceof TileEntityPurifyer)) return 1;
        return Math.min((upgrade.getItemDamage() + 1), 5);
    }

    @Override
    public double getProcessTimeMultiplier(ItemStack arg0, IMachine arg1) {
        return 1;
    }

    @Override
    public float getSoundVolumeMultiplier(ItemStack arg0, IMachine arg1) {
        return 1;    
    }

    @Override
    public UpgradeType getType(ItemStack arg0) {
        return UpgradeType.Custom;   
    }

    @Override
    public void onInstalling(ItemStack upgrade, IMachine machine) {
    }

    @Override
    public void onProcessEnd(ItemStack upgrade, IMachine machine, List<ItemStack> results) {
        if (!(machine instanceof TileEntityPurifyer)) return;
        for (ItemStack stack : results) {
            if (stack.getItem() instanceof TierItem) {
                TierItem item = (TierItem) stack.getItem();
                item.setTier(stack, Math.max(item.getTier(stack), upgrade.getItemDamage()+2));
            }
        }
    }

    @Override
    public boolean onTick(ItemStack arg0, IMachine arg1) {
        return false;
    }

    @Override
    public boolean useRedstoneinverter(ItemStack arg0, IMachine arg1) {
        return false;    
    }
    
}
