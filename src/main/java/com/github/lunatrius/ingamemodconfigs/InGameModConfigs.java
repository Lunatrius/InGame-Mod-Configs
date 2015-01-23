package com.github.lunatrius.ingamemodconfigs;

import com.github.lunatrius.ingamemodconfigs.handler.GuiHandler;
import com.github.lunatrius.ingamemodconfigs.reference.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Map;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class InGameModConfigs {
    @Mod.Instance(Reference.MODID)
    public static InGameModConfigs instance;

    @NetworkCheckHandler
    public boolean checkModList(Map<String, String> versions, Side side) {
        return true;
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (FMLCommonHandler.instance().getSide().isServer()) {
            for (int i = 0; i < 5; i++) {
                Reference.logger.error("==================================================");
            }
            Reference.logger.error("== You're loading a client only mod on a server!");
            for (int i = 0; i < 5; i++) {
                Reference.logger.error("==================================================");
            }

            return;
        }

        MinecraftForge.EVENT_BUS.register(new GuiHandler());
    }
}
