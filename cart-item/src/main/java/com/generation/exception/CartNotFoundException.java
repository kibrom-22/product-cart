package com.generation.exception;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException{
	public CartNotFoundException(final Long id) {
		super(MessageFormat.format("could not find cart with id: {0}", id));
	}

}
