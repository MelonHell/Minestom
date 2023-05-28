package net.minestom.server.damage;

import net.minestom.server.registry.ProtocolObject;
import net.minestom.server.registry.Registry;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public sealed interface DamageType extends ProtocolObject, DamageTypes permits DamageTypeImpl {
    /**
     * Returns the damage type registry.
     *
     * @return the damage type registry
     */
    @Contract(pure = true)
    Registry.DamageTypeEntry registry();

    @Override
    default @NotNull NamespaceID namespace() {
        return registry().namespace();
    }

    default double exhaustion() {
        return registry().exhaustion();
    }

    default String message_id() {
        return registry().message_id();
    }

    default String scaling() {
        return registry().scaling();
    }

    static @NotNull Collection<@NotNull DamageType> values() {
        return DamageTypeImpl.values();
    }

    static DamageType fromNamespaceId(@NotNull String namespaceID) {
        return DamageTypeImpl.getSafe(namespaceID);
    }

    static DamageType fromNamespaceId(@NotNull NamespaceID namespaceID) {
        return fromNamespaceId(namespaceID.asString());
    }

    static @Nullable DamageType fromId(int id) {
        return DamageTypeImpl.getId(id);
    }
}
