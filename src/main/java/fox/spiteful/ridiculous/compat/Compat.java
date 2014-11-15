package fox.spiteful.ridiculous.compat;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.forbidden.DarkAspects;
import fox.spiteful.ridiculous.Lumberjack;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Level;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class Compat {

    public static boolean teehee;
    public static boolean thaumic;
    public static boolean forbidden;

    public static Block enderGoo;

    public static void preparatoryCompatification(){
        if(Loader.isModLoaded("HardcoreEnderExpansion"))
            teehee = true;
        if(Loader.isModLoaded("Thaumcraft"))
            thaumic = true;
        if(Loader.isModLoaded("Forbidden"))
            forbidden = true;
    }

    public static void compatify()
    {
        if(teehee){
            enderGoo = GameRegistry.findBlock("HardcoreEnderExpansion", "ender_goo");
            if(enderGoo == null)
                teehee = false;
        }

        if(thaumic){
            try {
                AspectList aspects;
                ThaumcraftApi.registerEntityTag("RidiculousWorld.Unicorn", (new AspectList()).add(Aspect.BEAST, 4).add(Aspect.MAGIC, 2).add(Aspect.HEAL, 1), new ThaumcraftApi.EntityTagsNBT[0]);
                aspects = (new AspectList()).add(Aspect.BEAST, 1).add(Aspect.HUNGER, 1).add(Aspect.FLIGHT, 2).add(Aspect.AIR, 1);
                if(forbidden)
                    aspects.add(DarkAspects.GLUTTONY, 2);
                ThaumcraftApi.registerEntityTag("RidiculousWorld.Peep", aspects, new ThaumcraftApi.EntityTagsNBT[0]);
                ThaumcraftApi.registerEntityTag("RidiculousWorld.Calavera", (new AspectList()).add(Aspect.UNDEAD, 3).add(Aspect.MAN, 1).add(Aspect.HUNGER, 1), new ThaumcraftApi.EntityTagsNBT[0]);
                ThaumcraftApi.registerEntityTag("RidiculousWorld.Frankenstein", (new AspectList()).add(Aspect.FLESH, 4).add(Aspect.MAN, 3).add(Aspect.ENERGY, 2).add(Aspect.WEATHER, 1), new ThaumcraftApi.EntityTagsNBT[0]);
                ThaumcraftApi.registerEntityTag("RidiculousWorld.Warhorse", (new AspectList()).add(Aspect.UNDEAD, 3).add(Aspect.BEAST, 1).add(Aspect.EARTH, 1), new ThaumcraftApi.EntityTagsNBT[0]);
                ThaumcraftApi.registerEntityTag("RidiculousWorld.Gingerbread", (new AspectList()).add(Aspect.HUNGER, 3).add(Aspect.MOTION, 4), new ThaumcraftApi.EntityTagsNBT[0]);
                ThaumcraftApi.registerEntityTag("RidiculousWorld.Shoggoth", (new AspectList()).add(Aspect.SLIME, 2).add(Aspect.ELDRITCH, 2), new ThaumcraftApi.EntityTagsNBT[0]);

                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousBlocks.spookyLog), (new AspectList()).add(Aspect.TREE, 4).add(Aspect.SOUL, 1));
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousBlocks.boneDust), (new AspectList()).add(Aspect.DEATH, 4));
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousBlocks.serpent), (new AspectList()).add(Aspect.EARTH, 2));
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousBlocks.serpentRune), (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.ELDRITCH, 1).add(Aspect.MIND, 1));
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousBlocks.rockCandy), (new AspectList()).add(Aspect.CRYSTAL, 2).add(Aspect.HUNGER, 1));
                ThaumcraftApi.registerComplexObjectTag(new ItemStack(RidiculousItems.rustySickle, 1, OreDictionary.WILDCARD_VALUE), (new AspectList()).add(Aspect.HARVEST, 1).add(Aspect.DEATH, 2).add(Aspect.METAL, 1));
                ThaumcraftApi.registerComplexObjectTag(new ItemStack(RidiculousItems.unicornHorn, 1, OreDictionary.WILDCARD_VALUE), (new AspectList()).add(Aspect.HEAL, 3).add(Aspect.MAGIC, 1).add(Aspect.LIFE, 1));
                aspects = (new AspectList()).add(Aspect.HUNGER, 1);
                if(forbidden)
                    aspects.add(DarkAspects.GLUTTONY, 1);
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousItems.candyCorn), aspects);
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousItems.unicornRaw), (new AspectList()).add(Aspect.FLESH, 4).add(Aspect.LIFE, 2).add(Aspect.BEAST, 1));
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousItems.unicornCooked), (new AspectList()).add(Aspect.CRAFT, 1).add(Aspect.FLESH, 4).add(Aspect.HUNGER, 4));
                aspects = (new AspectList()).add(Aspect.HUNGER, 1).add(Aspect.BEAST, 1);
                if(forbidden)
                    aspects.add(DarkAspects.GLUTTONY, 2);
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousItems.peepRaw), aspects);
                aspects = (new AspectList()).add(Aspect.CRAFT, 1).add(Aspect.FIRE, 1).add(Aspect.HUNGER, 3);
                if(forbidden)
                    aspects.add(DarkAspects.GLUTTONY, 1);
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousItems.peepCooked), aspects);
                aspects = (new AspectList()).add(Aspect.HUNGER, 1);
                if(forbidden)
                    aspects.add(DarkAspects.GLUTTONY, 1);
                ThaumcraftApi.registerObjectTag(new ItemStack(RidiculousItems.chocoEgg), aspects);
            }
            catch(Throwable e){
                Lumberjack.log(Level.INFO, e, "Ridiculous World accumulated too much Warp!");
                thaumic = false;
            }
        }
    }
}