package com.example.littleprojectspringbootjwttoken.exception;

public class MyError extends Error{
    public MyError(){
        throw new RuntimeException("not found");
    }
}
