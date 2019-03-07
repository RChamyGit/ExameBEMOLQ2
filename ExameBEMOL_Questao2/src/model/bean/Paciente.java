/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
import java.time.LocalDate;
//defasado pra aplicacao sql import java.util.Date;
/**
 *
 * @author RICARDO
 */
public class Paciente{
    private long cpf; // int nao suporta valores de CPF em algumas faixas
    private String nome;
    private LocalDate dtnascto;

    /**
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dtnascto
     */
    public LocalDate getDtnascto() {
        return dtnascto;
    }

    /**
     * @param dtnascto the dtnascto to set
     */
    public void setDtnascto(LocalDate dtnascto) {
        this.dtnascto = dtnascto;
    }
    
}
