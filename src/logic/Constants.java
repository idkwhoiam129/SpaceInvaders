package logic;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public interface Constants
{

	public final boolean debugMode = true;
	public final boolean showFPS = true;

	public final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public final boolean fullscreen = true;
	public final int windowX = gd.getDisplayMode().getWidth();
	public final int windowY = gd.getDisplayMode().getHeight();
	public final int targetFPS = gd.getDisplayMode().getRefreshRate(); // Locks the refresh rate to the default screen
	public final int maxFrameTime = 100;
	public final int minFrameTime = 15;
	public final int multisample = 8;
	public final boolean vsync = true;
	public final boolean smoothDeltas = true;
	public final boolean antiAliasing = true;

	public final String resourcesPath = "Resources\\";
	public final String backgroundPath = "backgrounds\\";
	public final String shipsPath = "ships\\";
	public final String miscPath = "misc\\";
	public final String effectsPath = "effects\\";
	public final String celestialsPath = "celestial_objects\\";

	public final boolean grabMouse = false;
	public final boolean music = true;
	public final boolean sound = true;

	public final String gameTitle = "Space Invaders - v0.1";

	public final int startLives = 3;

}