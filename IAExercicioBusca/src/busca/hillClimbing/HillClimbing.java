package busca.hillClimbing;

import java.util.List;

public class HillClimbing {
	
	public ProblemaHC hillClimbing(List<ProblemaHC> problemas){
		ProblemaHC melhor;
		ProblemaHC aux;
		
		melhor = hillClimbing(problemas.get(0));
		for(int i = 1; i < problemas.size(); i++){
			aux = problemas.get(i);
			if(aux != null){
				if(aux.melhor(melhor)){
					melhor = aux;
				}
			}
		}
		
		return melhor;
	}
	
	public ProblemaHC hillClimbing(ProblemaHC problema){
		ProblemaHC atual = problema;
		List<ProblemaHC> sucessores;
		boolean mudou = false;
		
		if(problema.verificar()){
			while(true){
				sucessores = atual.sucessores();
				
				for(ProblemaHC sucessor : sucessores){
					if(sucessor.melhor(atual)){
						atual = sucessor;
						mudou = true;
					}
				}
				if(mudou != true){
					break;
				}
				mudou = false;
			}
			
		}else{
			System.out.println("inicio invalido");
			atual = null;
		}
		
		return atual;
	}

}
