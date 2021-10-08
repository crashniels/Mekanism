package mekanism.api.annotations;

import org.jetbrains.annotations.NotNull;

public interface NonNullSupplier<T> {

    @NotNull
    T get();

}
