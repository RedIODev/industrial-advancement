package dev.redio.industrialadvancement.core.registry;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.industrialadvancement.core.item.ore.ItemGraphiteDust;
import dev.redio.industrialadvancement.core.item.ore.ItemSilicon;
import dev.redio.industrialadvancement.core.item.ore.ItemSiliconDust;
import dev.redio.industrialadvancement.core.item.ore.ItemSiliconGraphiteBlend;
import dev.redio.industrialadvancement.core.item.ore.ItemSiliconIngot;
import dev.redio.industrialadvancement.core.item.tool.ItemCrudeOilBucket;
import dev.redio.industrialadvancement.core.util.Craftable;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import dev.redio.industrialadvancement.core.util.ItemUtil;
import net.minecraft.item.Item;

public class RegistryItem {
    public static ItemCrudeOilBucket crud_oil_bucket;
    public static ItemSilicon silicon;
    public static ItemGraphiteDust graphiteDust;
    public static ItemSiliconIngot siliconIngot;
    public static ItemSiliconGraphiteBlend siliconGraphiteBlend;
    public static ItemSiliconDust siliconDust;
    
    public static final List<Item> items = new ArrayList<Item>();

    public static void registerItems() {
        items.add(crud_oil_bucket = new ItemCrudeOilBucket());
        items.add(silicon = new ItemSilicon());
        items.add(graphiteDust = new ItemGraphiteDust());
        items.add(siliconIngot = new ItemSiliconIngot());
        items.add(siliconGraphiteBlend = new ItemSiliconGraphiteBlend());
        items.add(siliconDust = new ItemSiliconDust());

        for (Item item : items) {
            if (item instanceof Craftable) ((Craftable)item).registerRecipes();
            if (item instanceof DefaultTextureName) item.setTextureName(ItemUtil.textureName(item.getUnlocalizedName().replaceFirst("^item.", "")));
            GameRegistry.registerItem(item, item.getUnlocalizedName());
        }
    }
}
