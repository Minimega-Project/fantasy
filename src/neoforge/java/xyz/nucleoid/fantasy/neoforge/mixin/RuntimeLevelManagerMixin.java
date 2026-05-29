package xyz.nucleoid.fantasy.neoforge.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.LevelEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "xyz/nucleoid/fantasy/RuntimeLevelManager")
public class RuntimeLevelManagerMixin {
    @Overwrite
    private void onLevelLoad(MinecraftServer server, ServerLevel level) {
        NeoForge.EVENT_BUS.post(new LevelEvent.Load(level));
    }

    @Overwrite
    private void onLevelUnload(MinecraftServer server, ServerLevel level) {
        NeoForge.EVENT_BUS.post(new LevelEvent.Unload(level));
    }
}
