package fila;

public class Fila implements IFila {

	private static final int capacidade = 5; // tamanho máximo que a fila pode atingir
	private Object[] Fila;  //Array que representa a fila
	private final int tam; // tamanho atual da fila
	private int fim = -1; // contém o indice (no array) do ultimo elemento da fila

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public int getTam() {
		return tam;
	}
	
	public int getCapacidade() {
		return capacidade;
	}

	public Fila(){
		this(capacidade);
	}

	public Fila(int cap){
		tam = capacidade;
		Fila = new Object[tam];
	}

	public int tamanho() {
		return fim;
	}

	public boolean estaVazia() {
		return (fim == -1) ? true : false;
	}

	public boolean estaCheia() {
		return (fim == tam) ? true : false;
	}

	public void insereNaFila(Object obj) throws FilaCheiaException {
		fim++;
		Fila[fim] = obj;
	}

	public Object removeDaFila() throws FilaVaziaException {
		Object item = Fila[0];
		for(int k = 1; k < fim; k++)
			Fila[k-1] = Fila[k];
		return item;
	}

	public void limpaFila(){
		for(int i=0; i < tam; i++)
			Fila[i] = null;
		fim=-1;
	}
}
