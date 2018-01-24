package net.torocraft.loot;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.torocraft.loot.util.Timer;
import net.torocraft.loot.world.RiftsWorldProvider;

@Mod(modid = LegendaryLoot.MODID, name = LegendaryLoot.MODNAME, version = LegendaryLoot.VERSION)
public class LegendaryLoot {

  public static final String MODID = "torocraft-loot";
  public static final String VERSION = "1.12.2-1";
  public static final String MODNAME = "LegendaryLoot";

  @SidedProxy(clientSide = "net.torocraft.loot.ClientProxy")
  public static CommonProxy proxy;

  @Instance(value = LegendaryLoot.MODID)
  public static LegendaryLoot instance;

  public static MinecraftServer SERVER;

  @EventHandler
  public void preInit(FMLPreInitializationEvent e) {
    proxy.preInit(e);
  }

  @EventHandler
  public void init(FMLInitializationEvent e) {
    proxy.init(e);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent e) {
    proxy.postInit(e);
  }

  @EventHandler
  public void serverLoad(FMLServerStartingEvent e) {
    SERVER = e.getServer();
    e.registerServerCommand(new Commands());
  }
}
