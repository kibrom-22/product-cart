package com.generation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.generation.model.Item;
import com.generation.model.dto.ItemDto;
import com.generation.serviceImpl.ItemService;
@RestController
@RequestMapping("/items")
public class ItemController {
	
	private final ItemService itemService;
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	@PostMapping
	public ResponseEntity<ItemDto> addItem(@RequestBody final ItemDto itemDto){
		Item item = itemService.addItem(Item.from(itemDto));
	   return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ItemDto>> getItems(){
		List<Item> items = itemService.getItems();
	List<ItemDto> itemDto = items.stream().map(ItemDto::from).collect(Collectors.toList());
	return new ResponseEntity<>(itemDto, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ItemDto> getItem(@PathVariable("id") final long id){
		Item item = itemService.getItem(id);
	    return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ItemDto> deleteItem(@PathVariable("id") final long id){
		Item item = itemService.deleteItem(id);
	    return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemDto> editItem(@PathVariable("id") final long id, @RequestBody final ItemDto itemDto){
		Item itemToEdit = itemService.editItem(id, Item.from(itemDto));
		 return new ResponseEntity<>(ItemDto.from(itemToEdit), HttpStatus.OK);
	}
	
	
	
	
	
	

}
