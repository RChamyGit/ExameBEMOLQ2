/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.SimpleDateFormat; //JAVA 8
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; //JAVA 8 
import model.bean.Paciente;

/**
 *
 * @author RICARDO
 */
public class ControllerPaciente {
private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void controlePaciente(String cpf, String nome, String data){
        Paciente pac = new Paciente();
        pac.setCpf(Long.parseLong(cpf));
        pac.setNome(nome);
        pac.setDtnascto(LocalDate.parse(data, df)); 
        //converte string pra localdate c o formatador
    }
}
