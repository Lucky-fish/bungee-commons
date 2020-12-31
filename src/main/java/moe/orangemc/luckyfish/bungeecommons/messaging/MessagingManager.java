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

package moe.orangemc.luckyfish.bungeecommons.messaging;

import net.md_5.bungee.api.config.ServerInfo;

public interface MessagingManager {
	/**
	 * Registers a type adapter
	 * @param target target class to be registered
	 * @param typeAdapter target type adapter to be registered
	 * @throws IllegalArgumentException when target class is already registered
	 */
	<T> void registerTypeAdapter(Class<T> target, TypeAdapter<T> typeAdapter);

	/**
	 * Registers a communication channel
	 * @param channel the channel to be registered
	 * @param callback callback when receive the message
	 * @throws IllegalArgumentException when target channel is already registered
	 */
	<T> void registerChannel(String channel, MessageCallback<T> callback);

	/**
	 * Sends a plugin message to player/bungee
	 * @param channel the channel to send message on
	 * @param targetServer the server to send message
	 * @param messageObject the message object to send message (Maybe you need to register a type adapter for it)
	 * @throws IllegalArgumentException when target channel is not registered
	 */
	void sendMessage(String channel, ServerInfo targetServer, Object messageObject);

	/**
	 * Checks if the message channel is registered
	 * @param channel the channel to be checked
	 * @return true if channel is registered, false on otherwise
	 */
	boolean isChannelRegistered(String channel);
}
