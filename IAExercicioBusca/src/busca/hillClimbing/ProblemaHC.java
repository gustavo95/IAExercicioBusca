package busca.hillClimbing;

import java.util.List;

public interface ProblemaHC {
	
	abstract public List<ProblemaHC> sucessores();
	
	abstract public boolean verificar();
	
	abstract public boolean melhor(ProblemaHC problema);
	
}
