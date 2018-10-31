package src;

public class Autoridade implements FormatadorNome {

	private final static int INFORMAL = 1;
	private final static int RESPEITOSO = 2;
	private final static int COM_TITULO = 3;
	public final static int FEMININO = 0;
	public final static int MASCULINO = 1;
	private String nome, sobrenome;
	private String titulo;
	private int sexo;
	private int tratamento;
	

	public Autoridade(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		tratamento = INFORMAL;
	}

	public Autoridade(String nome, String sobrenome, int sexo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		tratamento = RESPEITOSO;
	}

	public Autoridade(String nome, String sobrenome, String titulo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.titulo = titulo;
		tratamento = COM_TITULO;
	}

	public String getTratamento() {
		return formatarNome(nome, sobrenome);
	}

	@Override
	public String formatarNome(String nome, String sobrenome) {
		if (tratamento == INFORMAL)
			return formatacaoInformal();
		if (tratamento == COM_TITULO)
			return formatacaoComTitulo();
		if (tratamento == RESPEITOSO)
			return formatacaoRespeitosa();
		throw new MensagemErroException("Tratamento incorreto");
	}

	private String formatacaoInformal() {
		return nome;
	}

	private String formatacaoComTitulo() {
		return titulo + " " + nome + " " + sobrenome;
	}

	private String formatacaoRespeitosa() {
		if (sexo == FEMININO)
			return "Sra. " + sobrenome;
		if (sexo == MASCULINO)
			return "Sr. " + sobrenome;
		throw new MensagemErroException("Sexo incorreto");
	}

}
