package com.example.demo;

public class MyStack {
    int[] input;
    int curr = 0;
    public MyStack(int[] ints) {
        this.input = ints;
    }

    public void push(int num) {
        if(curr >= input.length) {
            resizeInput();
        }
        input[curr++] = num;
    }

    private void resizeInput() {
        int[] copy = new int[input.length*2];
        for(int i=0; i<input.length; i++) {
            copy[i] = input[i];
        }
        this.input = copy;
    }

    public int pop() {
        int ret = input[curr-1];
        input[--curr] = 0;
        return ret;
    }

    public int get() {
        return input[curr-1];
    }

    public int getSize() {
        return curr;
    }

}
