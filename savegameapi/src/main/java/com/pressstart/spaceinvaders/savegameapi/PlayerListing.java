package com.pressstart.spaceinvaders.savegameapi;

public record PlayerListing(String name, int score) {
	public PlayerListing(Player player) {
		this(player.getName(), player.getScore());
	}
}