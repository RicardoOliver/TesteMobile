package ricardomello.desafioqa.PageObjects;

import org.openqa.selenium.support.PageFactory;
import ricardomello.desafioqaMobile.utils.DeviceFabrica;

public class CadastroObject extends CadastroPage{
	
	public CadastroObject() {
		PageFactory.initElements(DeviceFabrica.getDriver(), this);
	}

	public Boolean validarTelaInicial() {
		return lblCadastroClientes.isDisplayed();
	}
	
	public void clicarMenuOpcoes() {
		btnOpcoes.click();
	}
	
	public void clicarCadastrarNovo() {
		btnCadastrarNovo.click();
	}
	
	public void preencherNome(String nome) {
		txtNome.sendKeys(nome);
	}
	public void preencherCpf(String cpf) {
		txtCpf.sendKeys(cpf);
	}
	public void preencherDataNascimento(String data) {
		txtDataNascimento.sendKeys(data);
	}
	public void preencherEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void clicarSalvar() {
		btnSalvar.click();
	}
	public void clicarExcluir() {
		btnExcluir.click();
	}
	
	public Boolean validarMensagemCadastroEfetuado() {
		return lblCadastroEfetuado.isDisplayed();
	}
	
	public Boolean validarMensagemCadastroAtualizado() {
		return lblCadastroAtualizado.isDisplayed();
	}
	
	public void clicarOkPopUp() {
		btnOK.click();
	}
	
	public void validarMensagemExclusao() {
		lblExcluirCadastro.isDisplayed();
	}
	
	public void clicarSimPopUp() {
		btnSIM.click();
	}

	public int existeClienteGerado() {
		return listaNome.size();
	}
	
	public void acessarCliente(int index) {
		listaNome.get(index).click();
	}
	
}

