package com.pressstart.spaceinvaders.savegameapi;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "name")

public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int score;
	
	public Player(Long id, String name, int score) {
		this.id = id;
		this.setName(name);
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void updateData(PlayerUpdate update) {
		if (update.name() != null) {
			this.setScore(update.name());
		}
		
		if (update.score() != 0) {
			this.setScore(update.score());
		}
	}
}