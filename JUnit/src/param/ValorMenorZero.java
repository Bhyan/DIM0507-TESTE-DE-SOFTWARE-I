package param;

public class ValorMenorZero extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ValorMenorZero(){
		super();
	}

	public ValorMenorZero(String mensagem){
		super(mensagem);
	}

	public ValorMenorZero(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
