package com.pressstart.spaceinvaders.savegameapi;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "name")
@Getter
@Setter
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	@Setter(AccessLevel.NONE)
	private Long id;

	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(name = "Score", nullable = false)
	private int score;
	
	@Builder
	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
}
