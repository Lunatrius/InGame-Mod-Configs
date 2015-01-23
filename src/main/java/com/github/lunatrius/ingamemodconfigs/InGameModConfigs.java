package com.github.lunatrius.ingamemodconfigs;

import com.github.lunatrius.ingamemodconfigs.handler.GuiHandler;
import com.github.lunatrius.ingamemodconfigs.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkCheckHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

import java.util.Map;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class InGameModConfigs {
    @Instance(Reference.MODID)
    public static InGameModConfigs instance;

    @NetworkCheckHandler
    public boolean checkModList(Map<String, String> versions, Side side) {
        return true;
    }

    @EventHandler
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
