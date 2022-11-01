package com.generation.model.dto;

import com.generation.model.Cart;

public class PlainCartDto {
	private Long id;
	private String name;
	
	public PlainCartDto() {}
	
	
	public PlainCartDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public static PlainCartDto from(Cart cart) {
		PlainCartDto plainCartDto = new PlainCartDto();
		plainCartDto.setId(cart.getId());
		plainCartDto.setName(cart.getName());
	return plainCartDto;
	}


	public Long getId() {
		return id;
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
	
	

}
