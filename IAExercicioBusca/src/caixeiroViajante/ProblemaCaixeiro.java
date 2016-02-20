package caixeiroViajante;

import java.util.ArrayList;
import java.util.List;

import busca.hillClimbing.ProblemaHC;

public class ProblemaCaixeiro implements ProblemaHC {
	
	ArrayList<Integer> cidades;
	int mapa[][];
	int custoTotal;

	public ProblemaCaixeiro(ArrayList<Integer> cidades, int[][] mapa) {
		this.cidades = cidades;
		this.mapa = mapa;
		this.custoTotal = 100000;
	}

	public ProblemaCaixeiro() {
		this.cidades = null;
		this.mapa = null;
		this.custoTotal = 100000;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProblemaHC> sucessores() {
		List<ProblemaHC> sucessores = new ArrayList<ProblemaHC>();
		ProblemaHC sucessor;
		ArrayList<Integer> cidadesAUX;
		int aux;
		
		for(int i = 1; i < cidades.size()-2; i++){
			cidadesAUX = (ArrayList<Integer>) cidades.clone();
			
			aux = cidadesAUX.get(i);
			cidadesAUX.set(i, cidadesAUX.get(i+1));
			cidadesAUX.set(i+1, aux);
			
			sucessor = new ProblemaCaixeiro(cidadesAUX, mapa);
			if(sucessor.verificar()){
				sucessores.add(sucessor);
			}
		}
		
		return sucessores;
	}
	
	@Override
	public boolean verificar(){
		int distanciaTotal = 0;
		int distanciaLocal;

		for(int i = 0; i < cidades.size()-1; i++){
			distanciaLocal = mapa[cidades.get(i)-1][cidades.get(i+1)-1];
			if(distanciaLocal != 100000){
				distanciaTotal += distanciaLocal;
			}else{
				return false;
			}
			
		}
		custoTotal = distanciaTotal;
		return true;
	}

	@Override
	public boolean melhor(ProblemaHC problema) {
		if(custoTotal < ((ProblemaCaixeiro) problema).getCustoTotal()){
			return true;
		}
		return false;
	}

	public ArrayList<Integer> getCidades() {
		return cidades;
	}

	public int getCustoTotal() {
		return custoTotal;
	}
	
	public String toString(){
		String s = "";
		for(int i : cidades){
			s += i + " ";
		}
		s += "- " + custoTotal;
		return s;
	}

}
