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

package moe.orangemc.luckyfish.bungeecommons.holder.impl;

import moe.orangemc.luckyfish.bungeecommons.BungeeCommons;
import moe.orangemc.luckyfish.bungeecommons.holder.ManagerHolder;
import moe.orangemc.luckyfish.bungeecommons.messaging.MessagingManager;
import moe.orangemc.luckyfish.bungeecommons.messaging.impl.MessagingManagerImpl;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class ManagerHolderImpl implements ManagerHolder {
	private final Map<Plugin, MessagingManager> messagingManagers = new HashMap<>();

	public ManagerHolderImpl() {
		BungeeCommons.setManagerHolder(this);
	}

	@Override
	public MessagingManager getMessagingManager(Plugin plugin) {
		MessagingManager messagingManager = messagingManagers.get(plugin);
		if (messagingManager == null) {
			messagingManager = new MessagingManagerImpl(plugin);
			messagingManagers.put(plugin, messagingManager);
		}
		return messagingManager;
	}
}
