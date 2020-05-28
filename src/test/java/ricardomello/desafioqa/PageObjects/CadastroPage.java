package ricardomello.desafioqa.PageObjects;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import org.openqa.selenium.WebElement;
public class CadastroPage {
	
		@FindBy(xpath ="//android.widget.TextView[normalize-space(@text) = 'Cadastro de Clientes']")
		WebElement lblCadastroClientes;
		
		@FindBy(xpath="//android.view.ViewGroup[@resource-id='br.com.dudstecnologia.cadastrodeclientes:id/floating_action_menu']/android.widget.ImageView")
		WebElement btnOpcoes;
		
		@FindBy(id="nomeLista")
		List<WebElement> listaNome;
		
		@FindBy(id="floating_novo")
		WebElement btnCadastrarNovo;
		
		
		@FindBy(id="editNome")
		WebElement txtNome;
		
		@FindBy(id = "editCpf")
		WebElement txtCpf;
		
		@FindBy(id = "editData")
		WebElement txtDataNascimento;
		
		@FindBy(id = "editEmail")
		WebElement txtEmail;
		
		@FindBy(id = "btnSalvar")
		WebElement btnSalvar;

		@FindBy(id = "btnExcluir")
		WebElement btnExcluir;
		
		@FindBy(id = "rdCompleto")
		WebElement rdbCompleto;
		
		//PopUp Confirmarção
		@FindBy(xpath="//android.widget.TextView[@text = 'Cadastro efetuado com sucesso']")
		WebElement lblCadastroEfetuado;
		
		@FindBy(xpath="//android.widget.TextView[@text = 'Cadastro atualizado com sucesso']")
		WebElement lblCadastroAtualizado;
		
		@FindBy(xpath="//android.widget.Button[@text = 'OK']")
		WebElement btnOK;
		
		@FindBy(xpath="//android.widget.TextView[@text = 'Tem certeza que deseja excluir este cadastro?']")
		WebElement lblExcluirCadastro;
		
		@FindBy(xpath="//android.widget.Button[@text = 'SIM']")
		WebElement btnSIM;
}
