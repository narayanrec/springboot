package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stack")
public class StackController {
    MyStack stack = new MyStack(new int[20]);
    @PostMapping("/push/{num}")
    public void push(@PathVariable int num) {
        stack.push(num);
    }

    @DeleteMapping("/pop")
    public int pop() {
        return stack.pop();
    }

    @GetMapping("/get")
    public int get() {
        return stack.get();
    }
}
