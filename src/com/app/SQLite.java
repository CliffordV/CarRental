package com.app;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class SQLite {
    
    static java.sql.Connection conn  = null;
    static java.sql.Statement stmt = null;
    static String url = "jdbc:sqlite:C:\\Users\\VanderClifford\\Documents\\NetBeansProjects\\CarRental\\src\\com\\app\\sqlite.sqlite";
//    static String url = "<PATH>";
    static String error = "";
    
    public static boolean openDB(){
        boolean result = false;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = java.sql.DriverManager.getConnection(url);
            System.out.println("Connected!");
            
            result = true;
        }
        catch(Exception e){
            error = e.getMessage();
            System.out.println("Open DB Error:" + e.getMessage());
        } 
        
        return result;
    }
    
    public static boolean closeDB(){
        boolean result = false; 
        try{
            conn.close();
            
            System.out.println("DB closed.");
            result = true;
        }
        catch(Exception e){
            error = e.getMessage();
            System.out.println("Close DB Error:" + e.getMessage());
        }
        
        return result;
    }
    
    public static boolean create(String table, String set, String values){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "insert into "+ table + " ("+ set +") values(" + values + ")";
            stmt.executeUpdate(query);
            
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }

    public static boolean update(String table, String set, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "update "+ table +" set " + set + " where id=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }

    public static boolean delete(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "delete from "+ table + " where id=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    } 

    public static boolean delete1(String table, String where){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "delete from "+ table + " where " + where;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    } 
    
    public static String[][] read(String table){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select count(*) from " + table);
            int totalRows = rs.getInt(1);

            rs = stmt.executeQuery("select * from " + table);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            records = new String[totalRows][totalColumns];

            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    
    public static String[][] read(String table, int id){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select count(*) from " + table + " where id="+ id);
            int totalRows = rs.getInt(1);

            rs = stmt.executeQuery("select * from " + table + " where id =" + id);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            records = new String[totalRows][totalColumns];

            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    
    public static String[][] read1(String table, String where){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select count(*) from " + table + " where "+ where);
            int totalRows = rs.getInt(1);

            rs = stmt.executeQuery("select * from " + table + " where " + where);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            records = new String[totalRows][totalColumns];

            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    
    public static void main(String[] args){
        if(SQLite.openDB()){
            SQLite.closeDB();
        }
    }
}