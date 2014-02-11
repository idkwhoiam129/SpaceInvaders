package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class SpaceInvaders extends BasicGame implements Constants, Waves
{

	public static void main(final String[] args)
	{
		try
		{
			System.out.println("OPEN REQUESTED\n");
			final AppGameContainer game = new AppGameContainer(new SpaceInvaders(gameTitle));
			game.setDisplayMode(windowX, windowY, fullscreen);
			setSettings(game);
			System.out.println("\nSTART\n");
			game.start();
		} catch (final SlickException ex)
		{
			Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, "Exception @ creating container", ex);
		}
	}

	private static void setSettings(final AppGameContainer game)
	{

		// Graphics stuff
		game.setAlwaysRender(true);
		// game.setMinimumLogicUpdateInterval(minFrameTime);
		// game.setMaximumLogicUpdateInterval(maxFrameTime);
		game.setShowFPS(showFPS);
		game.setSmoothDeltas(smoothDeltas);
		game.setUpdateOnlyWhenVisible(true);
		game.setVerbose(debugMode);
		game.setVSync(vsync);
		game.setTargetFrameRate(targetFPS);
		game.setClearEachFrame(true);

		// User stuff
		game.setSoundOn(sound);
		game.setMusicOn(music);
		game.setMouseGrabbed(grabMouse);

	}

	private int updateCycles = 0;
	private int renderCycles = 0;

	public SpaceInvaders(final String title)
	{
		super(title);
	}

	@Override
	public void init(final GameContainer c) throws SlickException
	{
		System.out.println("\nInitialize\n");

		final Graphics graphics = c.getGraphics();
		graphics.setAntiAlias(antiAliasing);
		graphics.setWorldClip(0, 0, windowX, windowY);
		graphics.setDrawMode(Graphics.MODE_NORMAL);
		graphics.setBackground(org.newdawn.slick.Color.orange);
		graphics.clear();

		InvaderManager.step();
		RenderManager.loadResources(graphics);
	}

	@Override
	public void render(final GameContainer container, final Graphics g) throws SlickException
	{
		System.out.println("Render: " + renderCycles);
		RenderManager.nextRender(g);
		renderCycles++;
	}

	@Override
	public void update(final GameContainer container, final int delta) throws SlickException
	{
		System.out.println("Update: " + updateCycles);
		LogicManager.update();
		updateCycles++;
	}
}