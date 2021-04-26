package at.mlem;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireSword extends SwordItem {

    public static final String REGISTRY_NAME = "fire_sword";
    public static final int ATTACK_DAMAGE = 3;
    public static final float ATTACK_SPEED = -2.4F;

    public FireSword(Properties builder) {
        super(ItemTier.DIAMOND, ATTACK_DAMAGE, ATTACK_SPEED, builder);

        this.setRegistryName(FireSwordMod.MOD_ID, REGISTRY_NAME);

    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    /**
     * Called when this item is used when targeting a Block
     */
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.getBlock() == Blocks.CAMPFIRE) {
            if (!blockstate.get(CampfireBlock.LIT) && !blockstate.get(CampfireBlock.WATERLOGGED)) {
                this.playUseSound(world, blockpos);
                world.setBlockState(blockpos, blockstate.with(CampfireBlock.LIT, Boolean.TRUE));
                return ActionResultType.SUCCESS;
            }
        } else {
            blockpos = blockpos.offset(context.getFace());
            if (world.getBlockState(blockpos).isAir(world,blockpos)) {
                this.playUseSound(world, blockpos);
                world.setBlockState(blockpos, ((FireBlock) Blocks.FIRE).getStateForPlacement(world, blockpos));
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;

    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setFire(5);
        return super.hitEntity(stack, target, attacker);
    }


    private void playUseSound(World worldIn, BlockPos pos) {
        worldIn.playSound(null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
    }

}
