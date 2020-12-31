/*
 * Bungee Commons, a Bungee development library
 * Copyright (C) Lucky_fish0w0
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package moe.orangemc.luckyfish.bungeecommons;

import moe.orangemc.luckyfish.bungeecommons.holder.ManagerHolder;
import moe.orangemc.luckyfish.bungeecommons.holder.impl.ManagerHolderImpl;
import moe.orangemc.luckyfish.bungeecommons.messaging.MessagingManager;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeCommons {
	private static ManagerHolder managerHolder;

	private BungeeCommons() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Get the messaging manager
	 * @param plugin the plugin.
	 * @return the messaging manager instance.
	 */
	public static MessagingManager getMessagingManager(Plugin plugin) {
		return managerHolder.getMessagingManager(plugin);
	}

	public static void setManagerHolder(ManagerHolder managerHolder) {
		if (BungeeCommons.managerHolder != null) {
			throw new IllegalArgumentException("There is already a manager holder");
		}

		BungeeCommons.managerHolder = managerHolder;
	}

	static {
		new ManagerHolderImpl();
	}
}
