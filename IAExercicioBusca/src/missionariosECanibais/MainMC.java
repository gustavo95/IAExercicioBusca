package missionariosECanibais;

import busca.largura.Arvore;

public class MainMC {

	public static void main(String[] args) {
		EstadoMC estadoInicial = new EstadoMC(3, 3, 0, 0, 1);
		estadoInicial.setNivel(0);
		estadoInicial.setCusto(0);
		estadoInicial.setOperação("Inicio");
		
		Arvore busca = new Arvore(estadoInicial);
		busca.buscaLargura();

	}

}
