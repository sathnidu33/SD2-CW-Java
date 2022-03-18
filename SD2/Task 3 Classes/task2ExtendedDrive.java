import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task2ExtendedDrive {

        public static void main(String[] args) throws IOException {
            Scanner input = new Scanner(System.in);
            patient[] patients = new patient[6];
            String firstName;
            String lastName;
            String age;
            String city;
            String idNum;
            int boothNumber;
            String menuInput;
            int vaccineStock = 150;


            for (int i = 0; i < patients.length; i++) {
                firstName = "Empty";
                lastName = "-";
                age = "-";
                city = "-";
                idNum = "-";
                patients[i] = new patient(firstName, lastName, age, city, idNum);
            }


            while (true) {
                System.out.println("100 or VVB: View all Vaccination Booths");
                System.out.println("101 or VEB: View all Empty Booths");
                System.out.println("102 or APB: Add Patient to a Booth");
                System.out.println("103 or RPB: Remove Patient from a Booth");
                System.out.println("104 or VPS: View Patients Sorted in alphabetical order (Do not use library sort routine)");
                System.out.println("105 or SPD: Store Program Data into file");
                System.out.println("106 or LPD: Load Program Data from file");
                System.out.println("107 or VRV: View Remaining Vaccinations");
                System.out.println("108 or AVS: Add Vaccinations to the Stock");
                System.out.println("109 or VPD: View Patient Details");
                System.out.println("999 or EXT: Exit the Program");

                menuInput = input.next();

                if (menuInput.equals("100") || menuInput.equalsIgnoreCase("VVB")) { //View all Vaccination Booths
                    for (int i = 0; i < 6; i++) {
                        System.out.println("Booth No. " + i + " = " + patients[i].getFirstName()+" "+patients[i].getLastName());
                    }
                    System.out.println();
                }


               else if (menuInput.equals("101") || menuInput.toUpperCase().equals("VEB")) { //View all empty Booths
                    for (int i = 0; i < 6; i++) {
                        if (patients[i].getFirstName().equalsIgnoreCase("Empty")) {
                            System.out.println("Booth No." + i + " " + patients[i].getFirstName());

                        }
                    }
                    System.out.println();
                }


              else if (menuInput.equals("102") || menuInput.equalsIgnoreCase("APB")) { //add patient to Booth
                    Scanner input1 = new Scanner(System.in);
                    System.out.print("Please enter your first name: ");
                    firstName = input1.next();

                    System.out.print("Please enter your last name: ");
                    lastName = input1.next();

                    System.out.print("Please enter your age: ");
                    age=input1.next();

                    System.out.print("Please enter your city: ");
                    city=input1.next();
                    System.out.print("Please enter your NIC number: ");
                    idNum=input1.next();

                    System.out.println();
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Press 1 for AstraZeneca");
                    System.out.println("Press 2 for Sinopharm");
                    System.out.println("Press 3 for Pfizer");
                    System.out.print("Please enter the type of vaccine you need:  ");
                    int vaccineSelect = input3.nextInt();


                    if (vaccineSelect == 1) {

                        if (patients[0].getFirstName().equalsIgnoreCase("Empty")) {
                            patients[0].setFirstName(firstName);
                            patients[0].setLastName(lastName);
                            patients[0].setAge(age);
                            patients[0].setCity(city);
                            patients[0].setIdNum(idNum);
                            System.out.println();
                            System.out.println("Please go to booth NO. 00");
                            System.out.println();
                            vaccineStock = vaccineStock - 1;
                        } else if (patients[1].getFirstName().equalsIgnoreCase("Empty")) {
                            patients[1].setFirstName(firstName);
                            patients[1].setLastName(lastName);
                            patients[1].setAge(age);
                            patients[1].setCity(city);
                            patients[1].setIdNum(idNum);
                            System.out.println();
                            System.out.println("Please go to booth NO. 01");
                            System.out.println();
                            vaccineStock = vaccineStock - 1;
                        } else {
                            System.out.println();
                            System.out.println("BOOTH NUMBER 00 AND 01 IS NOT AVAILABLE AT THE MOMENT");
                        }
                    } else if (vaccineSelect == 2) {

                        if (patients[2].getFirstName().equalsIgnoreCase("Empty")) {
                            patients[2].setFirstName(firstName);
                            patients[2].setLastName(lastName);
                            patients[2].setAge(age);
                            patients[2].setCity(city);
                            patients[2].setIdNum(idNum);
                            System.out.println();
                            System.out.println("Please go to booth NO. 02");
                            System.out.println();
                            vaccineStock = vaccineStock - 1;

                        } else if (patients[3].getFirstName().equalsIgnoreCase("Empty")) {
                            patients[3].setFirstName(firstName);
                            patients[3].setLastName(lastName);
                            patients[3].setAge(age);
                            patients[3].setCity(city);
                            patients[3].setIdNum(idNum);
                            System.out.println();
                            System.out.println("Please go to booth NO. 01");
                            System.out.println();
                            vaccineStock = vaccineStock - 1;
                        } else {
                            System.out.println();
                            System.out.println("BOOTH NUMBER 00 AND 01 IS NOT AVAILABLE AT THE MOMENT");
                        }
                    } else if (vaccineSelect == 3) {

                        if (patients[4].getFirstName().equalsIgnoreCase("Empty")) {
                            patients[4].setFirstName(firstName);
                            patients[4].setLastName(lastName);
                            patients[4].setAge(age);
                            patients[4].setCity(city);
                            patients[4].setIdNum(idNum);
                            System.out.println();
                            System.out.println("Please go to booth NO. 02");
                            System.out.println();
                            vaccineStock = vaccineStock - 1;

                        } else if (patients[5].getFirstName().equalsIgnoreCase("Empty")) {
                            patients[5].setFirstName(firstName);
                            patients[5].setLastName(lastName);
                            patients[5].setAge(age);
                            patients[5].setCity(city);
                            patients[5].setIdNum(idNum);
                            System.out.println();
                            System.out.println("Please go to booth NO. 01");
                            System.out.println();
                            vaccineStock = vaccineStock - 1;
                        } else {
                            System.out.println();
                            System.out.println("BOOTH NUMBER 00 AND 01 IS NOT AVAILABLE AT THE MOMENT");
                        }

                    }
                    else {
                        System.out.println("Incorrect number!");
                        System.out.println();
                    }


                    if (vaccineStock == 20) {
                        System.out.println("ALERT: THE REMAINING VACCINE STOCK IS 20 !");
                    }
                }

                  else if (menuInput.equals("103") || menuInput.toUpperCase().equals("RPB")) { //Remove Patient from a Booth
                        Scanner input2 = new Scanner(System.in);
                        System.out.print("Enter your booth number: ");
                        int removePatient = input2.nextInt();

                        patients[removePatient].setFirstName("Empty");
                        patients[removePatient].setLastName("-");
                        System.out.println("Booth No. " + removePatient + " patient removed !");
                        System.out.println();
                    }


                else if (menuInput.equals("104") || menuInput.equalsIgnoreCase("VPS")) { //View Patients Sorted in alphabetical order
                    String temporary;
                    String [] temporaryArray = new String[6];
                    for (int z = 0; z < 6; z++) {
                        temporaryArray[z] = patients[z].getFirstName()+" "+patients[z].getLastName();
                    }
                    for (int j = 0; j < 6; j++) {
                        for (int k = j+1; k < 6; k++) {
                            if (temporaryArray[j].compareToIgnoreCase(temporaryArray[k]) > 0) {
                                temporary = temporaryArray[j];
                                temporaryArray[j] = (temporaryArray[k]);
                                temporaryArray[k] = temporary;
                            }
                        }
                    }
                    System.out.println("Patients in Alphabetical order are:");
                    for (int j = 0; j < 6; j++) {
                        if (temporaryArray[j].equalsIgnoreCase("empty")) {
                            System.out.println("_");
                        }
                        else {
                            System.out.println(temporaryArray[j]);
                        }
                    }

                    System.out.println(" ");

                }

                else if (menuInput.equals("105") || menuInput.toUpperCase().equals("SPD")) { //Store Data

                    File vaccineInformation = new File("patientInformation.txt");
                    FileWriter writeInfo = new FileWriter(vaccineInformation);
                    for (int z = 0; z < 6; z++) {
                        writeInfo.write("The Booth No."+" "+z+" "+"is"+" "+patients[z].getFirstName()+" "+patients[z].getLastName()+"\n");
                    }
                    writeInfo.close();
                    System.out.println(" ");

                }
                else if (menuInput.equals("106") || menuInput.toUpperCase().equals("LPD")) { //Load data

                    File vaccineInfo = new File("patientInformation.txt");
                    Scanner readInfo = new Scanner(vaccineInfo);
                    while (readInfo.hasNextLine()) {
                        String information = readInfo.nextLine();
                        System.out.println(information);
                    }
                    readInfo.close();
                    System.out.println(" ");

                }
                else if (menuInput.equals("107") || menuInput.toUpperCase().equals("VRV")) { //View Remaining Vaccinations
                    System.out.println("The remaining vaccine stock: " + vaccineStock);
                    System.out.println();
                }
                else if (menuInput.equals("108") || menuInput.toUpperCase().equals("AVS")) { //Add Vaccinations to the Stock
                    Scanner input3 = new Scanner(System.in);
                    System.out.print("Please enter the amount of vaccines to be add:  ");
                    int vaccineAdd = input3.nextInt();

                    vaccineStock = vaccineAdd + vaccineStock;
                    System.out.println(vaccineAdd + " Vaccines added to the stock successfully!");
                    System.out.println();
                }
                else if (menuInput.equals("109") || menuInput.toUpperCase().equals("VPD")) { //View all empty Booths
                    for(int i=0;i<patients.length;i++){
                        System.out.println("Booth No. " +i);
                        if(patients[i].getFirstName().equalsIgnoreCase("Empty")){
                            System.out.println("Name of the patient: -");
                        }
                        else {
                            System.out.println("Name of the patient: " + patients[i].getFirstName() + ' ' + patients[i].getLastName());
                        }
                        System.out.println("Age: "+patients[i].getAge());
                        System.out.println("City: "+patients[i].getCity());
                        System.out.println("NIC Number: "+patients[i].getIdNum());
                        System.out.println();
                        System.out.println();
                    }
                }
                else if (menuInput.equals("999") || menuInput.toUpperCase().equals("EXT")) { //View all empty Booths
                    break;

                }

            }
        }
    }




