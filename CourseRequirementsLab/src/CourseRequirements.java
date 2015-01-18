import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CourseRequirements {
	public static void main(String[] args)
	{
		
		Menu m = new Menu(); //creates a new menu so can print out list
		String input = ""; //gets the input from the user
		ArrayList<ArrayList> newList = new ArrayList<ArrayList>(); //use an arraylist at each index of an arraylist to create a matrix
		
		//reads in text file
		try{
			Scanner fileIn = new Scanner(new File("CSCIRequirementsWord2.txt")); //gets text file for class prereqs
			
			int count = 0;
			while(fileIn.hasNext()){
				String classes = fileIn.next(); //receives each line from the document
				String list[] = classes.split(","); //separates each line by the comma
				newList.add(new ArrayList<String>()); //makes each position in arraylist equal an arraylist
				
				for(int i = 0; i < list.length; i++)
				{
					newList.get(count).add(list[i]); //makes each entry the entries in the second arraylist
				}
				count++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(m.getCommands());
		
		Scanner s = new Scanner(System.in);
		input = s.nextLine();
		boolean stillRunning = true;
		
		while(stillRunning){ //stops running once they press 4 to quit
			
			//gets an arraylist of all the main classes you have to take
			ArrayList coreClasses = new ArrayList();
			for(int i = 0; i < newList.size(); i++){
				coreClasses.add(newList.get(i).get(0).toString());
			}
			
			//checks input value to see what menu option the user opted for
			if(input.equals("1")){
				ArrayList<String> classes = new ArrayList<String>();
				
				//goes through and adds preReqs first, than the class you can take afterwards so order is correct
				for(int i = 0; i < newList.size(); i++){
					for(int y = 1; y < newList.get(i).size(); y++)
					{
						if(!(newList.get(i).get(y)).equals("X") && !classes.contains(newList.get(i).get(y))){
							classes.add(newList.get(i).get(y).toString());
						}
					}
					if(!classes.contains(newList.get(i).get(0))){
						classes.add(newList.get(i).get(0).toString());
					}
				}
				
				for(int i = 0; i < classes.size(); i++){
					System.out.println(classes.get(i));
				}
				//at end of each input, it asks you want another question answered
				System.out.println();
				System.out.println(m.getCommands());
				input = s.nextLine();
				
			}
			
			else if(input.equals("2")){
				System.out.println("You must take the classes in this order...");
	
				int numOfSemesters = 1;
				ArrayList<String> classesTaken = new ArrayList<String>();
				ArrayList<String> currentSemester = new ArrayList<String>();
							
				//gets an arraylist of all the main classes you have to take
				/*ArrayList coreClasses = new ArrayList();
				for(int i = 0; i < newList.size(); i++){
					coreClasses.add(newList.get(i).get(0).toString());
				}*/
				
				//gets an arraylist of all the classes going down y axis at 0
				ArrayList<String> allClasses = new ArrayList<String>();
				
				//checks to see if there are classes that aren't in the allClasses array. that is in semester 1
				for(int i = 0; i < newList.size(); i++){
					for(int y = 1; y < newList.get(i).size(); y++)
					{
						if(!(newList.get(i).get(y)).equals("X") && !allClasses.contains(newList.get(i).get(y))){
							allClasses.add(newList.get(i).get(y).toString());
						}
					}
					if(!allClasses.contains(newList.get(i).get(0))){
						allClasses.add(newList.get(i).get(0).toString());
					}
				}
				
				//add the main classes don't have a class that's in all classes, then add it to classesTaken and currentSemester
				//example: math207, comm104
				//also takes care of prereqs for the first class
				for(int i = 0; i < allClasses.size(); i ++){
					if(!coreClasses.contains(allClasses.get(i).toString())){
						classesTaken.add(allClasses.get(i).toString());
						currentSemester.add(allClasses.get(i).toString());
					}
				}
				
				//print out first semester, if there are classes that are prereqs
				if(currentSemester.size() > 0){
					System.out.println("Semester: " + numOfSemesters);
					for(int i = 0; i < currentSemester.size(); i++){
						System.out.println(currentSemester.get(i).toString());
					}
					numOfSemesters++;
					currentSemester.clear();
				}
					
				ArrayList<String> preReqs = new ArrayList<String>(); //array list of prereqs for each class
				String lastMainClass = ""; //last main class added
				String currentMainClass = ""; //current class going through their prereqs
				
				//going into for loop to go through each main class down y axis
				for(int i = 0; i < newList.size(); i++){
					currentMainClass = newList.get(i).get(0).toString(); //update the current main class
					for(int y = 1; y < newList.get(i).size(); y++){ //changed 0 to 1 to start at 1st preReq, gets the list of preReqs
						if(!newList.get(i).get(y).toString().equals("X")) preReqs.add(newList.get(i).get(y).toString());
					}
					
					//is the class already in currentSemester
					//if the preReq contains a class that's already in currentSemester
					for(int z = 0; z < preReqs.size(); z++){
						if(currentSemester.contains(preReqs.get(z))){
							System.out.println("Semester: " + numOfSemesters);
							for(int a = 0; a < currentSemester.size(); a++){
								System.out.println(currentSemester.get(a).toString());
							}
							numOfSemesters++;
							currentSemester.clear();
						}
					}
					
					//if statement prints out classes if the last main class added is in next preReq list
					//check if currentSemester contains a class thats a preReq WHAT IS THIS
					if(preReqs.contains(lastMainClass) && !classesTaken.contains(lastMainClass)){
						classesTaken.add(lastMainClass);
						if(!currentSemester.contains(lastMainClass)) currentSemester.add(lastMainClass);
						System.out.println("Semester: " + numOfSemesters);
						for(int a = 0; a < currentSemester.size(); a++){
							System.out.println(currentSemester.get(a).toString());
						}
						numOfSemesters++;
						currentSemester.clear();
					}
					else{
						currentSemester.add(currentMainClass);
						classesTaken.add(currentMainClass);
					}
					
					lastMainClass = currentMainClass;
					
				}
				
				//covers the last semester of classes that need to be printed out
				if(currentSemester.size() > 0){
					System.out.println("Semester: " + numOfSemesters);
					for(int a = 0; a < currentSemester.size(); a++){
						System.out.println(currentSemester.get(a).toString());
					}
					numOfSemesters++;
				}
				System.out.println();
				System.out.println(m.getCommands());
				input = s.nextLine();
			}
			
			else if(input.equals("3")){
				System.out.println("Enter the class: ");
				input = s.nextLine();
				//checks to see if that class is in the list
				if(!coreClasses.contains(input)) System.out.println("That is not an available class.");
				else{
					System.out.println("The necessary prerequistes are: ");
					
					//prints out the preReqs at each index
					for(int i = 0; i < newList.size(); i++)
					{
						if(newList.get(i).get(0).equals(input))
						{
							for(int y = 1; y < newList.get(i).size(); y++)
							{
								if(!(newList.get(i).get(y)).equals("X")){
									System.out.println((newList.get(i).get(y)) + " ");
								}
							}
						}
					}
					System.out.println();
					System.out.println(m.getCommands());
					input = s.nextLine();
				}
			}
			else if(input.equals("4")){
				stillRunning = false;
			}

			else{
				System.out.println("You entered a wrong value.");
				System.out.println();
				System.out.println(m.getCommands());
				input = s.nextLine();
			}
			
		}
	}

}
