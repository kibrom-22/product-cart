package com.generation.exception;

import java.text.MessageFormat;

public class ItemAlreadyAssignedException extends RuntimeException{
public ItemAlreadyAssignedException(final Long itemId, final Long cartId) {
	super(MessageFormat.format("Item: {0} is already assignd to cart: {1}", itemId, cartId));
}
	
}
