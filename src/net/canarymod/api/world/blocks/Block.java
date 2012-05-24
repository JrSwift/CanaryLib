package net.canarymod.api.world.blocks;

import net.canarymod.api.world.Dimension;

/**
 * Class representing a block in minecraft.
 * 
 * @author Chris
 * 
 */
public interface Block {

    /**
     * Get this blocks type
     * 
     * @return
     */
    public short getType();

    /**
     * Set this blocks type
     * 
     * @param type
     */
    public void setType(short type);

    /**
     * Set this blocks type
     * 
     * @param type
     */
    public void setType(int type);

    /**
     * Get this blocks data
     * 
     * @return
     */
    public byte getData();

    /**
     * Get the current dimension for this block
     * 
     * @return
     */
    public Dimension getDimension();

    /**
     * Set this block dimension
     * 
     * @param world
     */
    public void setDimension(Dimension world);

    /**
     * Get the face that was clicked.
     * 
     * @return
     */
    public BlockFace getFaceClicked();

    /**
     * Set the clicked BlockFace
     * 
     * @param face
     */
    public void setFaceClicked(BlockFace face);

    /**
     * Send update packet for this block
     */
    public void update();

    public int getX();

    public int getY();

    public int getZ();

}