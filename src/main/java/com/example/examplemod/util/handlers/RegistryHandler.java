package com.example.examplemod.util.handlers;

import com.example.examplemod.Init.ModBlocks;
import com.example.examplemod.Init.ModItems;
import com.example.examplemod.Init.ModWeapons;
import com.example.examplemod.Reference;
import com.example.examplemod.entities.missiles.Teleport;
import com.example.examplemod.genASM.structures.WorldGenCustomStructures;
import com.example.examplemod.util.IHasModel;

import com.example.examplemod.world.WorldRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		event.getRegistry().registerAll(ModWeapons.WEAPONS.toArray(new ItemSword[0]));
		event.getRegistry().registerAll();
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}

//	@SubscribeEvent
//	public static void onEntityRegister(RegistryEvent.Register<Entity> event) {
//
//	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ModItems.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for (ItemSword itemSword : ModWeapons.WEAPONS) {
			if(itemSword instanceof IHasModel){
				((IHasModel)itemSword).registerModels();
			}
		}
		for (Block block : ModBlocks.BLOCKS) {
			if(block instanceof IHasModel){
				((IHasModel)block).registerModels();
			}
		}
	}

	public static void registerGenerators() {
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(Teleport.class, Reference.MOD_ID + Reference.teleportRegName);
	}

    public static void registerDimensions() {
        WorldRegistry.MainRegistry();
    }

}
