package com.BlogPessoal.BlogPessoal.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/privaty")
public class PrivateController {
    @GetMapping
    public String getMensagem(){
        return "VOU COMEÇAR A BATER EM MULHER";
    }
}
