
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class HomeInventory {  //create a home inventory class
		
	public static void addNewHome(ArrayList<HouseRethink> homeInventory) {
		String returnResult;
		Scanner scnr = new Scanner(System.in);	
		try {
			String addAnother = null;

			do {
				
				System.out.println("Enter home information in this format for the home you'd like to add: ");
				System.out.println("street_number street_name street_type city state zipcode model_name square_ft sale_status");
	
				String houseStreetAddress = scnr.next() + " " + scnr.next() + " " + scnr.next();
				String houseCity = scnr.next();
				String houseState = scnr.next();
				int houseZipcode = scnr.nextInt();
				String houseModelName = scnr.next();
				int houseSqFt = scnr.nextInt();
				String houseStatus = scnr.nextLine();
				
				HouseRethink homeId = new HouseRethink(houseStreetAddress, houseCity, houseState, houseZipcode, 
						houseModelName, houseSqFt, houseStatus);
				homeInventory.add(homeId);

				printList(homeInventory);
				System.out.println("Type Y to add another home or N to exit: ");
				addAnother = scnr.next();
			}
			while (addAnother.equals("Y"));
			returnResult = "Success";
		}
		catch (Exception failed) {
			returnResult = "Failed";
		}
		System.out.println("Home added status: " + returnResult);
	}

	public static void removeHome(ArrayList<HouseRethink> homeInventory) {
		String returnResult;
		try {
			String removeAnother = null;
			String inputStreetAddress;
			char removeAll;
			Scanner scnr = new Scanner(System.in);
			
			System.out.println("Do you want to remove all homes? Enter Y or N.");
			removeAll = Character.toUpperCase(scnr.next().charAt(0));
			
			if (removeAll == 'Y') {
				homeInventory.clear();
			}
			else {
				do {
					System.out.println("Enter the address for the home to be removed in this format: ");
					System.out.println("street_number street_name street_type");
					
					inputStreetAddress = scnr.next() + " " + scnr.next() + " " + scnr.next();
					System.out.println(inputStreetAddress);
					
					Iterator<HouseRethink> houseIterator = homeInventory.iterator();
					while (houseIterator.hasNext()) {
						HouseRethink house = houseIterator.next();
			            if (house.getStreetAddress().equals(inputStreetAddress)) {
			                houseIterator.remove();                  
			            }
			            else {
			                System.out.println("home not found"); 
			            }
			            break;
					}
		printList(homeInventory);
					System.out.println("Type Y to remove another home or N to exit: ");
					removeAnother = scnr.next();
				}
				while (removeAnother.equals("Y")); 
			}
			returnResult = "Success";
		}
		catch (Exception failed) {
			returnResult = "Failed";
		}
		
		System.out.println("Home removed status: " + returnResult);
		}
	
	public static void updateHome(ArrayList<HouseRethink> homeInventory) {
		String returnResult;
		try {
			String updateAnother = null;
			Scanner scnr = new Scanner(System.in);
			
			do {
				System.out.println("Enter the address for the home to be updated in this format: ");
				System.out.println("street_number street_name street_type");
				String inputStreetAddress;
				String inputNewStatus;
				
				inputStreetAddress = scnr.nextLine();
				System.out.println("Enter new status");
				inputNewStatus = scnr.nextLine();
				
				Iterator<HouseRethink> houseIterator = homeInventory.iterator();
				
				while (houseIterator.hasNext()) {
					HouseRethink house = houseIterator.next();
		            if (house.getStreetAddress().equals(inputStreetAddress)) {
		                house.setStatus(inputNewStatus);   
		            	System.out.println("home is updated");	                    
		                break; 
		            }
		            else {
		                System.out.println("home not found"); 
		            }
		     }
				printList(homeInventory);
				System.out.println("Type Y to update another home or N to exit: ");
				updateAnother = scnr.nextLine();
			}
			while (updateAnother.equals("Y"));
			returnResult = "Success";
		}
		catch (Exception fail) {
			returnResult = "Failed";
		}
		System.out.println("Update house status: " + returnResult);
	}  
	
	public static void printList(ArrayList<HouseRethink> homeInventory) {
		String returnResult;	
		try {
			for (int i = 0; i < homeInventory.size(); ++i) {
				HouseRethink objHouse = homeInventory.get(i);
				System.out.println("");
				System.out.println("Home #" + (i + 1));
				System.out.println(objHouse.print());
				System.out.println("");
			}
			returnResult = "Success";
		}
		catch (Exception failed) {
			returnResult = "Failed";
		}
		System.out.println("Home inventory print to screen status: " + returnResult);
	} 
	
	public static void fileOutput(ArrayList<HouseRethink> homeInventory) throws IOException {
		String returnResult;
		FileOutputStream outputStream = null;
		try {	
			PrintWriter pWriter = null;
			
			outputStream = new FileOutputStream ("CSC320 Project output.txt");
			pWriter = new PrintWriter (outputStream);
			
			for (int i = 0; i < homeInventory.size(); ++i) {
				HouseRethink objHouse = homeInventory.get(i);
				pWriter.println(objHouse.print());
				pWriter.println("");
			}
			pWriter.flush();
			outputStream.close();
			returnResult = "Success";
		}
		catch (Exception failed) {
			returnResult = "Failed";
		}
		finally {
			outputStream.close();
		}
		System.out.println("Print to file status: " + returnResult);
	}


	public static void main(String[] args) throws IOException {
		String returnResult;
		Scanner scnr = new Scanner(System.in);
		try {
			ArrayList<HouseRethink> homeInventory = new ArrayList<HouseRethink>();
			char userNeeds;
		
			do {
			System.out.println("To add a home, type A. To remove a home, type R. To update a home type U. "
					+ "To print the inventory, type P. To exit, type E");
			userNeeds = scnr.next().charAt(0);
			userNeeds = Character.toUpperCase(userNeeds);
				if (userNeeds == 'A') {
					addNewHome(homeInventory);
				}
				else if (userNeeds == 'R') {
					removeHome(homeInventory);
				}
				else if (userNeeds == 'U') {
					updateHome(homeInventory);
				}
				else if (userNeeds == 'P') {
					System.out.println("Do you want to print to a file? Please enter Y or N.");
					char filePrint = scnr.next().charAt(0);
					filePrint = Character.toUpperCase(filePrint);
					
					if (filePrint == 'Y') {
						fileOutput(homeInventory);
					}
					else {
						System.out.println("A file will not be created and printed to.");
						printList(homeInventory);
					}
				}
				else if (userNeeds == 'E') {
					System.out.println("Bye!");
					break;
				}
				else {
					System.out.println("Please input a valid selection: A, R, U, P, E");
				}
			}
			while (userNeeds != 'E');
			returnResult = "Success";			
		}
		catch (Exception failed) {
			returnResult = "Failed";
		}
		finally {
			scnr.close();
		}
		System.out.println("Program execution result: " + returnResult);
	}
}
	




