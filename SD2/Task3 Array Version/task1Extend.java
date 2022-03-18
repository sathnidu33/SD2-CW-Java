import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class task1Extend {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String patientName;
        String patientLastName;
        int tokenNum;
        String agentName;
        int boothNum =0;
        String[] firstName = new String[6];  //to store first name of patients
        String[] lastName  = new String[6];//to store last name of patients
        initialize(firstName);
        String menuInput;
        int vaccineStock=150;
        File dataFile=new File("vaccinationData.txt");




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

            if(menuInput.equals("100")||menuInput.equalsIgnoreCase("VVB")){ //View all Vaccination Booths
                for(int i=0;i < 6;i++){
                    System.out.println("Booth NO."+i+" is "+firstName[i]+" "+lastName[i]);

                }
            }
            if(menuInput.equals("101")||menuInput.equalsIgnoreCase("VEB")){//View all Empty Booths
                for(int i=0;i<6;i++){
                    if(firstName[i].equals("Available")){
                        System.out.println("Booth No."+i+" "+firstName[i]);


                    }
                }

            }
            if(menuInput.equals("102")||menuInput.equalsIgnoreCase("APB")){//Add Patient to a Booth
                Scanner input1=new Scanner(System.in);
                System.out.print("Please enter first name: ");
                patientName=input1.next();
                System.out.print("Please enter your last name: ");
                patientLastName=input1.next();



                System.out.println();
                Scanner input3=new Scanner(System.in);
                System.out.println("Press 1 for AstraZeneca");
                System.out.println("Press 2 for Sinopharm");
                System.out.println("Press 3 for Pfizer");
                System.out.print("Please enter the type of vaccine you need:  ");
                int vaccineSelect=input3.nextInt();

                if (vaccineSelect==1){
                    if(firstName[0].toUpperCase().equals("AVAILABLE")){
                        firstName[0]=patientName;
                        lastName[0]=patientLastName;
                        System.out.println();
                        System.out.println("Please go to booth NO. 00");
                        System.out.println();
                        vaccineStock=vaccineStock-1;
                    }
                    else if(firstName[1].toUpperCase().equals("AVAILABLE")){
                        firstName[1]=patientName;
                        lastName[1]=patientLastName;
                        System.out.println();
                        System.out.println("Please go to booth NO. 01");
                        System.out.println();
                        vaccineStock=vaccineStock-1;
                    }
                    else{
                        System.out.println();
                        System.out.println("BOOTH NUMBER 00 AND 01 IS NOT AVAILABLE AT THE MOMENT");
                    }
                }
                else if (vaccineSelect==2){
                    if(firstName[2].toUpperCase().equals("AVAILABLE")){
                        firstName[2]=patientName;
                        lastName[2]=patientLastName;
                        System.out.println();
                        System.out.println("Please go to booth NO. 02");
                        System.out.println();
                        vaccineStock=vaccineStock-1;
                    }
                    else if(firstName[3].toUpperCase().equals("AVAILABLE")){
                        firstName[3]=patientName;
                        lastName[3]=patientLastName;
                        System.out.println();
                        System.out.println("Please go to booth NO. 03");
                        System.out.println();
                        vaccineStock=vaccineStock-1;
                    }
                    else{
                        System.out.println();
                        System.out.println("BOOTH NUMBER 02 AND 03 IS NOT AVAILABLE AT THE MOMENT");
                    }
                }
               else if (vaccineSelect==3){
                    if(firstName[4].toUpperCase().equals("AVAILABLE")){
                        firstName[4]=patientName;
                        lastName[4]=patientLastName;
                        System.out.println("Please go to booth NO. 02");
                        vaccineStock=vaccineStock-1;
                    }
                    else if(firstName[5].equalsIgnoreCase("AVAILABLE")){
                        firstName[5]=patientName;
                        lastName[5]=patientLastName;
                        System.out.println("Please go to booth NO. 03");
                        vaccineStock=vaccineStock-1;
                    }
                    else{
                        System.out.println();
                        System.out.println("BOOTH NUMBER 04 AND 05 IS NOT AVAILABLE AT THE MOMENT");
                    }
                }
               else{
                    System.out.println("Incorrect number!");
                    System.out.println();
                }


                if(vaccineStock==20){
                    System.out.println("ALERT: THE REMAINING VACCINE STOCK IS 20 !");
                }


            }
            if(menuInput.equals("103")||menuInput.equalsIgnoreCase("RPB")){ //Remove Patient from a Booth
                Scanner input4=new Scanner(System.in);
                System.out.print("Enter your booth number: ");
                int removePatient=input4.nextInt();

                firstName[removePatient]="AVAILABLE";
                lastName[removePatient]="";
                System.out.println("Patient in booth" +removePatient+ " removed ");

            }
            if(menuInput.equals("104")||menuInput.equalsIgnoreCase("VPS")){ //View Patients Sorted in alphabetical order

                String temporary;
                String [] temporaryArray = new String[6];
                for (int z = 0; z < 6; z++) {
                    temporaryArray[z] = firstName[z]+" "+lastName[z];
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
                System.out.println("Patients in Alphabetical order are: ");
                for (int j = 0; j < 6; j++) {
                    if (temporaryArray[j].equalsIgnoreCase("empty")) {
                        System.out.println("_");
                    }
                    else {
                        System.out.println(temporaryArray[j]);
                    }
                }
            }

            if(menuInput.equals("105")||menuInput.equalsIgnoreCase("SPD")){//Store Program Data into file

                File vaccineInfo = new File("patientInformation.txt");
                FileWriter writeInfo = new FileWriter(vaccineInfo);
                for (int z = 0; z < 6; z++) {
                    writeInfo.write("The Booth Number"+" "+z+" "+"is"+" "+firstName[z]+" "+lastName[z]+"\n");
                }
                writeInfo.close();

            }
            if(menuInput.equals("106")||menuInput.equalsIgnoreCase("LPD")){ //load program data
                File vaccineInfo = new File("patientInformation.txt");
                Scanner readInfo = new Scanner(vaccineInfo);
                while (readInfo.hasNextLine()) {
                    String information = readInfo.nextLine();
                    System.out.println(information);
                }
                readInfo.close();
            }

            if(menuInput.equals("107")||menuInput.equalsIgnoreCase("VRV")){ //View Remaining Vaccinations
                System.out.println("The remaining vaccine stock: "+vaccineStock);
            }
            if(menuInput.equals("108")||menuInput.equalsIgnoreCase("AVS")){//Add Vaccinations to the Stock
                Scanner input3=new Scanner(System.in);
                System.out.println("Please enter the amount of vaccines to be add: ");
                int addVaccine=input3.nextInt();
                vaccineStock=vaccineStock+addVaccine;
                System.out.println(addVaccine+"vaccines added successfully!");
            }

            if(menuInput.equals("999")||menuInput.equalsIgnoreCase("EXT")){
                break;
            }

        }
    }

    //        initialise(VaccinationCentre); //better to initialise in a procedure
//        while ( boothNum < 6 ){
//            for (int x = 0; x < 6; x++ ){
//                if (VaccinationCentre[x].equals("available"))System.out.println("booth " + x + " is available");
//            }
//            System.out.println("Enter booth number (0-5) or 6 to stop:" );
//            boothNum = input.nextInt();
//            System.out.println("Enter customer name for booth " + boothNum+" :" ) ;
//            PatientName = input.next();
//            VaccinationCentre[boothNum] = PatientName ;
//
//            for (int x = 0; x < 6; x++ ){
//                System.out.println("booth " + x + " occupied by " +VaccinationCentre[x]);
//            }
//        }
//    }
    private static void initialize (String[]hotelref){
        for (int j=0;j<6;j++){
            hotelref[j]="Available";
        }
        System.out.println("Initialize");
    }
}

