package net.canarymod.api.world;

import java.util.ArrayList;

import net.canarymod.api.EntityTracker;
import net.canarymod.api.Particle;
import net.canarymod.api.PlayerManager;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.EntityAnimal;
import net.canarymod.api.entity.EntityItem;
import net.canarymod.api.entity.EntityMob;
import net.canarymod.api.entity.Player;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.position.Vector3D;

/**
 * In MinecraftServer parlance this is a World wrapper. In fact, this resembles
 * a dimension (nether, normal, end) of a world It contains methods to work with
 * a worlds dimension.
 * 
 * @author Chris
 * @implementation This needs an {@link ChunkProviderServer} to serve chunk
 *                 updates etc
 * 
 */
public interface Dimension {

    public enum Type {
        NORMAL(0),
        NETHER(-1),
        END(1);
        
        private int id;
        
        Type(int id) {
            this.id = id;
        }
        
        public int getId() {
            return id;
        }
        
        public static Type fromId(int id) {
            switch(id) {
            case -1:
                return NETHER;
            case 0:
                return NORMAL;
            case 1:
                return END;
            default:
                return NORMAL;
            }
        }
    }
    
    /**
     * Get this dimensions entity tracker
     * @return
     */
    public EntityTracker getEntityTracker();
    
    /**
     * Set this dimensions entity tracker
     * @param tracker
     */
    public void setEntityTracker(EntityTracker tracker);
    
    
    /**
     * Get the world of this dimension
     * 
     * @return world
     */
    public World getWorld();
    
    /**
     * Get the type of this dimension (normal, nether, end)
     * @return
     */
    public Type getType();

    /**
     * Drop an item with this id into the dimension at the given coords
     * 
     * @param x
     * @param y
     * @param z
     * @param itemId
     */
    public EntityItem dropItem(int x, int y, int z, int itemId, int amount, int damage);

    /**
     * Drop the given item into the world
     * 
     * @param x
     * @param y
     * @param z
     * @param item
     */
    public EntityItem dropItem(int x, int y, int z, Item item);

    /**
     * Get list of entities that are {@link EntityAnimal}
     * 
     * @return
     */
    public ArrayList<EntityAnimal> getAnimalList();

    /**
     * Get list of all mobs currently in this world!
     * 
     * @return
     */
    public ArrayList<EntityMob> getMobList();

    /**
     * get list of all players currently in this world
     * 
     * @return
     */
    public ArrayList<Player> getPlayerList();

    /**
     * Get the block at this position
     * 
     * @param x
     * @param y
     * @param z
     * @return
     */
    public Block getBlockAt(int x, int y, int z);

    /**
     * Get only block data at this position
     * 
     * @param x
     * @param y
     * @param z
     * @return
     */
    public byte getDataAt(int x, int y, int z);

    /**
     * Get lightlevel at this point
     * 
     * @param x
     * @param y
     * @param z
     * @return
     */
    public int getLightLevelAt(int x, int y, int z);

    /**
     * Set lightlevel at this point in the block map (the torch light)
     * 
     * @param x
     * @param y
     * @param z
     * @param newLevel
     *            the new light level
     * @return
     */
    public void setLightLevelOnBlockMap(int x, int y, int z, int newLevel);
    
    /**
     * Set lightlevel at this point in the sky map (the sky light)
     * @param x
     * @param y
     * @param z
     * @param newLevel
     *            the new light level
     * @return
     */
    public void setLightLevelOnSkyMap(int x, int y, int z, int newLevel);

    /**
     * Set this block.
     * 
     * @param block
     */
    public void setBlock(Block block);

    /**
     * Set raw block at the position specified.
     * 
     * @param x
     * @param y
     * @param z
     * @param type
     */
    public void setBlockAt(int x, int y, int z, short type);
    
    /**
     * Set a block at the given coordinates in the Vector3D
     * @param vector
     * @param block
     */
    public void setBlockAt(Vector3D vector, Block block);

    /**
     * Set raw block with data at the position specified.
     * 
     * @param x
     * @param y
     * @param z
     * @param type
     * @param data
     */
    public void setBlockAt(int x, int y, int z, short type, byte data);

    /**
     * Set block data at this position
     * 
     * @param data
     * @param x
     * @param y
     * @param z
     */
    public void setDataAt(byte data, int x, int y, int z);

    /**
     * Update the world at this position
     * 
     * @param x
     * @param y
     * @param z
     */
    public void markBlockNeedsUpdate(int x, int y, int z);

    /**
     * Get the player closest to this coordinate
     * 
     * @param x
     * @param y
     * @param z
     * @param distance
     *            the maximum search distance
     * @return Player or null if there is no one within the search radius
     */
    public Player getClosestPlayer(double x, double y, double z, double distance);

    /**
     * Get the player closest to this living entity
     * 
     * @param entity
     * @param distance
     *            the maximum search distance
     * @return Player or null if there is no one within the search radius
     */
    public Player getClosestPlayer(Entity entity, int distance);

    /**
     * Return this worlds {@link ChunkProviderServer}
     * 
     * @return
     */
    public ChunkProviderServer getChunkProvider();

    /**
     * Check if the chunk where that block is, is loaded
     * 
     * @param block
     * @return true if chunk is laoded, false otherwise
     */
    public boolean isChunkLoaded(Block block);

    /**
     * Check if the chunk at this position is loaded
     * 
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean isChunkLoaded(int x, int y, int z);

    /**
     * Check if the chunk at this position is loaded
     * 
     * @param x
     * @param z
     * @return
     */
    public boolean isChunkLoaded(int x, int z);

    /**
     * Load a chunk
     * 
     * @param x
     * @param z
     * @return
     */
    public Chunk loadChunk(int x, int z);

    /**
     * Load a chunk
     * 
     * @param location
     * @return
     */
    public Chunk loadChunk(Location location);

    /**
     * Load a chunk
     * 
     * @param vec3d
     * @return
     */
    public Chunk loadChunk(Vector3D vec3d);
    
    /**
     * Get a chunk from the chunk provider.
     * If the chunk isn't loaded, this will return null
     * @param x
     * @param z
     * @return
     */
    public Chunk getChunk(int x, int z);
    
    

    /**
     * Get Dimensions height
     * 
     * @return
     */
    public int getHeight();

    /**
     * Get the first block that sees the sky (highest block on y) at the given
     * x/z axis height
     * 
     * @param x
     * @param z
     * @return int heighest Y
     */
    public int getYHeighestBlockAt(int x, int z);

    /**
     * Plays a note at the given position in the world
     * 
     * @param x
     * @param y
     * @param z
     * @param instrument
     * @param notePitch
     */
    public void playNoteAt(int x, int y, int z, int instrument, byte notePitch);

    /**
     * Set this worlds time. (0 - 24000)
     * 
     * @param time
     */
    public void setTime(long time);

    /**
     * Get relative time (0 - 24000)
     * 
     * @return
     */
    public long getRelativeTime();

    /**
     * Get raw time for this world (really long number)
     * 
     * @return
     */
    public long getRawTime();
    
    /**
     * Spawns the given particle in the world
     */
    public void spawnParticle(Particle particle);
    
    /**
     * Get the name of the world for this dimension
     * @return
     */
    public String getName();
    
    /**
     * Get this worlds player manager
     * @return
     */
    public PlayerManager getPlayerManager();
    
    /**
     * Set a new PlayerManager for this Dimension
     * @param pm
     */
    public void setPlayerManager(PlayerManager pm);
    
    /**
     * Create a new, unspawned mob that is attached to this world.
     * @param mobName
     * @return
     */
    public EntityMob createMob(EntityMob.MobType mobtype);
    
    /**
     * Check if this block is powered by redstone
     * @param block
     * @return
     */
    public boolean isBlockPowered(Block block);
    
    /**
     * Check if the block at the given vector position is powered by redstone
     * @param position
     * @return
     */
    public boolean isBlockPowered(Vector3D position);
    
    /**
     * Check if a block is powered at the given coordinates
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean isBlockPowered(int x, int y, int z);
    
    /**
     * Check if this block is indirectly powered by redstone
     * @param block
     * @return
     */
    public boolean isBlockIndirectlyPowered(Block block);
    
    /**
     * Check if the block at the given vector position is indirectly powered by redstone
     * @param position
     * @return
     */
    public boolean isBlockIndirectlyPowered(Vector3D position);
    
    /**
     * Check if a block is indirectly powered at the given coordinates
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean isBlockIndirectlyPowered(int x, int y, int z);
    
    /**
     * Set the thunder state
     * @param thundering whether it should thunder
     */
    public void setThundering(boolean thundering);
    
    /**
     * Set the time in ticks (~20/sec) for how long it should thunder
     * @param ticks
     */
    public void setThunderTime(int ticks);
    
    /**
     * Set weather state (true = raining/snowing, false = sunshine)
     * @param downfall
     */
    public void setRaining(boolean downfall);
    
    /**
     * Set the time in ticks (~20/sec) for how long it should rain/snow
     * @param ticks
     */
    public void setRainTime(int ticks);
    
    /**
     * Check if it is currently raining/snowing in this dimension.
     * @return true if it's raining, false otherwise
     */
    public boolean isRaining();
    
    /**
     * Check if it is thundering in this dimension
     * @return true if it is thundering, false otherwise
     */
    public boolean isThundering();
    
    /**
     * Get the number of ticks remaining until it stops raining.
     * @return
     */
    public int getRainTicks();
    
    /**
     * Get the number of ticks until it stops thundering
     * @return
     */
    public int getThunderTicks();
    
    /**
     * Returns the random seed for this world
     * @return
     */
    public long getWorldSeed();
}
