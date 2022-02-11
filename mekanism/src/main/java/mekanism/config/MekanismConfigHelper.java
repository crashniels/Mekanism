package mekanism.config;

import mekanism.Mekanism;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

public class MekanismConfigHelper {

    private MekanismConfigHelper() {
    }

    public static final Path CONFIG_DIR;

    static {
        CONFIG_DIR = FabricLoader.getInstance().getConfigDir();
    }

    public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
        ModLoadingContext.registerConfig(Mekanism.MODID, type, spec);
    }
}