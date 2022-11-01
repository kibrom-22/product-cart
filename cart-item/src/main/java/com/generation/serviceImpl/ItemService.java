package com.generation.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.exception.ItemNotFoundException;
import com.generation.model.Item;
import com.generation.repository.CartRepository;
import com.generation.repository.ItemRepository;

@Service
public class ItemService {
	private final ItemRepository itemRepository;
    
    
    @Autowired
	public ItemService(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
		
	}
	
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> getItems(){
		return StreamSupport
				.stream(itemRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Item getItem(Long id) {
		return itemRepository.findById(id).orElseThrow(() ->
		 new ItemNotFoundException(id));
	}
	
	public Item deleteItem(Long id) {
		Item item = getItem(id);
				itemRepository.delete(item);
				return item;
	}
	
	@Transactional
	public Item editItem(Long id, Item item) {
		Item itemToEdit = getItem(id);
		itemToEdit.setSerialNumber(item.getSerialNumber());
	    return itemToEdit;
		
		/*
		if(item.getId() != null) {
		itemToEdit.setId(item.getId());
	}
	if(item.getSerialNumber() != null) {
		itemToEdit.setSerialNumber(item.getSerialNumber());
	}
	Item updatedItem = itemRepository.save(item);
	return updatedItem;
	*/
	}

}
