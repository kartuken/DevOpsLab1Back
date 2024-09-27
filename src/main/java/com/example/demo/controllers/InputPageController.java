package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;

@RequestMapping("/inputPage")
@Controller
public class InputPageController {

    @GetMapping
    public String inputGet(Model model){
        System.out.println("GET");
        return "inputPage";
    }
    @PostMapping
    public String inputSave(@RequestParam(value = "text", required = false) String text){
        if(text != null){
            try(FileWriter writer = new FileWriter("note.txt", false)){
                writer.append(text);
                writer.flush();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        return "inputPage";
    }

}
