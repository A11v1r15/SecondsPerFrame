package com.a11v1r15.spf.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Locale;

@Environment(EnvType.CLIENT)
@Mixin(DebugHud.class)
public abstract class DebugHudMixin {
	@Shadow	private final MinecraftClient client;
    protected DebugHudMixin(MinecraftClient client) {this.client = client;}

    @Inject(at = @At(value = "HEAD"), method = "getLeftText")
	private void spf$modifyFpsDebugString(CallbackInfoReturnable<List<String>> cir) {
		if(client.fpsDebugString.contains("fps")) {
			double lastFrameDuration_ms = client.getLastFrameDuration();
			String string = "spf" + client.fpsDebugString.split("fps", 2)[1];
			client.fpsDebugString = String.format(Locale.ROOT, "%.5f %s", lastFrameDuration_ms/1000, string);
		}
	}
}