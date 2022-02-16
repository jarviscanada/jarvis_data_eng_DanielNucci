package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");
        
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("George");
            customer.setLastName("MacDonald");
            customer.setEmail("george@mac.com");
            customer.setPhone("(555) 555-5555");
            customer.setAddress("1234 Main St");
            customer.setCity("Kingston");
            customer.setState("ON");
            customer.setZipCode("K1K 1K1");

            customerDAO.create(customer);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
