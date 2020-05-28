package ricardomello.desafioqaMobile.utils;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import ricardomello.desafioqaMobile.utils.ReportExtentReports;
import ricardomello.desafioqaMobile.utils.Enum.Device;
import ricardomello.desafioqaMobile.utils.Enum.Status;

public class DeviceFabrica {

	private static AndroidDriver  driver;

	public static AndroidDriver  configurarDevice(Device tipoDevice) {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			switch (tipoDevice) {
			case ANDROID:
				File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "/app/");
				File app = new File(appDir, "cadastro_clientes_teste.apk");

				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
				capabilities.setCapability("appPackage", "br.com.dudstecnologia.cadastrodeclientes");
				capabilities.setCapability("appActivity", "br.com.dudstecnologia.cadastrodeclientes.MainClientes");
				capabilities.setCapability("deviceName", "Android");
				capabilities.setCapability("noReset", "true");
				capabilities.setCapability("automationName", "UIAutomator2");
				capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

				break;
			default:
				driver = null;
				break;
			}
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (Exception erro) {
			ReportExtentReports.adicionarLog(Status.FAIL, "Falha ao iniciar o driver. Erro: " + erro, false);
		}

		return driver;
	}

	public static void fechar() {
		driver.quit();
	}

	public static AndroidDriver  getDriver() {
		return driver;
	}
}
