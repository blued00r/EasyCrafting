package net.lepko.easycrafting.proxy;

import net.lepko.easycrafting.easyobjects.EasyRecipe;
import net.lepko.easycrafting.helpers.EasyLog;
import net.lepko.easycrafting.helpers.RecipeHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.SidedProxy;

public class Proxy {

	@SidedProxy(clientSide = "net.lepko.easycrafting.proxy.ProxyClient", serverSide = "net.lepko.easycrafting.proxy.Proxy")
	public static Proxy proxy;

	public static String blocksTextureFile = "/net/lepko/easycrafting/textures/blocks.png";

	public void onLoad() {
		// Server doesn't run a tick handler or a worker thread so set recipes here
		RecipeHelper.instance().setAllRecipes();
	}

	public void printMessageToChat(String msg) {
		// Client only; print to console here
		if (msg != null) {
			EasyLog.log("[CHAT] " + msg);
		}
	}

	public void sendEasyCraftingPacketToServer(int identifier, EasyRecipe r) {
		// Client only
	}

	public boolean isClient() {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			return true;
		}
		return false;
	}
}
