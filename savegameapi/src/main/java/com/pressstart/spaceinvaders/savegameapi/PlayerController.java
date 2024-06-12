package com.pressstart.spaceinvaders.savegameapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private PlayerRepository repository;
	
	@PostMapping
	@Transactional
	public void register(@RequestBody @Valid RegisterPlayer data) {
		repository.save(new Player(null, data.name(), data.score()));
	}
	
	@GetMapping
	public List<PlayerListing> list() {
		return repository.findAll().stream().map(PlayerListing::new).toList();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void update(@PathVariable Long id, @RequestBody PlayerUpdate data) {
		var player = repository.getReferenceById(id);
		
		player.updateData(data);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}