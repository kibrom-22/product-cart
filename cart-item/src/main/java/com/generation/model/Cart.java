package com.generation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.generation.model.dto.CartDto;
@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	@OneToMany(
			cascade = CascadeType.ALL
			)
	@JoinColumn(name = "cart_id")
	private List<Item> items = new ArrayList<>();
	
	public Cart() {
		
	}
	
	

	public Cart(long id, String name, List<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}


   public void addItem(Item item) {
	   items.add(item);
   }
   public void removeItem(Item item) {
	   items.remove(item);
   }
   public static Cart from(CartDto cartDto) {
	   Cart cart = new Cart();
	   cart.setName(cartDto.getName());
	  
	   return cart;
   }
   
   
   
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
