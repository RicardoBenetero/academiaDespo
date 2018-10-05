
public class CartaoDeCredito extends Cartao {

	@Override
	public String getTipoPagamento() {
		return "cartao de credito";
	}

	@Override
	public boolean validar() {
		return true;
	}

}
