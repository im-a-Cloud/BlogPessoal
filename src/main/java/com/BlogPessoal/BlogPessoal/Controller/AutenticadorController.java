package com.BlogPessoal.BlogPessoal.Controller;

import com.BlogPessoal.BlogPessoal.Service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticadorController {
    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/autenticar")
    public String autenticar(Authentication authentication){
        System.out.println("cuzinho");
        return autenticacaoService.autenticar(authentication);
    }
}
