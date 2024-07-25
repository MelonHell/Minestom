package net.minestom.server.entity;

import net.kyori.adventure.key.Key;
import net.minestom.server.registry.StaticProtocolObject;
import net.minestom.server.registry.Registry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public sealed interface EntityType extends StaticProtocolObject, EntityTypes permits EntityTypeImpl {
    /**
     * Returns the entity registry.
     *
     * @return the entity registry
     */
    @Contract(pure = true)
    @NotNull Registry.EntityEntry registry();

    @Override
    default @NotNull Key key() {
        return registry().key();
    }

    @Override
    default int id() {
        return registry().id();
    }

    default double width() {
        return registry().width();
    }

    default double height() {
        return registry().height();
    }

    static @NotNull Collection<@NotNull EntityType> values() {
        return EntityTypeImpl.values();
    }

    static EntityType fromKey(@NotNull String key) {
        return EntityTypeImpl.getSafe(key);
    }

    static EntityType fromKey(@NotNull Key key) {
        return fromKey(key.asString());
    }

    static @Nullable EntityType fromId(int id) {
        return EntityTypeImpl.getId(id);
    }
}
