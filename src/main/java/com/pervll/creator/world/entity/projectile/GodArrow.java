package com.pervll.creator.world.entity.projectile;

import com.pervll.creator.world.entity.ModEntityType;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

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
        GodArrowExplosion g = new GodArrowExplosion(this.level,this, DamageSource.arrow(this, this), new ExplosionDamageCalculator(), pResult.getLocation().x, pResult.getLocation().y, pResult.getLocation().z, 20, false, Explosion.BlockInteraction.DESTROY, 150d);
        g.explode();
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        //GodArrowExplosion g = new GodArrowExplosion(this.level,this, DamageSource.arrow(this, this), new ExplosionDamageCalculator(), pResult.getLocation().x, pResult.getLocation().y, pResult.getLocation().z, 20, false, Explosion.BlockInteraction.DESTROY,150d);
        //g.explode();
        this.level.explode(this, pResult.getLocation().x, pResult.getLocation().y, pResult.getLocation().z, 6, Explosion.BlockInteraction.DESTROY);
        this.discard();
    }

    @Override
    public ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
