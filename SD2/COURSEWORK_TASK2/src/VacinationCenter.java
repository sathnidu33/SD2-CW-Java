
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VacinationCenter {
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        Booth[] vaccinationBooths=new Booth[6];

        int vaccineStock=150;
        String patientName;
        String menuInput;
        int boothNumber;


        for(int i =0;i< vaccinationBooths.length;i++){

            vaccinationBooths[i]=new Booth("Available");

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
            System.out.println("999 or EXT: Exit the Program");

            menuInput = input.next();

            if (menuInput.equals("100") || menuInput.toUpperCase().equals("VVB")) { //View all Vaccination Booths
                for(int i=0;i<6;i++){
                    System.out.println("Booth No. "+i+" = "+vaccinationBooths[i].getPatientName());
                }
                System.out.println();
            }


          else if (menuInput.equals("101") || menuInput.toUpperCase().equals("VEB")) { //View all empty Booths
                for(int i=0;i<6;i++) {
                    if (vaccinationBooths[i].getPatientName().equals("Available")) {
                        System.out.println("Booth No." + i + " " + vaccinationBooths[i].getPatientName());

                    }
                }
                System.out.println();
            }


//
          else if (menuInput.equals("102") || menuInput.toUpperCase().equals("APB")) { //add patient to Booth
                Scanner input1 = new Scanner(System.in);
                System.out.print("Please enter patient name: ");
                patientName = input1.next();

                vaccineStock=vaccineStock-1;

                System.out.print("Enter booth number (0-5)");
                boothNumber = input.nextInt();
                vaccinationBooths[boothNumber].setPatientName(patientName);
                System.out.println();
                System.out.println("Patient "+patientName+" added to booth No. "+boothNumber);
                System.out.println();
                if(vaccineStock==20){
                    System.out.println("REMINDER: ONLY 20 VACCINES STOCKS AVAILABLE !");
                }

            }
          else if(menuInput.equals("103")||menuInput.toUpperCase().equals("RPB")) { //Remove Patient from a Booth
                Scanner input2=new Scanner(System.in);
                System.out.print("Enter your booth number: ");
                int removePatient=input2.nextInt();

                vaccinationBooths[removePatient].setPatientName("Available");
                System.out.println("Booth No. "+removePatient+" patient removed !");
                System.out.println();
            }

          else if (menuInput.equals("104") || menuInput.toUpperCase().equals("VPS")) { //View Patients Sorted in alphabetical order
                String temporary;
                for (int j = 0; j < 6; j++) {
                    for (int k = j+1; k < 6; k++) {
                        if (vaccinationBooths[j].getPatientName().compareToIgnoreCase(vaccinationBooths[k].getPatientName()) > 0) {
                            temporary = vaccinationBooths[j].getPatientName();
                            vaccinationBooths[j].setPatientName(vaccinationBooths[k].getPatientName());
                            vaccinationBooths[k].setPatientName(temporary);
                        }
                    }
                }
                System.out.println("Patients in Alphabetical order are:");
                for (int j = 0; j < 6; j++) {
                    if (vaccinationBooths[j].getPatientName().equalsIgnoreCase("empty")) {
                        System.out.println("_");
                    }
                    else {
                        System.out.println(vaccinationBooths[j].getPatientName());
                    }
                }
                System.out.println(" ");

            }
            else if(menuInput.equals("105")||menuInput.equalsIgnoreCase("SPD")){ //Store patient Information
                File vaccinationDetails = new File("patientInformation.txt");
                FileWriter writeVaccine = new FileWriter(vaccinationDetails);
                for (int z = 0; z < 6; z++) {
                    writeVaccine.write("The Booth Number"+" "+z+" "+"is"+" "+vaccinationBooths[z].getPatientName()+"\n");
                }
                writeVaccine.close();
                System.out.println(" ");
            }

            else if(menuInput.equals("106")||menuInput.toUpperCase().equals("LPD")){ //Load Program Data
                File vaccinationDetails = new File("patientInformation.txt");
                Scanner readVaccine = new Scanner(vaccinationDetails);
                while (readVaccine.hasNextLine()) {
                    String info = readVaccine.nextLine();
                    System.out.println(info);
                }
                readVaccine.close();
                System.out.println(" ");
            }


          else if(menuInput.equals("107")||menuInput.toUpperCase().equals("VRV")){ //View Remaining Vaccinations
                System.out.println("The remaining vaccine stock: "+vaccineStock);
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
          else if (menuInput.equals("999") || menuInput.toUpperCase().equals("EXT")) { //View all empty Booths
                break;

            }
        }
    }
}
