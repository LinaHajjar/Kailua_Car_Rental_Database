import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Database_Handle {

    public static Connection con;
    /*public static final String car_type = "com.mysql.jdbc.car_type";
    public static final String car = "com.mysql.jdbc.car";
    public static final String contracts = "com.mysql.jdbc.contracts";
    public static final String customers = "com.mysql.jdbc.customers";*/

    public static final String KailuaCarRental = "com.mysql.jdbc.KailuaCarRental";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/kailuacarrental";
    static String bruger = "root";
    static String password = "Ma2404ro@@@@";

    public static void seeContracts() throws SQLException {

        try {
            con = DriverManager.getConnection(DATABASE_URL, bruger, password);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM contracts");
            while (rs.next()) {
                System.out.println("Contract number: " + rs.getInt("contract_number"));
                System.out.println("Customer_id: " + rs.getInt("customer_id"));
                System.out.println("License-plate: " + rs.getString("regNb"));
                System.out.println("Rental start date: " + rs.getDate("rental_start_date"));
                System.out.println("Rental end date: " + rs.getDate("rental_end_date"));
                System.out.println("Maximum Kilometer driven: " + rs.getInt("maxKm"));
                System.out.println();
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }

    public static void seeCarTypes() throws SQLException {
        try {
            con = DriverManager.getConnection(DATABASE_URL, bruger, password);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM car_type");

            while (rs.next()) {
                System.out.println("Car type: " + rs.getInt("car_Id"));
                System.out.println("Ccm: " + rs.getInt("ccm"));
                System.out.println("Gear: " + rs.getString("gear"));
                System.out.println("Is there air condition T/F: " + rs.getBoolean("airCondition"));
                System.out.println("Cruise control T/F: " + rs.getBoolean("cruiseControl"));
                System.out.println("Number of seats " + rs.getInt("seatsNb"));
                System.out.println("Seats leather T/F" + rs.getBoolean("seatsLeather"));
                System.out.println("Horse power: " + rs.getInt("horsePower"));
                System.out.println("---------------------------------------------------------------");
                System.out.println();
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }//end of seeCarTypes

    public static void seeListCustomers() throws SQLException {
        try{
            con = DriverManager.getConnection(DATABASE_URL, bruger, password);
            Statement s= con.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM customers");

            while (rs.next()){
                System.out.println("Customer ID          : " + rs.getInt("customer_Id"));
                System.out.println("Customer Name        : " + rs.getString("customer_name"));
                System.out.println("Customer Address     : " + rs.getString("customer_address"));
                System.out.println("Zip code and City    : " + rs.getInt("zip_code")+ " " + rs.getString("city"));
                System.out.println("Customer Phone Number: "+ rs.getString("mobil_nr"));
                System.out.println("Customer Email       : " + rs.getString("email"));
                System.out.println("Driver Licence Number: " + rs.getString("driversLicence_Nb"));
                System.out.println("driver since         : " + rs.getDate("driver_since"));
                System.out.println("--------------------------------------------------------");
                System.out.println();
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }//end of seeListCustomers


    // method: make a new contract:
    public static void makeNewContract() throws SQLException {
        Scanner input = new Scanner(System.in);

        System.out.println("what is the number of this new contract?");
        int contract_number=input.nextInt();
        System.out.println("what is the customer Id");
        int customer_Id=input.nextInt();
        input.nextLine();

        if(customerExists(customer_Id)){
            System.out.println("your customer already exists, the customer will be added automatically to the new contract");
        }else{
            System.out.println("your customer doen't exists in your database, you will be now asked to add the information about your new customer:");
            addCustomer();
        }

        System.out.println("what is the license plate");
        String regNb=input.nextLine();
        System.out.println("what is the Rental start date? year-month-day");
        LocalDate rental_start_date=LocalDate.parse(input.nextLine());
        System.out.println("what is the Rental end date? year-month-day");
        LocalDate rental_end_date=LocalDate.parse(input.nextLine());
        System.out.println("How much do you expect to drive during the rental period");
        int maxKm=input.nextInt();
        input.nextLine();
        try{
            con=DriverManager.getConnection (DATABASE_URL, bruger, password);
            Statement s= con.createStatement();
            ResultSet rs = s.executeQuery("INSERT INTO contracts VALUES ( contract_number, customer_Id, regNb, rental_start_date, rental_end_date, maxKm)");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }//end of makeNewContract

    //method to check if a customer exists in my database:
    public static boolean customerExists(int customer_Id) {
        try {
            Connection con = DriverManager.getConnection(DATABASE_URL, bruger, password);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT 1 FROM customers WHERE customer_Id = " + customer_Id);
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }//end of costumerExists


    // method to add a new cutomer: addCustomer()
    public static void addCustomer() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("what is the ID of the new customer? ");
        int customer_Id=input.nextInt();
        System.out.println("what is the name of the new customer? ");
        String customer_name=input.nextLine();
        System.out.println("what is the name of the new customer? ");
        String customer_address=input.nextLine();
        System.out.println("what is the zip code? ");
        int zip_code=input.nextInt();
        System.out.println("the city? ");
        String city=input.nextLine();
        System.out.println("and the country? ");
        String country=input.nextLine();
        System.out.println("what is the phone number of your new customer? ");
        String mobil_nr=input.nextLine();
        System.out.println("what is the email of your customer? ");
        String email=input.nextLine();
        System.out.println("what is the driver's licence number? ");
        String driversLicence_Nb=input.nextLine();
        System.out.println("your customer has drived since: ");
        LocalDate driver_since=LocalDate.parse(input.nextLine());


        try{
            Connection con = DriverManager.getConnection(DATABASE_URL, bruger, password);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("INSERT INTO customers VALUES (customer_Id, customer_name, customer_address, zip_code, city, country, mobil_nr, email, driversLicence_Nb, driver_since)");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//end of add customer


}

