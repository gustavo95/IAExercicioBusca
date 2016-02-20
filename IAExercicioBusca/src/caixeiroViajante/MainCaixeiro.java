package caixeiroViajante;

import java.util.ArrayList;
import java.util.List;

import busca.hillClimbing.HillClimbing;
import busca.hillClimbing.ProblemaHC;
import caixeiroViajante.ProblemaCaixeiro;;

public class MainCaixeiro {

	public static void main(String[] args) {
		
		int mapa[][] = {{0, 30, 84, 56, 100000, 100000, 100000, 75, 100000, 80},
				{30, 0, 65, 100000, 100000, 100000, 70, 100000, 100000, 40},
				{84, 65, 0, 74, 52, 55, 100000, 60, 143, 48},
				{56, 100000, 74, 0, 135, 100000, 100000, 20, 100000, 100000},
				{100000, 100000, 52, 135, 0, 70, 100000, 122, 98, 80},
				{70, 100000, 55, 100000, 70, 0, 63, 100000, 82, 35},
				{100000, 70, 100000, 100000, 100000, 63, 0, 100000, 120, 57},
				{75, 100000, 135, 20, 122, 100000, 100000, 0, 100000, 100000},
				{100000, 100000, 143, 100000, 98, 82, 120, 100000, 0, 100000},
				{80, 40, 48, 100000, 80, 35, 57, 100000, 100000, 0}};
		
		ArrayList<Integer> cidades1 = new ArrayList<>();
		cidades1.add(1);
		cidades1.add(10);
		cidades1.add(2);
		cidades1.add(7);
		cidades1.add(9);
		cidades1.add(6);
		cidades1.add(5);
		cidades1.add(4);
		cidades1.add(3);
		cidades1.add(8);
		cidades1.add(1);
		
		ArrayList<Integer> cidades2 = new ArrayList<>();
		cidades2.add(1);
		cidades2.add(8);
		cidades2.add(3);
		cidades2.add(4);
		cidades2.add(5);
		cidades2.add(6);
		cidades2.add(9);
		cidades2.add(7);
		cidades2.add(2);
		cidades2.add(10);
		cidades2.add(1);
		
		List<ProblemaHC> lista = new ArrayList<ProblemaHC>();
		
		lista.add(new ProblemaCaixeiro(cidades1, mapa));
		lista.add(new ProblemaCaixeiro(cidades2, mapa));
		
		HillClimbing hc = new HillClimbing();
		System.out.println(hc.hillClimbing(lista).toString());

	}

}
