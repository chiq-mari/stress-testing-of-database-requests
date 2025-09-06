package project1;

import java.sql.*;

public class conexion {
    Connection con;
    Statement st;
    ResultSet rs;

    public void createConnection(){
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet exeQuery(String sql){
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public int updaQuery(String sql){
        int rows=0;
        try{
            st = con.createStatement();
            rows = st.executeUpdate(sql);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public void closeConnection(){
        try{
        con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //used at the very beginning to fill the database with 5000 rows
    public void filldb(){
        createConnection();
        for (int i =0; i<5000; i++){
            String descript= "oBxLIg4KmC62pUptMg1vRRytIiiRSWqhG0I2Or27bjFSULaFYJ2bnFdiThGCDFgDxBKk5lraZUulG7v3TgqtaTKNthjmGEVsxqQ3RVq4CL9ffI4dmIjJhKq6oDnBIWMakY9yMOeeIJaeUInh1P6yG1BWiIpnk0fAgRJiEfcLphPY5iCaYGjLBAWXWEwc7alF0UcqWPyAoBxLIg4KmC62pUptMg1vRRytIiiRSWqhG0I2Or27bjFSULaFYJ2bnFdiThGCDFgDxBKk5lraZUulG7v3TgqtaTKNthjmGEVsxqQ3RVq4CL9ffI4dmIjJhKq6oDnBIWMakY9yMOeeIJaeUInh1P6yG1BWiIpnk0fAgRJiEfcLphPY5iCaYGjLBAWXWEwc7alF0UcqWPyAoBxLIg4KmC62pUptMg1vRRytIiiRSWqhG0I2Or27bjFSULaFYJ2bnFdiThGCDFgDxBKk5lraZUulG7v3TgqtaTKNthjmGEVsxqQ3RVq4CL9ffI4dmIjJhKq6oDnBIWMakY9yMOeeIJaeUInh1P6yG1BWiIpnk0fAgRJiEfcLphPY5iCaYGjLBAWXWEwc7alF0UcqWPyAoBxLIg4KmC62pUptMg1vRRytIiiRSWqhG0I2Or27bjFSULaFYJ2bnFdiThGCDFgDxBKk5lraZUulG7v3TgqtaTKNthjmGEVsxqQ3RVq4CL9ffI4dmIjJhKq6oDnBIWMakY9yMOeeIJaeUInh1P6yG1BWiIpnk0fAgRJiEfcLphPY5iCaYGjLBAWXWEwc7alF0UcqWPyAoBxLIg4KmC62pUptMg1vRRytIiiRSWqhG0I2Or27bjFSULaFYJ2bnFdiThGCDFgDxBKk5lraZUulG7v3TgqtaTKNthjmGEVsxqQ3RVq4CL9ffI4dmIjJhKq6oDnBIWMakY9yMOeeIJaeUInh1P6yG1BWiIpnk0fAgRJiEfcLphPY5iCaYGjLBAWXWEwc7alF0UcqWPyA";
            updaQuery("insert into tabla (id, descript) values (default ,'"+descript+"')");
        }
        closeConnection();
    }


}
