package ricardomello.desafioqa.Funcionalidade;
import ricardomello.desafioqa.PageObjects.CadastroObject;

public class CadastroFuncionalidades {
	CadastroObject cadastro;
	
	public CadastroFuncionalidades() {
	    cadastro = new CadastroObject();
	}
	
	public void validarTelaInicial() {
	    assert(cadastro.validarTelaInicial()) : "Erro ao validar a tela inicial";
	}
	
	public void acessarTelaCadastro() {
		cadastro.clicarMenuOpcoes();
		cadastro.clicarCadastrarNovo();
	}
	
	public void preencherCadastroNovo(String nome, String cpf, String dataNascimento, String email) {
		cadastro.preencherNome(nome);
		cadastro.preencherCpf(cpf);
		cadastro.preencherDataNascimento(dataNascimento);
		cadastro.preencherEmail(email);
	}
	
	public void salvarNovoCadastro() {
		cadastro.clicarSalvar();
		assert(cadastro.validarMensagemCadastroEfetuado());
		cadastro.clicarOkPopUp();
	}
	
	public void atualizarCadastro() {
		cadastro.clicarSalvar();
		assert(cadastro.validarMensagemCadastroAtualizado());
		cadastro.clicarOkPopUp();
	}
	
	public void excluirCadastro() {
		cadastro.clicarExcluir();
		cadastro.validarMensagemExclusao();
		cadastro.clicarSimPopUp();
	}
	public void validarExisteCadastro() {
		assert(cadastro.existeClienteGerado()>0) : "Esperado que houvesse cliente";
	}
	public void validarNaoExisteCadastro() {
		assert(cadastro.existeClienteGerado()==0):"Esperado que não houvesse cliente";
	}
	
	public void selecionarCliente() {
		cadastro.acessarCliente(0);
	}
}
