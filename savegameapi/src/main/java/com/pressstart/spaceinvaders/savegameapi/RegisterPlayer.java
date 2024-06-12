package com.pressstart.spaceinvaders.savegameapi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPlayer(@NotBlank String name, @NotNull int score) {}