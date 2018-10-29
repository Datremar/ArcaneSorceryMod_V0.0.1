package com.example.examplemod.entities.missiles;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Test extends EntityThrowable {

    double vel = -360;
    double k = 0;

    public Test(World worldIn, double x, double y, double z) {
        super(worldIn, x, y + 1f, z);
        this.setSize(0.1f, 0.1f);
        this.shoot(x, y, z, 0, 0);
        this.posX = x;
        this.posY = y;
        this.posZ = z;
    }

    @Override
    protected void onImpact(RayTraceResult result) {}

    @Override
    public void onUpdate() {

        if (vel == 45) {
            k = +0.1;
        }else if (vel == 90) {
            k = -0.1;
        }

        vel += k;

        this.setPosition(posX, posY + (Math.tan(vel)) / 100, posZ);
    }
}
