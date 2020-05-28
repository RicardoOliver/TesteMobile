package ricardomello.desafioqa.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import ricardomello.desafioqa.Funcionalidade.CadastroFuncionalidades;
import ricardomello.desafioqaMobile.utils.DeviceFabrica;
import ricardomello.desafioqaMobile.utils.ReportExtentReports;
import ricardomello.desafioqaMobile.utils.Enum.Device;
import ricardomello.desafioqaMobile.utils.Enum.Status;

public class CadastroSteps {
	AppiumDriver<MobileElement> driver;
	CadastroFuncionalidades login;

	@Dado("que esteja na tela inicial")
	public void que_esteja_na_tela_inicial() {
		try {
			login = new CadastroFuncionalidades();
			login.validarTelaInicial();
			ReportExtentReports.adicionarLog(Status.PASS,"Dado que esteja na tela inicial", true);
		}
		catch(Throwable erro) {
			ReportExtentReports.adicionarLog(Status.FAIL,"Erro: " + erro, true);
		}
	}
	
	
	@Quando("cadastrar um novo cliente com os dados {string}, {string}, {string} e {string}")
	public void cadastrar_um_novo_cliente_com_os_dados_e(String nome, String cpf, String dataNascimento, String email) {

		try {
			login.acessarTelaCadastro();
			login.preencherCadastroNovo(nome, cpf, dataNascimento, email);
			ReportExtentReports.adicionarLog(Status.PASS,"Quando cadastrar um novo cliente com os dados nome, cpf, dataNascimento e email", true);
		}
		catch(Throwable erro) {
			ReportExtentReports.adicionarLog(Status.FAIL,"Erro: " + erro, true);
		}
	}
	
	@Entao("deve ser exibido a mensagem de cadastro efetuado")
	public void deve_ser_exibido_a_mensagem_de_cadastro_efetuado() {
		
		try {
			login.salvarNovoCadastro();
			ReportExtentReports.adicionarLog(Status.PASS,"Entao deve ser exibido a mensagem de cadastro efetuado", true);
		}
		catch(Throwable erro) {
			ReportExtentReports.adicionarLog(Status.FAIL,"Erro: " + erro, true);
		}
	}
	
	@Dado("que tenha ao menos um cliente cadastrado")
	public void que_tenha_ao_menos_um_cliente_cadastrado() {
		
		try {
			login = new CadastroFuncionalidades();
			login.validarExisteCadastro();
			ReportExtentReports.adicionarLog(Status.PASS,"Dado que tenha ao menos um cliente cadastrado", true);
		}
		catch(Throwable erro) {
			ReportExtentReports.adicionarLog(Status.FAIL,"Erro: " + erro, true);
		}
	}
	@Quando("acessar e excluir o cliente")
	public void acessar_e_excluir_o_cliente() {

		try {
			login.selecionarCliente();
			login.excluirCadastro();
			ReportExtentReports.adicionarLog(Status.PASS,"Quando acessar e excluir o cliente", true);
		}
		catch(Throwable erro) {
			ReportExtentReports.adicionarLog(Status.FAIL,"Erro: " + erro, true);
		}
	}

	@Entao("o cliente deve ser removido da tela inicial")
	public void o_cliente_deve_ser_removido_da_tela_inicial() {
		
		try {
			login.validarNaoExisteCadastro();
			ReportExtentReports.adicionarLog(Status.PASS,"Entao o cliente deve ser removido da tela inicial", true);
		}
		catch(Throwable erro) {
			ReportExtentReports.adicionarLog(Status.FAIL,"Erro: " + erro, true);
		}
	}
	
	@Quando("atualizar os dados do cliente com {string}, {string}, {string} e {string}")
	public void atualizar_os_dados_do_cliente_com_e(String nome, String cpf, String dataNascimento, String email) {

		try {
			login.selecionarCliente();
			login.preencherCadastroNovo(nome, cpf, dataNascimento, email);
			ReportExtentReports.adicionarLog(Status.PASS,"Quando atualizar os dados cliente com nome, cpf, dataNascimento e email", true);
		}
		catch(Throwable erro) {
			ReportExtentReports.adicionarLog(Status.FAIL,"Erro: " + erro, true);
		}
	}

	@Entao("deve ser exibido a mensagem de cadastro atualizado")
	public void deve_ser_exibido_a_mensagem_de_cadastro_atualizado() {

		try {
			login.atualizarCadastro();
			ReportExtentReports.adicionarLog(Status.PASS,"Entao deve ser exibido a mensagem de cadastro atualizado", true);
		}
		catch(Throwable erro) {
			ReportExtentReports.adicionarLog(Status.FAIL,"Erro: " + erro, true);
		}
	}
	
	@Before
	public static void adicionarTesteNoReport(Scenario scenario) {
		DeviceFabrica.configurarDevice(Device.ANDROID);
		String nomeTeste = scenario.getName();
		ReportExtentReports.adicionarTeste("Ame Digital", nomeTeste);
		
		
	}
	@After
	public static void finalizarTesteNoReport() {
		ReportExtentReports.finalizarTeste();
		DeviceFabrica.fechar();
	}
	
}
