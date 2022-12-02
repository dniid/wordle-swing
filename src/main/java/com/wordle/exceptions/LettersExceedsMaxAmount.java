package com.wordle.exceptions;

public class LettersExceedsMaxAmount extends RuntimeException {
    public LettersExceedsMaxAmount(String errMsg){
        super(errMsg);
    }
}