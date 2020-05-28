package TesteCadastro;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import ricardomello.desafioqaMobile.utils.ReportExtentReports;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", tags = "@Cadastro", 
glue = "ricardomello.desafioqa.steps", monochrome = true, dryRun = false)
public class CadastroTest {
	@BeforeClass
	public static void iniciarReport() {
		ReportExtentReports.iniciarReport("target/evidencia/", "AutomacaoMobile");
		ReportExtentReports.adicionarSuiteTeste("Ame Digital" ,"Teste Mobile");
	}

	
	@AfterClass
	public static void finalizarReport() {
		ReportExtentReports.finalizarReport();
	}
	

}
