package com.pressstart.spaceinvaders.savegameapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {}