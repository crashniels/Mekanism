package mekanism.registration;

import mekanism.Mekanism;
import mekanism.common.item.gear.ItemAtomicDisassembler;

public final class BaseItems {

    public static final ItemRegistry ITEMS = new ItemRegistry(Mekanism.MODID);

    public static final ItemAtomicDisassembler ATOMIC_DISASSEMBLER = ITEMS.register("atomic_disassembler", () -> new ItemAtomicDisassembler());

    public static void init() {

    }

}
