package org.serratec.backend.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseFuncionarioException {

    private int status;
    private String mensagem;
    private LocalDateTime dataHora;
    private List<String> erros;

    public ResponseFuncionarioException(int status, String mensagem, LocalDateTime dataHora, List<String> erros) {
        this.status = status;
        this.mensagem = mensagem;
        this.dataHora = dataHora;
        this.erros = erros;
    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public List<String> getErros() {
        return erros;
    }
}