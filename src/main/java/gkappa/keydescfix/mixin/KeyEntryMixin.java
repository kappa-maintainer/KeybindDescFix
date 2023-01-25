package gkappa.keydescfix.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiKeyBindingList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GuiKeyBindingList.KeyEntry.class)
public class KeyEntryMixin {

    @Redirect(method = "drawEntry", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;drawString(Ljava/lang/String;III)I"))
    private int recalculatePos(FontRenderer f, String text, int x, int y, int color) {
        return f.drawString(text, Math.max(x, 20), y, color);
    }
}
