package com.github.hellzdarkarkon.java.mc.oregen;

import com.github.hellzdarkarkon.java.mc.oregen.block.ModBlock;
import com.github.hellzdarkarkon.java.mc.oregen.item.ModCreativeModeTab;
import com.github.hellzdarkarkon.java.mc.oregen.item.ModItem;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(OreGen.MODID)
public class OreGen {
    public static final String MODID = "oregen";
    public static final Logger LOGGER = LogUtils.getLogger();

    public OreGen() {
        IEventBus modEB = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModeTab.register(modEB);
        ModItem.register(modEB);
        ModBlock.register(modEB);
        modEB.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEB.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent ev) {}
    private void addCreative(BuildCreativeModeTabContentsEvent ev) {}
    @SubscribeEvent
    public void onServerStart(ServerStartingEvent ev) {}
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent ev) {

        }
    }
}