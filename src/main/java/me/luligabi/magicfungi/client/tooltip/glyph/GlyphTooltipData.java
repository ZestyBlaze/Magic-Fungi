package me.luligabi.magicfungi.client.tooltip.glyph;

import me.luligabi.magicfungi.util.ActionType;
import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

public class GlyphTooltipData implements TooltipComponent {
    protected MushroomType mushroomType;
    protected ActionType actionType;

    public GlyphTooltipData(MushroomType mushroomType, ActionType actionType) {
        this.mushroomType = mushroomType;
        this.actionType = actionType;
    }
}
