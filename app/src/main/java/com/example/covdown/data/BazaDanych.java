package com.example.covdown.data;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BazaDanych {
    private static BazaDanych self = new BazaDanych();
    public static BazaDanych get() {return self;}
    AktywnyUzytkownik user = AktywnyUzytkownik.get();
    Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    private void connect() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            final String connectionString = "jdbc:jtds:sqlserver://przekoty.database.windows.net:1433;databaseName=PozytywneWibracje;user=qutlet@przekoty;password=Rusyfikacja99;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
            final String driver = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionString);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean addUser(String nazwa, String haslo, String data) {
        boolean powodzenie = checkUserRejestracji(nazwa);
        if (!powodzenie){
            connect();
            String query = "insert into Uzytkownicy (nazwa_uzytkownika,haslo,data,punkty,itemki,powtorzenia,ostatniaData,ciag) VALUES (?,?,?,?,?,?,?,?);";
            try (PreparedStatement stsm = connection.prepareStatement(query) ){
                stsm.setString(1,nazwa);
                stsm.setString(2,haslo);
                stsm.setString(3,data);
                stsm.setInt(4,0);
                stsm.setString(5,"");
                stsm.setString(6,"");
                stsm.setDate(7,new Date(new java.util.Date().getTime()));
                stsm.setInt(8,0);
                stsm.execute();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            disconnect();
            return true;
        }
        return false;
    }

    public boolean checkUser(String nazwa, String haslo){ //logowanie
        connect();
        String query = "select nazwa_uzytkownika,haslo from Uzytkownicy ";
        try (PreparedStatement stsm = connection.prepareStatement(query)){
            ResultSet resultSet = stsm.executeQuery();
            while (resultSet.next()){
                String checkedUsername = resultSet.getString(1);
                String pass = resultSet.getString(2);
                if (pass.equals(haslo) && checkedUsername.equals(nazwa)){
                    disconnect();
                    return true;
                }
            }
            return false;
        } catch (SQLException e){
            e.printStackTrace();
        }
        disconnect();
        return false;
    }

    public boolean checkUserRejestracji(String nazwa){
        connect();
        String query = "select nazwa_uzytkownika from Uzytkownicy";
        try (PreparedStatement stsm = connection.prepareStatement(query)){
            ResultSet resultSet = stsm.executeQuery();
            while (resultSet.next()){
                String checkedUsername = resultSet.getString(1);
                if (checkedUsername.equals(nazwa)){
                    disconnect();
                    return true;
                }
            }
            return false;
        } catch (SQLException e){
            e.printStackTrace();
        }
        disconnect();
        return true;
    }

    public void setPoints(double value){
        connect();
        int points =0;
        String query = "select punkty from Uzytkownicy where nazwa_uzytkownika = '"+user.getNazwa()+"'";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                points = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Blad pobrania punktow dla uzytkownika");
        }
        value += points;
        query = "update Uzytkownicy set punkty="+ value +" where nazwa_uzytkownika = '"+user.getNazwa()+"'";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    public boolean checkPoints(double value){
        connect();
        int points =0;
        String query = "select punkty from Uzytkownicy where nazwa_uzytkownika = '"+user.getNazwa()+"'";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                points = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Blad pobrania punktow dla uzytkownika");
        }
        disconnect();
        if (value <= points){
            return true;
        }
        return false;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.err.println("Blad rozlaczenia z baza danych");
            }
        }
    }

    public void downloadOwnedItems(){
        connect();
        Itemki ownedItemArrayList = new Itemki();
        String idle = null;
        StringBuilder help = new StringBuilder();
        String query = "select itemki from Uzytkownicy where nazwa_uzytkownika = '"+user.getNazwa()+"'";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                idle = resultSet.getString(1); //C01;C02;
            }
            assert idle != null;
            for (int i = 0; i < idle.length(); i++) {
                if (idle.charAt(i) != ';') {
                    help.append(idle.charAt(i));
                } else {
                    System.out.println(idle);
                    ownedItemArrayList.add(new Itemek(help.toString(),true));
                    help.setLength(0);
                }
            }
        } catch (SQLException e) {
            System.err.println("Blad pobrania punktow dla uzytkownika");
            disconnect();
        }
        disconnect();
        user.setOdblokowane(ownedItemArrayList);
    }

    public void addItemek(String kod){
        connect();
        String items = null;
        String query = "select itemki from Uzytkownicy where nazwa_uzytkownika = '"+user.getNazwa()+"'";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                items = resultSet.getString(1);
            }
        } catch (SQLException e) {
            System.err.println("Blad pobrania punktow dla uzytkownika");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(items);
        stringBuilder.append(kod);
        stringBuilder.append(";");
        query = "update Uzytkownicy set itemki='"+ stringBuilder.toString() +"' where nazwa_uzytkownika = '"+user.getNazwa()+"'";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Blad ustawienia punktow dla uzytkownika");
        }
        disconnect();
    }
}