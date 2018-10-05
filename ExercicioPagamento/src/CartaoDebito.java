
public class CartaoDebito extends Cartao{

	@Override
	public String getTipoPagamento() {
		return "cartao de debito";
	}

	@Override
	public boolean validar() {
		
		return true;
	}
	

	
	

}
