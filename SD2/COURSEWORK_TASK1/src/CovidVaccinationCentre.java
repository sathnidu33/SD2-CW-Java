import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CovidVaccinationCentre {

    static String[] vaccinationCentre = new String[6];
    static String patientName;
    static int boothNum = 0;
    static int vaccineStock = 150;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        initialize(vaccinationCentre);
        String menuInput;


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

            menuInput = input.nextLine();

            if (menuInput.equals("100") || menuInput.toUpperCase().equals("VVB")) { //View all Vaccination Booths

                viewBooths();
            }
            if (menuInput.equals("101") || menuInput.toUpperCase().equals("VEB")) {//View all Empty Booths

                viewEmptyBooths();

            }
            if (menuInput.equals("102") || menuInput.toUpperCase().equals("APB")) {//Add Patient to a Booth

                addPatient();
            }


            if (menuInput.equals("103") || menuInput.toUpperCase().equals("RPB")) { //Remove Patient from a Booth

                removePatient();

            }
            if (menuInput.equals("104") || menuInput.toUpperCase().equals("VPS")) { //View Patients Sorted in alphabetical order

                alphabetical();
            }

            if (menuInput.equals("105") || menuInput.toUpperCase().equals("SPD")) {//Store Program Data into file

                storeData();

            }
            if (menuInput.equals("106") || menuInput.toUpperCase().equals("LPD")) {//Load Program Data from file

                loadData();

            }
            if (menuInput.equals("107") || menuInput.toUpperCase().equals("VRV")) { //View Remaining Vaccinations

                checkRemainingVaccine();

            }
            if (menuInput.equals("108") || menuInput.toUpperCase().equals("AVS")) {//Add Vaccinations to the Stock
                addVaccine();
            }

            if (menuInput.equals("999") || menuInput.toUpperCase().equals("EXT")) {//to terminate the program
                System.out.println("THANK YOU !");
                break;
            }
        }
    }


    private static void initialize(String[] ref) {
        for (int j = 0; j < 6; j++) {
            ref[j] = "available";
        }
    }

    private static void viewBooths() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Booth NO." + i + " is " + vaccinationCentre[i]);
            System.out.println();

        }
    }

    public static void viewEmptyBooths() {
        for (int i = 0; i < 6; i++) {
            if (vaccinationCentre[i].equals("available")) {
                System.out.println("Booth No." + i + " " + vaccinationCentre[i]);
                System.out.println();


            }
        }
    }

    public static void addPatient() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Please enter patient name: ");
        patientName = input1.next();

        System.out.print("Enter booth number (0-5) or 6 to stop: ");
        boothNum = input1.nextInt();
        System.out.println();
        System.out.println("Patient added to booth no."+boothNum);
        vaccinationCentre[boothNum] = patientName;
        vaccineStock = vaccineStock - 1;
        if (vaccineStock == 20) {
            System.out.println("ALERT: THE REMAINING VACCINE STOCK IS 20 !");
        }


    }

    public static void removePatient() {
        for (int i = 0; i < 6; i++) {
            Scanner input2 = new Scanner(System.in);
            System.out.print("Enter your booth number: ");
            int removePatient = input2.nextInt();

            vaccinationCentre[removePatient] = "available";

            System.out.println("Patient removed from booth No." + removePatient);
        }
    }


    public static void alphabetical() {

        String temporary;
        String [] temporaryArray = new String[6];
        for (int i = 0; i < 6; i++) {
            temporaryArray[i] = vaccinationCentre[i];
        }
        for (int j = 0; j < 6; j++) {
            for (int k = j+1; k < 6; k++) {
                if (temporaryArray[j].compareToIgnoreCase(temporaryArray[k]) > 0 ) {
                    temporary = temporaryArray[j];
                    temporaryArray[j] = temporaryArray[k];
                    temporaryArray[k] = temporary;
                }
            }
        }
        System.out.println("The Vaccination Center patients in Alphabetical order are:");
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

    public static void storeData()  throws IOException{
        File vaccinationData = new File("patientInformation.txt");
        FileWriter writeVaccine = new FileWriter(vaccinationData);
        for (int i = 0; i < 6; i++) {
            writeVaccine.write("The Booth No. "+i+" is "+vaccinationCentre[i]+" ");


        }
        writeVaccine.close();
    }

    public static void loadData()throws FileNotFoundException {
        File vaccinationData = new File("patientInformation.txt");
        Scanner readVaccine = new Scanner(vaccinationData);
        while (readVaccine.hasNextLine()) {
            String information = readVaccine.nextLine();
            System.out.println(information);
        }
        readVaccine.close();


    }

    public static void checkRemainingVaccine() {
        System.out.println("The remaining vaccine stock: " + vaccineStock);
        System.out.println();

    }

    public static void addVaccine() {

        Scanner input3 = new Scanner(System.in);
        System.out.println("Please enter the amount of vaccines to be add: ");
        int addVaccine = input3.nextInt();
        vaccineStock = vaccineStock + addVaccine;

    }

}

