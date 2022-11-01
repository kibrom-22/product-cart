package com.generation.exception;

import java.text.MessageFormat;

public class ItemNotFoundException extends RuntimeException{

	public ItemNotFoundException(final Long id) {
		super(MessageFormat.format("could not find item with id: {0}", id));
	}
}
