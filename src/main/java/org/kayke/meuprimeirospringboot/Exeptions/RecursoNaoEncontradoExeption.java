package org.kayke.meuprimeirospringboot.Exeptions;

public class RecursoNaoEncontradoExeption extends  RuntimeException {

    public RecursoNaoEncontradoExeption(String mensagem) {
        super(mensagem);
    }
}
