//wrote a menu class so it would be easy to print out the list of commands
public class Menu {
	
	String s = "";
	
	public Menu(){}
	
	public Menu(String s){
		this.s = s;
	}
	
	//returns the 3 commands from assignment that the user can choose from
	public String getCommands(){
		return "Enter the according number to answer a question: \n" +
				"[1] In what order can I take classes to complete my program? \n" +
				"[2] Assuming that I can take as many courses as needed each term, how many semesters does it take " +
				"to complete all courses and in what courses do I take in what order? \n" +
				"[3] What are the prerequisities for... (hitting #3 will ask you for the class) \n" +
				"[4] Enter 4 to Quit";
	}
	

}
