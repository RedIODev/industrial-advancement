package dev.redio.industrialadvancement.core.registry;

import java.util.ArrayList;
import java.util.List;

import dev.redio.industrialadvancement.core.item.ore.ItemSilicon;
import dev.redio.industrialadvancement.core.util.EasyCreativeTab;
import net.minecraft.creativetab.CreativeTabs;

public class RegisterCreativeTab {
    public static CreativeTabs base_tab;

    public static final List<CreativeTabs> tabs = new ArrayList<CreativeTabs>();

    public static void registerCreativeTabs() {
        tabs.add(base_tab = new EasyCreativeTab("base_tab", RegistryGame.MODID, ItemSilicon.NAME));
    }
}
