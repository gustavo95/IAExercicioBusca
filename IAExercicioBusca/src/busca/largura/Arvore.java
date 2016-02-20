package busca.largura;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import missionariosECanibais.EstadoMC;

public class Arvore {
	
	private No raiz;
	
	public Arvore(No raiz) {
		this.raiz = raiz;
	}

	public void buscaLargura(){
		Queue<No> fila = new LinkedList<No>();
		List<No> proximosEstados;
		No aux;
		
		fila.offer(raiz);
		
		while(!fila.isEmpty()){
			aux = fila.poll();
			//System.out.println(aux.getNivel() + " - (" + ((EstadoMC)aux).getMissionariosLado1() + "," + ((EstadoMC)aux).getCanibaisLado1()+
			//		"," +((EstadoMC)aux).getMissionariosLado2() + "," + ((EstadoMC)aux).getCanibaisLado2() + ") - " + aux.getOperação());
			if(aux.eFinal()){
				passos(aux);
				break;
			}else{
				proximosEstados = aux.proximosEstado();
				for(No estado : proximosEstados){
					fila.offer(estado);
				}
			}
		}
	}
	
	public void passos(No estado){
		
		if(estado.getPai() != null){
			passos(estado.getPai());
		}
		
		System.out.println(estado.getNivel() + " - " + 
				"(" + ((EstadoMC)estado).getMissionariosLado1() + "," + ((EstadoMC)estado).getCanibaisLado1()+
				"," +((EstadoMC)estado).getMissionariosLado2() + "," + ((EstadoMC)estado).getCanibaisLado2() + ") - "
				+ estado.getOperação());
	}

}
