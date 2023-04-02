package net.diamonddev.democracy;

import net.diamonddev.democracy.fuckmojmaps.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Democracy implements ModInitializer {

	public static final String modid = "democracy";
	public static final Logger LOGGER = LoggerFactory.getLogger("democracy");

	public static boolean isCustomRulesInitialized = false;

	@Override
	public void onInitialize(ModContainer mod) {
		long start = System.currentTimeMillis();
		//

		LOGGER.info("In the wise words of Ben Kenobi, DEMOCRACY");

		//
		long initTime = System.currentTimeMillis() - start;
		LOGGER.info("Mod " + modid + " initialized in " + initTime + " millisecond(s)!");
	}

	public static Identifier id(String path) {
		return new Identifier(modid, path);
	}
}
