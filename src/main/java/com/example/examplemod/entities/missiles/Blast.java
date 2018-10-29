package com.example.examplemod.entities.missiles;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import java.util.List;

public class Blast extends EntityThrowable {
    int explosionPower = 1;
    EntityLivingBase shootingEntity;
    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    protected boolean inGround;
    private int throwableShake;
    protected EntityLivingBase thrower;
    private int ticksInGround;
    private int ticksInAir;
    public Entity ignoreEntity;
    private int ignoreTime;


    public Blast(World worldIn) {
        super(worldIn);
        this.setGlowing(true);
    }

    public Blast(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.setSize(0.25F, 0.25F);
        this.setGlowing(true);
    }

    public Blast(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
        this.setGlowing(true);
        this.shootingEntity = throwerIn;
        this.shoot(throwerIn.getLookVec().x + throwerIn.getLookVec().x * 0.009, throwerIn.getLookVec().y + throwerIn.getLookVec().y * 0.009, throwerIn.getLookVec().z + throwerIn.getLookVec().z * 0.009,1.3f, 0.3f);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.MAGIC, 10.0f);
        }

        if (!this.world.isRemote) {
            int n = (int)(Math.random() * 100);
            this.world.newExplosion((Entity)null, this.posX, this.posY, this.posZ, (float)this.explosionPower, false, false);
            for (int i = 0; i < n; i++) {
                world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, this.posX, this.posY, this.posZ, (Math.random()) / 10, (Math.random()) / 10, (Math.random()) / 10);
            }
        }
        this.setDead();
    }

    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();

        if (this.throwableShake > 0)
        {
            --this.throwableShake;
        }

        if (this.inGround)
        {
            if (this.world.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock() == this.inTile)
            {
                ++this.ticksInGround;

                if (this.ticksInGround == 1200)
                {
                    this.setDead();
                }
                return;
            }

            this.inGround = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
            this.ticksInGround = 0;
            this.ticksInAir = 0;
        }
        else
        {
            ++this.ticksInAir;
        }

        Vec3d vec3d = new Vec3d(this.posX, this.posY, this.posZ);
        Vec3d vec3d1 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d, vec3d1);
        vec3d = new Vec3d(this.posX, this.posY, this.posZ);
        vec3d1 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        if (raytraceresult != null)
        {
            vec3d1 = new Vec3d(raytraceresult.hitVec.x, raytraceresult.hitVec.y, raytraceresult.hitVec.z);
        }

        Entity entity = null;
        List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(1.0D));
        double d0 = 0.0D;
        boolean flag = false;

        for (int i = 0; i < list.size(); ++i)
        {
            Entity entity1 = list.get(i);

            if (entity1.canBeCollidedWith())
            {
                if (entity1 == this.ignoreEntity)
                {
                    flag = true;
                }
                else if (this.thrower != null && this.ticksExisted < 2 && this.ignoreEntity == null)
                {
                    this.ignoreEntity = entity1;
                    flag = true;
                }
                else
                {
                    flag = false;
                    AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(0.30000001192092896D);
                    RayTraceResult raytraceresult1 = axisalignedbb.calculateIntercept(vec3d, vec3d1);

                    if (raytraceresult1 != null)
                    {
                        double d1 = vec3d.squareDistanceTo(raytraceresult1.hitVec);

                        if (d1 < d0 || d0 == 0.0D)
                        {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }
        }

        if (this.ignoreEntity != null)
        {
            if (flag)
            {
                this.ignoreTime = 2;
            }
            else if (this.ignoreTime-- <= 0)
            {
                this.ignoreEntity = null;
            }
        }

        if (entity != null)
        {
            raytraceresult = new RayTraceResult(entity);
        }

        if (raytraceresult != null)
        {
            if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK && this.world.getBlockState(raytraceresult.getBlockPos()).getBlock() == Blocks.PORTAL)
            {
                this.setPortal(raytraceresult.getBlockPos());
            }
            else if (!net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult))
            {
                this.onImpact(raytraceresult);
            }
        }

        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));

        for (this.rotationPitch = (float)(MathHelper.atan2(this.motionY, (double)f) * (180D / Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {

        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        float f1 = 0.99F;
        float f2 = this.getGravityVelocity();

        if (this.isInWater())
        {
            for (int j = 0; j < 4; ++j)
            {
                float f3 = 0.25F;
                this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25D, this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX, this.motionY, this.motionZ);
            }

            f1 = 0.8F;
        }else {
            for (int j = 0; j < 8; j++) {
                this.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, this.posX + (Math.random()) - (Math.random()), this.posY + (Math.random()) - (Math.random()), this.posZ + (Math.random()) - (Math.random()), 0, 0, 0);
            }
        }

        this.motionX *= (double)f1;
        this.motionY *= (double)f1;
        this.motionZ *= (double)f1;



        this.setPosition(this.posX, this.posY, this.posZ);
    }


    @Override
    protected float getGravityVelocity() {
        return 0.002f;
    }
}
