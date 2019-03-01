
public class ContaSimples{

	private String codigo;
	private int saldo = 0;

	public ContaSimples (String p_id, int p_saldo) { 
	    this.saldo = p_saldo;
	    this.codigo = p_id;
	}
	
	public int getSaldo() {
		return saldo;
	} 

	public boolean debitar(int valor) {
		
		
		if( valor > 0 ){
	         saldo = saldo-valor; 
                }
		else{
			return false;
		}
	  
                return true;
	}


	public boolean creditar (int valor) {
		
		
		if(valor > 0 ){
	         saldo = saldo+valor;
        
	        }
		else{
		    return false;
			
		}
	   
		return true;

	}
	
	/* Este método transfere o valor da conta origem para a conta destino. */

	 public void transferir (ContaSimples destino, int valor)  {
		 this.creditar(valor);
		 this.debitar(valor);
          }	
	
	 
	}

