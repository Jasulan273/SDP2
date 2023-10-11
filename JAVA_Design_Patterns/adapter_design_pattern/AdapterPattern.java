package adapter_design_pattern;

//Define an interface,WebDriver,that declares methods for web driver actions
interface WebDriver {
	public void getElement();    //Method to get an element on a web page
	public void selectElement();  //Method to select an element on a web page
}

//Implement WebDriver interface for ChromeDriver
class ChromeDriver implements WebDriver {
	@Override
	public void getElement() {
		System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement() {
		System.out.println("Select element from ChromeDriver");
	}
}

//Define a class IEDriver that simulates Internet Explorer web driver actions
class IEDriver {
	public void findElement() {
		System.out.println("Find element from IEDriver");
	}

	public void clickElement() {
		System.out.println("Click element from IEDriver");
	}
}

//Create an WebDriverAdapter class to adapt the IEDriver to the WebDriver interface,and take data
class WebDriverAdapter implements WebDriver {
	IEDriver ieDriver;

	public WebDriverAdapter(IEDriver ieDriver) {
		this.ieDriver = ieDriver;

	@Override
	public void getElement() {
		//Adapt getElement to call findElement on IEDriver
		ieDriver.findElement();
	}

	@Override
	public void selectElement() {
		//Adapt selectElement to call clickElement on IEDriver
		ieDriver.clickElement();
	}
}

//Main class to demonstrate the ADP
public class AdapterPattern {
	public static void main(String[] args) {
		//Create a ChromeDriver instance and perform actions
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.getElement();
		chromeDriver.selectElement();

		//Create an IEDriver instance and perform actions
		IEDriver ieDriver = new IEDriver();
		ieDriver.findElement();
		ieDriver.clickElement();

		//Create a WebDriverAdapter to adapt the IEDriver to the WebDriver interface
		WebDriver webDriverAdapter = new WebDriverAdapter(ieDriver);
		webDriverAdapter.getElement();
		webDriverAdapter.selectElement();
	}
}
