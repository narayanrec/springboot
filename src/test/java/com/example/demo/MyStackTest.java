package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    MyStack stack = new MyStack(new int[20]);
    @BeforeEach
    void setUp() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @Test
    public void testStackPush() {

        assertEquals(5, stack.getSize());
    }

    @Test
    public void testStackPop() {
        assertEquals(5, stack.pop());;
        assertEquals(4, stack.getSize());
    }

    @Test
    public void testStackGet() {

        assertEquals(5, stack.get());
    }
}