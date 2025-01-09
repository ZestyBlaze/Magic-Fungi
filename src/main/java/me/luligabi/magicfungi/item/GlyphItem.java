package me.luligabi.magicfungi.item;

import dev.teamcitrus.citruslib.tab.ITabFiller;
import me.luligabi.magicfungi.glyph.GlyphData;
import me.luligabi.magicfungi.registry.ComponentRegistry;
import me.luligabi.magicfungi.registry.DatapackRegistry;
import me.luligabi.magicfungi.glyph.GlyphExecution;
import me.luligabi.magicfungi.util.ActionType;
import me.luligabi.magicfungi.util.ColorUtil;
import me.luligabi.magicfungi.util.MushroomType;
import me.luligabi.magicfungi.util.SpellExecutionUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.List;

public class GlyphItem extends Item implements ITabFiller {
    public GlyphItem(Properties properties) {
        super(properties);
    }

    @Override
    public Component getName(ItemStack stack) {
        if (stack.has(ComponentRegistry.GLYPH_DATA)) {
            GlyphData data = stack.get(ComponentRegistry.GLYPH_DATA);
            return Component.translatable("magicfungi.glyph", Component.translatable(data.id()));
        }
        return super.getName(stack);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (stack.has(ComponentRegistry.GLYPH_DATA)) {
            GlyphData data = stack.get(ComponentRegistry.GLYPH_DATA);
            if (data.action().equals(ActionType.ENTITY)) {
                if (data.execution().isPresent()) {
                    GlyphExecution execution = data.execution().get();
                    if (execution.conversionType().isPresent()) {
                        GlyphExecution.ConversionType conversion = execution.conversionType().get();
                        if (conversion.conversionMap().containsKey(interactionTarget.getType())) {
                            if (SpellExecutionUtil.executeEntityConversion(interactionTarget, interactionTarget.getType(), conversion.conversionMap().get(interactionTarget.getType()), conversion.soundEvent())) {
                                stack.shrink(1);
                            }
                        }
                    } else if (execution.conversionTag().isPresent()) {
                        GlyphExecution.ConversionTag conversion = execution.conversionTag().get();
                        interactionTarget.getType().getTags().forEach(entityTypeTagKey -> {
                            if (conversion.conversionMap().containsKey(entityTypeTagKey)) {
                                if (SpellExecutionUtil.executeEntityConversion(interactionTarget, interactionTarget.getType(), conversion.conversionMap().get(entityTypeTagKey), conversion.soundEvent())) {
                                    stack.shrink(1);
                                }
                            }
                        });
                    }
                }
            }
        }
        return super.interactLivingEntity(stack, player, interactionTarget, usedHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (stack.has(ComponentRegistry.GLYPH_DATA)) {
            GlyphData glyphData = stack.get(ComponentRegistry.GLYPH_DATA);
            if (Screen.hasShiftDown()) {
                MushroomType mushroomType = glyphData.mushroom();
                ActionType actionType = glyphData.action();
                tooltipComponents.add(Component.translatable("magicfungi.glyph.type", Component.literal(mushroomType.getCapitalizedName()).withStyle(mushroomType.getFormatting())).withStyle(ColorUtil.getPairedColor(mushroomType.getFormatting())));
                tooltipComponents.add(Component.translatable("magicfungi.glyph.action_type", Component.literal(actionType.getCapitalizedName()).withStyle(mushroomType.getFormatting())).withStyle(ColorUtil.getPairedColor(mushroomType.getFormatting())));
            } else {
                tooltipComponents.add(Component.translatable("magicfungi.tooltip.hold_shift").withStyle(ChatFormatting.GRAY));
            }
            if (glyphData.execution().isEmpty()) {
                tooltipComponents.add(Component.translatable("magicfungi.tooltip.no_execution").withStyle(ChatFormatting.RED));
            }
        }
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, BuildCreativeModeTabContentsEvent event) {
        HolderLookup.Provider provider = event.getParameters().holders();

        provider.lookupOrThrow(DatapackRegistry.GLYPHS).listElements().forEach(glyphDataReference -> {
            GlyphData data = glyphDataReference.value();
            ItemStack stack = new ItemStack(this);
            stack.set(ComponentRegistry.GLYPH_DATA, data);
            stack.set(DataComponents.RARITY, data.rarity());
            event.accept(stack);
        });
    }
}
