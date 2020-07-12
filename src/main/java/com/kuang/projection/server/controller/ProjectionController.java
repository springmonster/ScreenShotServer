package com.kuang.projection.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@Slf4j
public class ProjectionController {

    private String image = "";

    @Autowired
    private H5WebSocket h5WebSocket;

    @PostMapping("/image")
    @ResponseBody
    public String image(@RequestParam String image) {
        this.image = image;
        log.info("received image base64 is {}", image);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        try {
            h5WebSocket.sendMessage("data:image/png;base64," + image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

//    @GetMapping("/index")
//    public String index(Model model) {
//        model.addAttribute("image", "data:image/png;base64," + image);
//        return "index";
//    }
}
