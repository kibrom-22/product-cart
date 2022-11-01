package com.generation.model.dto;

import java.util.Objects;

import com.generation.model.Item;

public class ItemDto {
	
	private long id;
	private String serialNumber;
	private PlainCartDto plainCartDto;
	
	public ItemDto() {}
	
	
	public ItemDto(long id, String serialNumber, PlainCartDto plainCartDto) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.plainCartDto = plainCartDto;
	}


	public static ItemDto from(Item item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setId(item.getId());
		itemDto.setSerialNumber(item.getSerialNumber());
	   //check if returns null item
		if(Objects.nonNull(item.getCart())) {
			itemDto.setPlainCartDto(PlainCartDto.from(item.getCart()));
		}
		return itemDto;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public PlainCartDto getplainCartDto() {
		return plainCartDto;
	}
	
	public void setPlainCartDto(PlainCartDto plainCartDto) {
		this.plainCartDto = plainCartDto;
	}
	

}
