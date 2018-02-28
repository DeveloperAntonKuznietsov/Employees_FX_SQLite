package sample.controllers;

import sample.Employee.Person;

import java.sql.*;

public class DBConnector {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Connect() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:employee.db");

        System.out.println("База Подключена!");
    }
    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'employee' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'position' text, 'fio' text, 'sex' text,'resume' text, 'dob' text, 'uploadData' text);");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void WriteDB(String position,String fio, String sex, String resume, String dob, String uploadData) throws SQLException
    {
        statmt.execute("INSERT INTO 'employee' ('position', 'fio', 'sex', 'resume', 'dob', 'uploadData') " +
                "VALUES ('"+position+"', '"+fio+"', '"+sex+"', '"+resume+"', '"+dob+"', '"+uploadData+"'); ");

        System.out.println("Таблица заполнена");
    }
    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM employee");

        while(resSet.next())
        {
            String position = resSet.getString("position");
            String  fio = resSet.getString("fio");
            String  sex = resSet.getString("sex");
            String  resume = resSet.getString("resume");
            String  dob = resSet.getString("dob");
            String  uploadData = resSet.getString("uploadData");
            System.out.println( "position = " + position );
            System.out.println( "fio = " + fio );
            System.out.println( "sex = " + sex );
            System.out.println( "resume = " + resume );
            System.out.println( "dob = " + dob );
            System.out.println( "uploadData = " + uploadData );
            System.out.println();
            ControllerMainMenu.collectionEmployee.add(new Person(position,fio,sex,resume,dob,uploadData));
        }

        System.out.println("Таблица выведена");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {

        try {
            if (conn!=null) conn.close();
            if (statmt!=null) statmt.close();
            if (resSet!=null) resSet.close();
        } catch (Exception e) {}

        System.out.println("Соединения закрыты");
    }

}
