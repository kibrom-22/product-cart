package com.generation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.generation.model.dto.ItemDto;

@Entity
@Table(name = "Item")
public class Item{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String serialNumber;
	
	@ManyToOne
	private Cart cart;
	
	
	public Item() {
		
	}

	public Item(Long id, String serialNumber, Cart cart) {
		super();
		this.cart = cart;
		this.id = id;
		this.serialNumber = serialNumber;
	}

   public static Item from(ItemDto itemDto) {
	   Item item = new Item();
	   item.setSerialNumber(itemDto.getSerialNumber());
       return item;
   }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	

}
