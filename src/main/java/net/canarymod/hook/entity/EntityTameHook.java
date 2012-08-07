package net.canarymod.hook.entity;

import net.canarymod.api.entity.EntityAnimal;
import net.canarymod.api.entity.Player;
import net.canarymod.hook.CancelableHook;
import net.canarymod.plugin.PluginListener;

/**
 * Entity tame hook
 * @author Chris Ksoll
 *
 */
public final class EntityTameHook extends CancelableHook{
    
    private EntityAnimal animal;
    private Player player;
    private boolean isTamed;
    
    public EntityTameHook(EntityAnimal animal, Player player, boolean isTamed){
        this.animal = animal;
        this.player = player;
        this.isTamed = isTamed;
        this.type = Type.TAME;
    }

    /**
     * Check the default tame result.
     * @return True if the animal was tamed, false otherwise
     */
    public boolean isTamed() {
        return isTamed;
    }

    /**
     * Override the tame result.
     * @param isTamed True to force the animal being tamed, false to force the taming to fail
     */
    public void setTamed(boolean isTamed) {
        this.isTamed = isTamed;
    }

    /**
     * Get the player that is wanting to tame the animal
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the animal in question
     * @return
     */
    public EntityAnimal getAnimal() {
        return animal;
    }
    
    
    /**
     * Dispatches the hook to the given listener.
     * @param listener The listener to dispatch the hook to.
     */
    @Override
    public void dispatch(PluginListener listener) {
        listener.onTame(this);
    }
}