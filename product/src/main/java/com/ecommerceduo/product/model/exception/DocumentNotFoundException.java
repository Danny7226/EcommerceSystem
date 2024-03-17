package com.ecommerceduo.product.model.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentNotFoundException extends RuntimeException{
    final String message;
}
