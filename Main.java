import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

class Inventory {
    private String name;
    private String serialNumber;
    private int value;

    public Inventory(String name, String serialNumber, int value){
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
    }

    public String toString(){
        return name + "," + serialNumber + "," + value;
    }

    public String getName() {
        return this.name;
    }
    public String getSerialNumber() {
        return this.serialNumber;
    }
    public int getValue() {
        return this.value;
    }
	public void setName(String name) {
		this.name = name;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}

class Main {
	public static void main(String[] args) {
		ArrayList<Inventory> arrayList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int input;
		Inventory i;
		do{
			System.out.println("Press 1 to to add an item. \nPress 2 to delete an item. \nPress 3 to update an item. \nPress 4 to show all the items. \nPress 5 to quit the program.");
			input = scanner.nextInt();
			
			switch(input){
				case 1:
					System.out.println("Enter the name: ");
					scanner.nextLine();
					String name = scanner.nextLine();
					System.out.println("Enter the serial number: ");
					String serialNumber = scanner.next();
					System.out.println("Enter the value in dollars (whole number): ");
					int value = scanner.nextInt();
					i = new Inventory(name, serialNumber, value);
					arrayList.add(i);
					break;
				case 2:
					System.out.println("Enter the serial number of the item to delete: ");
					String serialNumber2 = scanner.next();
					Iterator itr = arrayList.iterator();
					while(itr.hasNext()){
						Inventory x = (Inventory)itr.next();
						if(x.getSerialNumber().contains(serialNumber2)){
							itr.remove();
						}
					}
					break;
				case 3:
					System.out.println("Enter the serial number of the item to change: ");
					String serialNumber3 = scanner.next();
					System.out.println("Enter the new name: ");
					scanner.nextLine();
					String name2 = scanner.nextLine();
					System.out.println("Enter the new value in dollars (whole number): ");
					int value2 = scanner.nextInt();
					for(Inventory c : arrayList) {
						if(c !=null && serialNumber3.equals(c.getSerialNumber())) {
							c.setName(name2);
							c.setValue(value2);
						}
					}
					break;
				case 4:
					for(Inventory j : arrayList){
						System.out.println(j.toString());
					}
				case 5:
					break;
			}
		}while(input != 5);
	}
}