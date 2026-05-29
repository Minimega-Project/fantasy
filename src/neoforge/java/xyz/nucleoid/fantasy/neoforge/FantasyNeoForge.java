package xyz.nucleoid.fantasy.neoforge;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import xyz.nucleoid.fantasy.Fantasy;
import xyz.nucleoid.fantasy.util.TransientChunkGenerator;
import xyz.nucleoid.fantasy.util.VoidChunkGenerator;

@Mod("fantasy")
public class FantasyNeoForge {
    public FantasyNeoForge() {}

    @SubscribeEvent
    public static void event(RegisterEvent event) {
        event.register(Registries.CHUNK_GENERATOR, helper -> {
            helper.register(Identifier.fromNamespaceAndPath(Fantasy.ID, "void"), VoidChunkGenerator.CODEC);
            helper.register(Identifier.fromNamespaceAndPath(Fantasy.ID, "transient"), TransientChunkGenerator.CODEC);
        });
    }

    @SubscribeEvent
    public static void event(ServerTickEvent.Pre event) {
        Fantasy.onStartServerTick(event.getServer());
    }

    @SubscribeEvent
    public static void event(ServerStoppingEvent event) {
        Fantasy.onServerStopping(event.getServer());
    }
}
