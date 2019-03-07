/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//emprestado da questao 1.
package controller;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author RICARDO
 */
public class Mascara {
    public class Mascaras {
	MaskFormatter mascaraData = new MaskFormatter();
	public MaskFormatter geraMascaraData(){
	try {
		mascaraData.setMask("##/##/####");
		mascaraData.setPlaceholderCharacter('_');
	} catch (ParseException e) {
		System.out.println("Erro na formatacao!"+e.getMessage());
	}
	return mascaraData;
	}
}
}
