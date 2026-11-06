package me.luligabi.magicfungi.item.glyph;

import me.luligabi.magicfungi.client.tooltip.glyph.GlyphTooltipData;
import me.luligabi.magicfungi.util.ActionType;
import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public abstract class AbstractGlyphItem extends Item {
    protected BlockPos blockPos;

    public AbstractGlyphItem(Properties properties) {
        super(properties);
    }

    public abstract MushroomType getMushroomType();

    public abstract SoundEvent getSoundEvent();

    public abstract ActionType getActionType();

    public abstract void executeBlockGlyph(Player player, ItemStack itemStack);

    public abstract void executeEntityGlyph(Player player, ItemStack itemStack, LivingEntity interactionTarget);

    @Override
    public InteractionResult useOn(UseOnContext context) {
        blockPos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();

        if (!level.isClientSide()) {
            executeBlockGlyph(player, context.getItemInHand());
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        Level level = player.level();
        if (!level.isClientSide()) {
            executeEntityGlyph(player, stack, interactionTarget);
        }

        return InteractionResult.CONSUME;
    }

    protected void executeGlyph(Player player, ItemStack stack) {
        if (!player.isCreative()) stack.shrink(1);
        player.level().playSound(null,
                player.getX(), player.getY(), player.getZ(),
                getSoundEvent(), SoundSource.NEUTRAL, 1.0F, 1.0F);
        player.awardStat(Stats.ITEM_USED.get(this));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) return;
        tooltipComponents.add(Component.translatable("tooltip.magicfungi.spell_info.1").withStyle(MushroomType.getDarkColor(getMushroomType()), ChatFormatting.BOLD)
                .append(Component.translatable("tooltip.magicfungi.spell_info.2", getMushroomType().getFancyName(), getMushroomType().getStatsName())
                        .withStyle(MushroomType.getLightColor(getMushroomType()))));
        tooltipComponents.add(Component.translatable("tooltip.magicfungi.spell_info.5")
                .withStyle(MushroomType.getDarkColor(getMushroomType()), ChatFormatting.BOLD)
                .append(getActionType().getTranslatableText()
                        .copy().withStyle(MushroomType.getLightColor(getMushroomType()))));
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        return Optional.of(new GlyphTooltipData(getMushroomType(), getActionType()));
    }
}
