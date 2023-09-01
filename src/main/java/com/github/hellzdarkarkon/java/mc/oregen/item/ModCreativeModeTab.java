package com.github.hellzdarkarkon.java.mc.oregen.item;

import com.github.hellzdarkarkon.java.mc.oregen.OreGen;
import com.github.hellzdarkarkon.java.mc.oregen.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OreGen.MODID);
    public static final RegistryObject<CreativeModeTab> MOD_TAB =
            CREATIVE_TABS.register("oregen_tab",
                    ()->CreativeModeTab.builder().icon(()->new ItemStack(ModItem.SILVER_INGOT.get()))
                            .title(Component.translatable("creativetab.oregen_tab"))
                            .displayItems(((pParameters, pOutput) -> {
                                pOutput.accept(ModItem.SILVER_ORE.get());
                                pOutput.accept(ModItem.SILVER_NUGGET.get());
                                pOutput.accept(ModItem.SILVER_INGOT.get());

                                pOutput.accept(ModBlock.SILVER_BLOCK.get());
                                pOutput.accept(ModBlock.SILVER_ORE.get());
                            }))
                            .build());
    public static void register(IEventBus bus) {
        CREATIVE_TABS.register(bus);
    }
}