package busca.largura;

import java.util.List;

public abstract class No {

	protected No pai;
	protected String opera��o;
	protected int nivel;
	protected double custo;
	
	public No(){
		this.pai = null;
		this.opera��o = "";
		this.nivel = 0;
		this.custo = 0;
	}
	
	public No(No pai, String opera��o, int nivel, double custo) {
		this.pai = pai;
		this.opera��o = opera��o;
		this.nivel = nivel;
		this.custo = custo;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public String getOpera��o() {
		return opera��o;
	}

	public void setOpera��o(String opera��o) {
		this.opera��o = opera��o;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	abstract public boolean eFinal();
	
	abstract public List<No> proximosEstado();
	
}
