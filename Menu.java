import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menu() {


        System.out.println("1.Kullacı Girişi\n2.Yeni Kullanıcı");
        int secim = scanner.nextInt();

        switch (secim) {

            case 1: {
                account();
            }
            case 2: {
                newAccount();
            }
            default: {
                System.out.println("Eksik ya da hatalı giriş!!!");

            }
        }
    }

    public static void account(){
        Scanner scanner1 = new Scanner(System.in);
        Account account = new Account();
        if (account.accountLogin()) {
            System.out.println("Hoşgeldiniz...");
            System.out.println("1.Şifre Güncelleme");
            int secim = scanner1.nextInt();
            switch (secim) {
                case 1: {
                    account.accountPasswordUpdate();
                }
                default:{
                    System.out.println("Eksik ya da hatalı giriş!");
                    Menu.account();
                }
            }
        }

    }

    public void newAccount(){
        NewWorker worker = new NewWorker();
        worker.addWorker();
        menu();
    }
}
