package xyz.nucleoid.fantasy.fabric.mixin;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLevelEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "xyz/nucleoid/fantasy/RuntimeLevelManager")
public class RuntimeLevelManagerMixin {
    @Overwrite
    private void onLevelLoad(MinecraftServer server, ServerLevel level) {
        ServerLevelEvents.LOAD.invoker().onLevelLoad(server, level);
    }

    @Overwrite
    private void onLevelUnload(MinecraftServer server, ServerLevel level) {
        ServerLevelEvents.UNLOAD.invoker().onLevelUnload(server, level);
    }
}
