package com.pervll.creator.world.entity.monster;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.Random;

public class Alaif extends Monster {
    public Alaif(EntityType<Alaif> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.5D, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 22F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40D)
                .add(Attributes.ATTACK_DAMAGE, 5D)
                .add(Attributes.MOVEMENT_SPEED, 1D);
    }

    public void onDeath() {
        if (this.getHealth() == 0) {
            this.level.getNearestPlayer(this, 100D).hurt(DamageSource.FALL, 10F);
        }
    }

    public static boolean canSpawn(EntityType<Alaif> entity, ServerLevelAccessor levelAccess, MobSpawnType spawnType,
                                   BlockPos pos, Random random) {
        return checkMonsterSpawnRules(entity, levelAccess, spawnType, pos, random) && pos.getY() > 70;
    }
}
