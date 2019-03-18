public class FilaVaziaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FilaVaziaException(){
		super();
	}

	public FilaVaziaException(String mensagem){
		super(mensagem);
	}

	public FilaVaziaException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}