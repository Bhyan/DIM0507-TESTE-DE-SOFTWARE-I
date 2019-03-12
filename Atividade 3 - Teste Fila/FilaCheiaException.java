package fila;


public class FilaCheiaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FilaCheiaException(){
		super();
	}

	public FilaCheiaException(String mensagem){
		super(mensagem);
	}

	public FilaCheiaException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}