package com.generation.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.generation.model.Cart;
import com.generation.model.Item;
import com.generation.model.dto.CartDto;
import com.generation.model.dto.ItemDto;
import com.generation.serviceImpl.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	private final CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	
	@PostMapping
	public ResponseEntity<CartDto> addCart(@RequestBody final CartDto cartDto){
		Cart cart = cartService.addCart(Cart.from(cartDto));
	   return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CartDto>>getCarts(){
		List<Cart> carts = cartService.getCarts();
		List<CartDto> cartsDto = carts.stream().map(CartDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(cartsDto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartDto> getCart(@PathVariable("id") final Long id){
		Cart cart = cartService.getCart(id);
	return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CartDto> deleteCart(@PathVariable("id") final Long id){
		Cart cart = cartService.deleteCart(id);
	return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CartDto> editCart(@PathVariable("id") final Long id, final @RequestBody CartDto cartDto){
		Cart cart = cartService.editCart(id, Cart.from(cartDto));
	return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
	}
	//adding item to the cart
	@PostMapping("/{cartId}/items/{itemId}/add")
	public ResponseEntity<CartDto> addItemToCart(@PathVariable("cartId") final Long cartId, @PathVariable final Long itemId){
		Cart cart = cartService.addItemToCart(cartId, itemId);
		return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
	}
	
	//removing item from the cart
		@PostMapping("/{cartId}/items/{itemId}/remove")
		public ResponseEntity<CartDto> removeItemFromCart(@PathVariable("cartId") final Long cartId, @PathVariable final Long itemId){
			Cart cart = cartService.removeItemFromCart(cartId, itemId);
			return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
		}

}
