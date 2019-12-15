import ui.MainPageUI;

public class Main {
  public static void main(String[] args) {
	try {
	  MainPageUI.welcome();
	} catch (Exception e) {
      e.printStackTrace();
	}
  }
}
