package automatizadas;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;





public class BibliotecaTest {
	
	//private String urele; 

	public static void main(String[] args) throws InterruptedException{
		//urele= "http://www.um.edu.ar/es/"; 
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.um.edu.ar/es/");			
		
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
	



	
	

		
		// POSTA..
		
		//<div style="position:absolute; top:0px; left:0px;"><a href="/es/um/biblioteca.html"><img src="/es/templates/umendoza/images/invisible.gif" border="0"></a></div>
		//driver.findElement(By.tagName("img")).click();
		
		
	

		driver.findElement(By.className("botonSecundarioUniversidad2")).click();
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		driver.findElement(By.className("botonPrincipalBiblioteca1")).click();
		String currentURL1 = driver.getCurrentUrl();
		System.out.println(currentURL1);
		Thread.sleep(100);
		driver.findElement(By.id("busqueda")).sendKeys("El proceso unificado");
		driver.findElement(By.id("buscar")).click();
		try {
			Thread.sleep(100);
			driver.findElement(By.id("busqueda")).clear();
		}catch (Exception e) {
		System.out.println("No existe el elemento");
		}
		
		driver.findElement(By.linkText("EL PROCESO UNIFICADO DE DESARROLLO DE SOFTWARE")).click();
		String currenetURL3 = driver.getCurrentUrl();
		System.out.println(currenetURL3);	
	    Thread.sleep(400);

		driver.quit();
	}

}
//Hace print de lo que le indique cap 15
/*File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try{
	FileUtils.copyFile(scrFile, new File("C://Users//Public//printUM1.png"));
}catch(IOException e) {
	e.printStackTrace();
}*/


/*********************************************************************************
  public class BibliotecaTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver ","C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		try {
			WebDriver driver = new FirefoxDriver();
			driver.get("http://um.edu.ar");
			Thread.sleep(1800);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
 *************************************************************************************/
