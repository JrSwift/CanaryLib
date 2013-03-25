package net.canarymod.hook.world;


import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.CancelableHook;


public final class PistonHook extends CancelableHook {

    private Block piston, moving;

    public PistonHook(Block piston, Block moving, boolean pushing) {
        this.piston = piston;
        this.moving = moving;
    }

    /**
     * Gets the piston {@link Block}
     * @return piston
     */
    public Block getPiston() {
        return piston;
    }

    /**
     * Gets the {@link Block} the piston is pushing/pulling
     * @return
     */
    public Block getMoving() {
        return moving;
    }
}
