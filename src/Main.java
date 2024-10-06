import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

        public class Main {



            public static void main(String[] args) throws  SQLException{
                Scanner scan = new Scanner(System.in);

                boolean program = true;

                while(program){
                    UI.HovedMenu();

                    int choice = scan.nextInt();
                    scan.nextLine();

                    switch (choice){
                        case 1: //see list of contracts
                        Database_Handle.seeContracts();
                            break;

                        case 2: //see the list of cars
                            Database_Handle.seeCarTypes();
                            break;

                        case 3: //see the list of costumers
                            Database_Handle.seeListCustomers();
                            break;

                        case 4: //make a new contract
                            Database_Handle.makeNewContract();
                            break;

                        case 5://edit a car (odometer)
                            Database_Handle.edit_Car();
                            break;

                        case 6: //Edit a contract (end date)
                            Database_Handle.edit_Contract();
                            break;

                        case 7: //Search contract
                            System.out.println("whats the contract number");
                            int id = scan.nextInt();
                            Database_Handle.searchContract(id);
                            break;

                        case 8:
                            Database_Handle.seeContractPeriod();
                            break;

                        case 9:
                            Database_Handle.deleteContract();
                            break;

                        case 10:
                            program = false;
                            System.exit(0);
                            break;
                            
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
            }
        }
