package com.generation.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.exception.CartNotFoundException;
import com.generation.exception.ItemAlreadyAssignedException;
import com.generation.model.Cart;
import com.generation.model.Item;
import com.generation.repository.CartRepository;


@Service
public class CartService {
	private final CartRepository cartRepository;
	private final ItemService itemService;
	
	@Autowired
	public CartService(CartRepository cartRepository, ItemService itemService) {
		super();
		this.cartRepository = cartRepository;
		this.itemService = itemService;
		
	}
	
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public List<Cart> getCarts(){
		return StreamSupport
				.stream(cartRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Cart getCart(Long id) {
		return cartRepository.findById(id).orElseThrow(() ->
		 new CartNotFoundException(id));
	}
	
	public Cart deleteCart(Long id) {
		Cart cart = getCart(id);
		cartRepository.delete(cart);
				return cart;
	}
	
	@Transactional
	public Cart editCart(Long id, Cart cart) {
		Cart cartToEdit = getCart(id);
		cartToEdit.setName(cart.getName());
	    return cartToEdit;
	}
	//Cart-Item 
	//since we don't save the record we need to use @Transactional
	@Transactional
	public Cart addItemToCart(Long cartId, Long itemId) {
		Cart cart = getCart(cartId);
		Item item = itemService.getItem(itemId);
		//before we add check if item is assignd
		if(Objects.nonNull(item.getCart())) {
			//if Condition is true we throw an error
			throw new ItemAlreadyAssignedException(itemId, item.getCart().getId());
		}
		cart.addItem(item);
		item.setCart(cart);
		return cart;
	}
	
	@Transactional
	public Cart removeItemFromCart(Long cartId, Long itemId) {
		Cart cart = getCart(cartId);
		//to get the getItem method from serviceItem
		Item item = itemService.getItem(itemId);
		cart.removeItem(item);
		return cart;
	}
	
	
	
	

}
