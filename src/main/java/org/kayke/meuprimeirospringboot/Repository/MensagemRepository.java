package org.kayke.meuprimeirospringboot.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

    public String obterMensagem(){
        return "Olá repositório";
    }
}

