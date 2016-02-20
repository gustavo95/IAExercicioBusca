package missionariosECanibais;

import java.util.ArrayList;
import java.util.List;

import busca.largura.No;

public class EstadoMC extends No {
	
	private int missionariosLado1;
	private int canibaisLado1;
	private int missionariosLado2;
	private int canibaisLado2;
	private int ladoBarco;
	
	public EstadoMC(int missionariosLado1, int canibaisLado1, int missionariosLado2, int canibaisLado2, int ladoBarco) {
		super();
		this.missionariosLado1 = missionariosLado1;
		this.canibaisLado1 = canibaisLado1;
		this.missionariosLado2 = missionariosLado2;
		this.canibaisLado2 = canibaisLado2;
		this.ladoBarco = ladoBarco;
	}

	public boolean eFinal(){
		if(missionariosLado1 == 0 && canibaisLado1 == 0){
			return true;
		}
		return false;
	}
	
	public boolean repetido(No no){
		EstadoMC aux = (EstadoMC) no;
		if(missionariosLado1 == aux.getMissionariosLado1() && canibaisLado1 == aux.canibaisLado1 && ladoBarco == aux.ladoBarco){
			return true;
		}
		if(no.getPai() == null){
			return false;
		}
		return repetido(no.getPai());
	}
	
	public void valido(List<No> estados, No pai){
		if((missionariosLado1 >= canibaisLado1 || missionariosLado1 == 0) && (missionariosLado2 >= canibaisLado2  || missionariosLado2 == 0)
				&& !repetido(pai)){
			this.custo = pai.getCusto() + 1;
			this.nivel = pai.getNivel() + 1;
			this.pai = pai; 
			estados.add(this);
		}
	}
	
	public List<No> proximosEstado(){
		List<No> estados = new ArrayList<>();
		EstadoMC aux;
		
		if(ladoBarco ==  1){
			if(missionariosLado1 >= 1){
				aux = new EstadoMC(missionariosLado1 - 1, canibaisLado1, missionariosLado2 + 1, canibaisLado2, 2);
				aux.setOperação("Um missionario no barco. Atravessa o barco para o lado 2");
				aux.valido(estados, this);
				
				if(missionariosLado1 >= 2){
					aux = new EstadoMC(missionariosLado1 - 2, canibaisLado1, missionariosLado2 + 2, canibaisLado2, 2);
					aux.setOperação("Dois missionarios no barco. Atravessa o barco para o lado 2");
					aux.valido(estados, this);
				}
				
				if(canibaisLado1 >= 1){
					aux = new EstadoMC(missionariosLado1 - 1, canibaisLado1 - 1, missionariosLado2 + 1, canibaisLado2 + 1, 2);
					aux.setOperação("Um missionario e um canibal no barco. Atravessa o barco para o lado 2");
					aux.valido(estados, this);
				}
			}
			
			if(canibaisLado1 >= 1){
				aux = new EstadoMC(missionariosLado1, canibaisLado1 - 1, missionariosLado2, canibaisLado2 + 1, 2);
				aux.setOperação("Um canibal no barco. Atravessa o barco para o lado 2");
				aux.valido(estados, this);
				
				if(canibaisLado1 >= 2){
					aux = new EstadoMC(missionariosLado1, canibaisLado1 - 2, missionariosLado2, canibaisLado2 + 2, 2);
					aux.setOperação("Dois canibais no barco. Atravessa o barco para o lado 2");
					aux.valido(estados, this);
				}
			}
		}
		
		if(ladoBarco ==  2){
			if(missionariosLado2 >= 1){
				aux = new EstadoMC(missionariosLado1 + 1, canibaisLado1, missionariosLado2 - 1, canibaisLado2, 1);
				aux.setOperação("Um missionario no barco. Atravessa o barco  para o lado 1");
				aux.valido(estados, this);
				
				if(missionariosLado2 >= 2){
					aux = new EstadoMC(missionariosLado1 + 2, canibaisLado1, missionariosLado2 - 2, canibaisLado2, 1);
					aux.setOperação("Dois missionarios no barco. Atravessa o barco  para o lado 1");
					aux.valido(estados, this);
				}
				
				if(canibaisLado2 >= 1){
					aux = new EstadoMC(missionariosLado1 + 1, canibaisLado1 + 1, missionariosLado2 - 1, canibaisLado2 - 1, 1);
					aux.setOperação("Um missionario e um canibal no barco. Atravessa o barco  para o lado 1");
					aux.valido(estados, this);
				}
			}
			
			if(canibaisLado2 >= 1){
				aux = new EstadoMC(missionariosLado1, canibaisLado1 + 1, missionariosLado2, canibaisLado2 - 1, 1);
				aux.setOperação("Um canibal no barco. Atravessa o barco  para o lado 1");
				aux.valido(estados, this);
				
				if(canibaisLado2 >= 2){
					aux = new EstadoMC(missionariosLado1, canibaisLado1 + 2, missionariosLado2, canibaisLado2 - 2, 1);
					aux.setOperação("Dois canibais no barco. Atravessa o barco  para o lado 1");
					aux.valido(estados, this);
				}
			}
		}
		
		return estados;
	}

	public int getMissionariosLado1() {
		return missionariosLado1;
	}

	public int getCanibaisLado1() {
		return canibaisLado1;
	}

	public int getMissionariosLado2() {
		return missionariosLado2;
	}

	public int getCanibaisLado2() {
		return canibaisLado2;
	}

	public int getLadoBarco() {
		return ladoBarco;
	}
	
}
