package com.blakebr0.mysticalagriculture.lib;

import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.blakebr0.mysticalagriculture.items.ItemBase;
import com.blakebr0.mysticalagriculture.items.ItemSeed;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.util.IStringSerializable;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public class CropType {
	
	public static void init(){
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				type.set();
			}
		}
	}
	
	public static enum Type implements IStringSerializable {
		
		STONE("stone", 1),
		DIRT("dirt", 1),
		NATURE("nature", 1),
		WOOD("wood", 1),
		WATER("water", 1),
		ICE("ice", 1),
		FIRE("fire", 2),
		DYE("dye", 2),
		NETHER("nether", 2),
		COAL("coal", 2),
		IRON("iron", 3),
		NETHER_QUARTZ("nether_quartz", 3),
		GLOWSTONE("glowstone", 3),
		REDSTONE("redstone", 3),
		OBSIDIAN("obsidian", 3),
		GOLD("gold", 4),
		LAPIS_LAZULI("lapis_lazuli", 4),
		END("end", 4),
		EXPERIENCE("experience", 4),
		DIAMOND("diamond", 5),
		EMERALD("emerald", 5),
		
		ZOMBIE("zombie", 1),
		PIG("pig", 2),
		CHICKEN("chicken", 2),
		COW("cow", 2),
		SHEEP("sheep", 2),
		SLIME("slime", 2),
		SKELETON("skeleton", 3),
		CREEPER("creeper", 3),
		SPIDER("spider", 3),
		RABBIT("rabbit", 3),
		GUARDIAN("guardian", 3),
		BLAZE("blaze", 4),
		GHAST("ghast", 4),
		ENDERMAN("enderman", 4),
		WITHER_SKELETON("wither_skeleton", 5),
		
		RUBBER("rubber", 2, ModChecker.RUBBER),
		SILICON("silicon", 2, ModChecker.SILICON),
		SULFUR("sulfur", 2, ModChecker.SULFUR),
		ALUMINUM("aluminum", 2, ModChecker.ALUMINUM),
		COPPER("copper", 2, ModChecker.COPPER),
		SALTPETER("saltpeter", 3, ModChecker.SALTPETER),
		TIN("tin", 3, ModChecker.TIN),
		BRONZE("bronze", 3, ModChecker.BRONZE),
		ZINC("zinc", 3, ModChecker.ZINC),
		BRASS("brass", 3, ModChecker.BRASS),
		SILVER("silver", 3, ModChecker.SILVER),
		LEAD("lead", 3, ModChecker.LEAD),
		STEEL("steel", 4, ModChecker.STEEL),
		NICKEL("nickel", 4, ModChecker.NICKEL),
		CONSTANTAN("constantan", 4, ModChecker.CONSTANTAN),
		ELECTRUM("electrum", 4, ModChecker.ELECTRUM),
		INVAR("invar", 4, ModChecker.INVAR),
		MITHRIL("mithril", 4, ModChecker.MITHRIL),
		TUNGSTEN("tungsten", 5, ModChecker.TUNGSTEN),
		TITANIUM("titanium", 5, ModChecker.TITANIUM),
		URANIUM("uranium", 5, (ModChecker.URANIUM || ModChecker.IC2)),
		CHROME("chrome", 5, ModChecker.CHROME),
		PLATINUM("platinum", 5, ModChecker.PLATINUM),
		IRIDIUM("iridium", 5, (ModChecker.IRIDIUM || ModChecker.IC2)),
		
		RUBY("ruby", 4, ModChecker.RUBY),
		SAPPHIRE("sapphire", 4, ModChecker.SAPPHIRE),
		PERIDOT("peridot", 4, ModChecker.PERIDOT),
		AMBER("amber", 4, ModChecker.BOP),
		TOPAZ("topaz", 4, ModChecker.BOP),
		MALACHITE("malachite", 4, ModChecker.BOP),
		TANZANITE("tanzanite", 4, ModChecker.BOP),
		
		BLIZZ("blizz", 3, ModChecker.THERMAL),
		BLITZ("blitz", 3, ModChecker.THERMAL),
		BASALZ("basalz", 3, ModChecker.THERMAL),
		SIGNALUM("signalum", 4, ModChecker.SIGNALUM),
		LUMIUM("lumium", 4, ModChecker.LUMIUM),
		ENDERIUM("enderium", 5, ModChecker.ENDERIUM),
		
		ALUMINUM_BRASS("aluminum_brass", 2, ModChecker.TINKERS),
		KNIGHTSLIME("knightslime", 3, ModChecker.TINKERS),
		ARDITE("ardite", 3, ModChecker.TINKERS),
		COBALT("cobalt", 4, ModChecker.TINKERS),
		MANYULLYN("manyullyn", 5, ModChecker.TINKERS),
		
		ELECTRICAL_STEEL("electrical_steel", 3, ModChecker.ENDERIO),
		REDSTONE_ALLOY("redstone_alloy", 3, ModChecker.ENDERIO),
		CONDUCTIVE_IRON("conductive_iron", 3, ModChecker.ENDERIO),
		SOULARIUM("soularium", 4, ModChecker.ENDERIO),
		DARK_STEEL("dark_steel", 4, ModChecker.ENDERIO),
		PULSATING_IRON("pulsating_iron", 4, ModChecker.ENDERIO),
		ENERGETIC_ALLOY("energetic_alloy", 4, ModChecker.ENDERIO),
		VIBRANT_ALLOY("vibrant_alloy", 5, ModChecker.ENDERIO),
		
		MYSTICAL_FLOWER("mystical_flower", 2, ModConfig.confMysticalFlowerSeeds && ModChecker.BOTANIA),
		MANASTEEL("manasteel", 3, ModConfig.confManasteelSeeds && ModChecker.BOTANIA),
		TERRASTEEL("terrasteel", 5, ModConfig.confTerrasteelSeeds && ModChecker.BOTANIA),
		
		OSMIUM("osmium", 4, ModChecker.MEKANISM),
		GLOWSTONE_INGOT("glowstone_ingot", 4, ModChecker.MEKANISM),
		REFINED_OBSIDIAN("refined_obsidian", 5, ModChecker.MEKANISM),
		
		AQUARIUM("aquarium", 3, ModChecker.BASEMETALS),
		COLD_IRON("cold_iron", 3, ModChecker.BASEMETALS),
		STAR_STEEL("star_steel", 4, ModChecker.BASEMETALS),
		ADAMANTINE("adamantine", 5, ModChecker.BASEMETALS),
		
		MARBLE("marble", 2, ModChecker.CHISEL),
		LIMESTONE("limestone", 2, ModChecker.CHISEL),
		BASALT("basalt", 2, ModChecker.CHISEL),
		
		APATITE("apatite", 2, ModChecker.FORESTRY),
		
		METEORIC_IRON("meteoric_iron", 4,  ModChecker.GALACTICRAFT),
		DESH("desh", 5, ModChecker.GALACTICRAFTPLANETS),
		
		VINTEUM("vinteum", 3, ModChecker.AM2),
		CHIMERITE("chimerite", 3, ModChecker.AM2),
		BLUE_TOPAZ("blue_topaz", 3, ModChecker.AM2),
		MOONSTONE("moonstone", 5, ModChecker.AM2),
		SUNSTONE("sunstone", 5, ModChecker.AM2),
		
		ENDER_BIOTITE("ender_biotite", 3, ModChecker.QUARK),
		
		ENDER_AMETHYST("ender_amethyst", 5, ModChecker.BOP),
		
		DRACONIUM("draconium", 5, ModChecker.DRACONIC),
		
		YELLORIUM("yellorium", 5, ModChecker.BIGREACTORS),
		
		CERTUS_QUARTZ("certus_quartz", 3, ModChecker.AE2),
		FLUIX("fluix", 4, ModChecker.AE2),
		
		QUARTZ_ENRICHED_IRON("quartz_enriched_iron", 3, ModChecker.RS);
				
		private final String name;
		private int tier;
		private final int defaultTier;
		private boolean enabled;
		private BlockMysticalCrop plant;
		private ItemBase crop;
		private ItemSeed seed;
		
		private final boolean debug = false;
		
		Type(String name, int defaultTier){
			this.name = name;
			this.defaultTier = defaultTier;
			this.enabled = true;
		}
		
		Type(String name, int defaultTier, boolean enabled){
			this.name = name;
			this.defaultTier = defaultTier;
			this.enabled = enabled;
		}

		@Override
		public String getName(){
			return this.name;
		}
		
		public int getTier(){
			return this.tier;
		}
		
		public boolean isEnabled(){
			return this.enabled || debug;
		}
		
		public BlockMysticalCrop getPlant(){
			return this.plant;
		}
		
		public ItemBase getCrop(){
			return this.crop;
		}
		
		public ItemSeed getSeed(){
			return this.seed;
		}
		
		public void configure(Configuration config){
			this.tier = config.get("Tiers", getName() + "_tier", this.defaultTier).getInt();
			this.enabled &= config.get("Seeds", getName() + "_seeds", true).getBoolean();
		}
		
		public void declare(){
			this.plant = new BlockMysticalCrop(getName() + "_crop");
			this.crop = new ItemBase(getName() + "_essence");
			this.seed = new ItemSeed(getName() + "_seeds", getPlant(), getTier());
		}
		
		public Type set(){
			this.getPlant().setCrop(this.getCrop());
			this.getPlant().setSeed(this.getSeed());
			return this;
		}
	}
}
