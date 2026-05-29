package xyz.nucleoid.fantasy.fabric;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import xyz.nucleoid.fantasy.Fantasy;
import xyz.nucleoid.fantasy.util.TransientChunkGenerator;
import xyz.nucleoid.fantasy.util.VoidChunkGenerator;

public class FantasyFabric {
    public static void init() {
        Registry.register(BuiltInRegistries.CHUNK_GENERATOR, Identifier.fromNamespaceAndPath(Fantasy.ID, "void"), VoidChunkGenerator.CODEC);
        Registry.register(BuiltInRegistries.CHUNK_GENERATOR, Identifier.fromNamespaceAndPath(Fantasy.ID, "transient"), TransientChunkGenerator.CODEC);
        ServerTickEvents.START_SERVER_TICK.register(Fantasy::onStartServerTick);
        ServerLifecycleEvents.SERVER_STOPPING.register(Fantasy::onServerStopping);
    }
}
