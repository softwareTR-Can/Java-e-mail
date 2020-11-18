import java.util.Scanner;

public class Account {
    Worker worker = new Worker();
    DatabaseBaglanti databaseBaglanti = new DatabaseBaglanti();
    Scanner scanner = new Scanner(System.in);
    static String password;
    CheckIt checkIt = new CheckIt();

    public boolean accountLogin() {

        int deneme = 0;

        do {

            if (deneme >= 1) {
                System.out.println("Girdiğiniz bilgiler ile herhangi bir hesabı eşleştiremedik, kontrol edip tekrar deneyin.");
            }

            System.out.print("E-postanızı giriniz: ");
            String email = scanner.nextLine();

            System.out.print("Şifrenizi giriniz: ");
            password = scanner.nextLine();

            if(databaseBaglanti.login(email,password)){
                return true;
            }

            deneme++;
        } while (deneme < 3);

        return false;
    }

    public void accountPasswordUpdate() {

        String password;
        String newPassword;
        String newPasswordAgain;

        do {
            System.out.print("Eski şifrenizi giriniz: ");
            password = scanner.nextLine();

            System.out.print("Yeni şifrenizi giriniz: ");
            newPassword = scanner.nextLine();

            System.out.print("Yeni şifrenizi tekrar giriniz: ");
            newPasswordAgain = scanner.nextLine();

        }while(!databaseBaglanti.passwordTrueOrFalse(password) || !newPassword.equals(newPasswordAgain) || !checkIt.passwordCheckIt(newPassword));

        worker.setPassword(newPassword);
        databaseBaglanti.updatePassword(newPassword);///////
    }

}

