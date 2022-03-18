package com.pervll.creator.world.entity.projectile;

import com.pervll.creator.world.entity.ModEntityType;
import com.pervll.creator.utils.Registry;
import com.pervll.creator.world.level.GodArrowExplosion;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.apache.commons.lang3.ObjectUtils;

public class GodArrow extends AbstractArrow {

    public GodArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public GodArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityType.GOD_ARROW.get(), shooter, level);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        /*for(int i=1;i<=3;i++) {
            this.level.explode(this, getBlockX(), this.getBlockY(), this.getBlockZ(), 10.0F, false, Explosion.BlockInteraction.DESTROY);
        }*/
        GodArrowExplosion g = new GodArrowExplosion(this.level,this, DamageSource.arrow(this, this), new ExplosionDamageCalculator(), pResult.getLocation().x, pResult.getLocation().y, pResult.getLocation().z, 20, false, Explosion.BlockInteraction.DESTROY);
        g.explode();
        this.discard();
    }

    /*@Override
    protected void onHitBlock(BlockHitResult p_36755_) {
        super.onHitBlock(p_36755_);
        BlockState blockHit = this.level.getBlockState(p_36755_.getBlockPos());
        this.discard();
        for(int i=1;i<=3;i++) {
            this.level.explode(this, getBlockX(), this.getBlockY(), this.getBlockZ(), 10.0F, false, Explosion.BlockInteraction.DESTROY);
        }
    }*/

    @Override
    public ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
