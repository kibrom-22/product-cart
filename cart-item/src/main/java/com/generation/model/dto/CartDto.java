package com.generation.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.generation.model.Cart;
import com.generation.model.Item;

public class CartDto {
	private Long id;
	private String name;
	private List<ItemDto> itemsDto = new ArrayList<>();

	public CartDto() {
		
	}

	public Long getId() {
		return id;
	}
	
	//we need the static methodeto convert cart object into cartDto object
    public static CartDto from(Cart cart) {
    	CartDto cartDto = new CartDto();
    	//iterate the items from cart object
    	cartDto.setId(cart.getId());
    	cartDto.setName(cart.getName());
    	cartDto.setItemsDto(cart.getItems().stream().map(ItemDto::from).collect(Collectors.toList()));
    	return cartDto;
    }
	public CartDto(Long id, String name, List<ItemDto> itemsDto) {
		super();
		this.id = id;
		this.name = name;
		this.itemsDto = itemsDto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemDto> getItemsDto() {
		return itemsDto;
	}

	public void setItemsDto(List<ItemDto> itemsDto) {
		this.itemsDto = itemsDto;
	}


	
	
}
