import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Menu menugiris = new Menu();
        menugiris.menu();
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Kullacı Girişi\n2.Yeni Kullanıcı");
        int secim = scanner.nextInt();
        switch (secim){
            case 1:{
                Account account = new Account();
                if(account.accountLogin()){
                    System.out.println("Hoşgeldiniz...");
                    System.out.println("1.Şifre Güncelleme");
                    secim = scanner.nextInt();
                    switch (secim){
                        case 1:{
                            account.accountPasswordUpdate();
                        }
                    }
                }
            }
            case 2:{
                NewWorker worker = new NewWorker();
                worker.addWorker();

            } default:{

            }
        }
*/


/*
        DatabaseBaglanti databaseBaglanti = new DatabaseBaglanti();
        if(databaseBaglanti.login()){
            System.out.println("Hoşgeldiniz...");

        }else{
            System.exit(0);
        }
*/



        /*
        Connection connection = null;
        Statement statement = null;     //cümle,cümlecik // veritabanına gönderdiğimiz sql kodu
        ResultSet resultSet = null;     // sonuç // döndürülen sonuç

        try {
            //connection= DriverManager.getConnection(dbUrl,username,password);
            DatabaseBaglanti databaseBaglanti = new DatabaseBaglanti();
            if(databaseBaglanti.baglanti()){
                System.out.println("Hoşgeldiniz...");

            }else{
                System.exit(0);
            }
            /*
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from müsteri");
            String isim= "umutcan bağdu";
            while (resultSet.next()){
                boolean giris = (resultSet.getString("müsteri_ad").equals(isim) && resultSet.getString("sifre").equals("1812"));
                if(giris) {
                    System.out.println(giris);
                    break;
                }

            }

        }

        catch (Exception exception){
            exception.printStackTrace(); // hatanın türünü algılayıp bize yazsın.

        }finally {

        }
*/

    }
}
