public class Fila implements IFila {

	private static final int capacidade = 5; // tamanho máximo que a fila pode atingir
	private Object[] Fila;  //Array que representa a fila
	private final int tam; // tamanho atual da fila
	// Valor da variável fim alterado para 0.
	private int fim = 0; // contém o indice (no array) do ultimo elemento da fila

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

	/*
	 * Alteração: Variável tam recebe o valor passado por parâmetro para a função.
	 */
	public Fila(int cap){
		tam = cap;
		Fila = new Object[tam];
	}

	public int tamanho() {
		return fim;
	}

	public boolean estaVazia() {
		return (fim == 0) ? true : false;
	}

	public boolean estaCheia() {
		return (fim == tam) ? true : false;
	}

	/*
	 * Incremento da variável fim ficou após o uso dele no objeto Fila.
	 * Adicionado a checagem para avaliar se a lista está vazia e acionar a exception.
	 */
	public void insereNaFila(Object obj) throws FilaCheiaException {
		if(fim != tam) {
			Fila[fim] = obj;
			fim++;			
		}
		else {
			throw new FilaCheiaException("Fila Cheia.");
		}
	}

	/*
	 * Adicionado a checagem para avaliar se a lista está vazia e acionar a exception.
	 */
	public Object removeDaFila() throws FilaVaziaException {
		Object item = Fila[0];
		if(fim > 0) {
			for(int k = 1; k < fim; k++) {
				Fila[k-1] = Fila[k];
			}
			fim--;
		}
		else {
			throw new FilaVaziaException("Fila Vazia.");
		}
		return item;		
	}

	/*
	 * Adicionei a exception, pois a chance de dar erro caso tente limpar uma Fila vazia.
	 */
	public void limpaFila() throws FilaVaziaException{
		if(fim > 0) {
			for(int i=0; i < tam; i++)
				Fila[i] = null;
			fim = 0;
		}
		else {
			throw new FilaVaziaException("Fila Vazia.");
		}
	}
}
