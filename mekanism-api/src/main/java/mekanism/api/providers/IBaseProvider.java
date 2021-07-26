package mekanism.api.providers;

import mekanism.api.text.IHasTextComponent;
import mekanism.api.text.IHasTranslationKey;
import mekanism.api.text.TextComponentUtil;
import net.minecraft.text.Text;

public interface IBaseProvider extends IHasTextComponent, IHasTranslationKey {

    /**
     * Gets the registry name of the element represented by this provider.
     *
     * @return Registry name.
     */
    Text getRegistryName();

    /**
     * Gets the "name" or "path" of the registry name.
     */
    default String getName() {
        return getRegistryName().getString();
    }

    @Override
    default Text getTextComponent() {
        return TextComponentUtil.translate(getTranslationKey());
    }
}