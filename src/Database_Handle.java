import java.sql.*;

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


}

