package param;

public class CalculoImpostoRenda {

	/**
	 * O valor de entrada deve ser um valor inteiro positivo que esta entre os seguintes intervalos:
	 * Caso 0:
	 * 		valor < 0
	 * Caso 1:
	 *		0 < valor <= 1200 -> 0% de imposto
	 * Caso 2:
	 *		1200 < valor <= 5000 -> 10% de imposto
	 * Caso 3:
	 *		5000 < valor <= 10000 -> 15% de imposto
	 * Caso 4:
	 *		valor > 10000 -> 20% de imposto
	 *	
	 * Teste 0: valor = -1
	 * Teste 1: valor = 0, 0.1, 1199.9, 1200.0
	 * Teste 2: valor = 1200.1, 4999.9, 5000.0
	 * Teste 3: valor = 5000.1, 9999.9, 10000
	 * Teste 4: valor = 10000.1, 12000
	 * @param valor
	 */
	public static double calculaImposto(double valor) {
	       //Declaração de Variáveis
	       double imposto;
	       double impostotot;
	       String porcento;

	       if(valor >= 0) {
	    	   if(valor <= 1200) {
	       			imposto = 1.0;
	       			porcento = "0%";
	       			impostotot = 0.0;
	       		}
	    	   else if(valor > 1200 && valor <= 5000) {
	    		   imposto = 1.1;
	    		   porcento = "10%";
	    		   impostotot = 0.1;
	    	   }
	    	   else if(valor > 5000 && valor <= 10000){
	    		   imposto = 1.15;
	    		   porcento = "15%";
	    		   impostotot = 0.15;
	    	   }
	    	   else{
	    		   imposto = 1.2;
	    		   porcento = "20%";
	    		   impostotot = 0.2;
	    	   }
	       }
	       else {
	    	   throw new ValorMenorZero("Fila Vazia.");
	       }
	     	       
	       return valor * imposto;
	    }
}
