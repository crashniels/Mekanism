package mekanism.api;

import mekanism.api.gear.IModuleHelper;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MekanismAPI implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MEKANISM_MODID = "mekanism";;

    @Override
    public void onInitialize() {
        log(Level.INFO, "API Loaded");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }

    //private static IForgeRegistry<Gas> GAS_REGISTRY;
    //private static IForgeRegistry<InfuseType> INFUSE_TYPE_REGISTRY;
    //private static IForgeRegistry<Pigment> PIGMENT_REGISTRY;
    //private static IForgeRegistry<Slurry> SLURRY_REGISTRY;
//    private static IForgeRegistry<ModuleData<?>> MODULE_REGISTRY;
    private static IModuleHelper MODULE_HELPER;
    //private static IRadiationManager RADIATION_MANAGER;
    //private static ITooltipHelper TOOLTIP_HELPER;


    /**
     * Gets Mekanism's {@link IModuleHelper} that provides various utility methods for implementing custom modules.
     */
    public static IModuleHelper getModuleHelper() {
        // Harmless race
        if (MODULE_HELPER == null) {
            try {
                Class<?> clazz = Class.forName("mekanism.common.content.gear.ModuleHelper");
                MODULE_HELPER = (IModuleHelper) clazz.getField("INSTANCE").get(null);
            } catch (ReflectiveOperationException ex) {
                LOGGER.fatal("Error retrieving RadiationManager, Mekanism may be absent, damaged, or outdated.");
            }
        }
        return MODULE_HELPER;
    }

}
