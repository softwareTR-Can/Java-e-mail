import java.util.Scanner;

public class NewWorker {

    Worker worker = new Worker();
    Scanner scanner = new Scanner(System.in);
    CheckIt checkIt = new CheckIt();

    public void addWorker() {

        String firstName = firstName();
        worker.setFirstName(firstName.toLowerCase());
        String lastName = lastName();
        worker.setLastName(lastName.toLowerCase());

        String department = departmentSelection();
        System.out.println("Departman: " + department);
        worker.setDepartment(department);

        String password = passwordGenerator(8);
        System.out.println("Şifre: " + password);
        worker.setPassword(password);

        String companySuffix = "cancoding.com";
        String email = (firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix);
        System.out.println("Email: " + email);
        String sql_sorgu = "INSERT INTO worker (name,surname,password,department,email) " +
                "VALUES ('" + worker.getFirstName() + "','" + worker.getLastName() + "','" + worker.getPassword() + "','" + worker.getDepartment() + "','" + email.toLowerCase() + "')";

        DatabaseBaglanti databaseBaglanti = new DatabaseBaglanti();
        if (databaseBaglanti.addToDatabase(sql_sorgu)) {

            System.out.println("İşlem başarıyla gerçekleşmiştir. Hoşgeldiniz...");
        } else {

            System.out.println("İşlem sırasında beklenmedik bir hata oluşmuştur. Tekrar yönlendiriliyorsunuz...");
            addWorker();
        }

    }

    private String firstName() {

        System.out.print("Lütfen isminizi giriniz: ");
        String firstName = scanner.nextLine();
        if(checkIt.nameCheckIt(firstName)){
            return firstName;
        }
        else{
            firstName();
        }
        return null;
    }

    private String lastName() {

        System.out.print("Lütfen soyadınızı giriniz: ");
        String lastname = scanner.nextLine();
        if(checkIt.nameCheckIt(lastname)){
            return lastname;
        }
        else{
            lastName();
        }
        return null;
    }

    public String departmentSelection() {

        System.out.println("Departman Kodu:\n1.AR-GE\n2.İnsan Kaynakları\n3.Satış ve Pazarlama\n4.Finans");
        int kod = scanner.nextInt();
        String department = null;
        switch (kod) {
            case 1: {
                return "arge";
            }
            case 2: {
                return "insankaynaklari";
            }
            case 3: {
                return "satis";
            }
            case 4: {
                return "finans";
            }
            default: {
                System.out.println("Hatalı kod!.. Lütfen tekrar deneyiniz.");
                departmentSelection();
            }

        }
        return department;
    }

    public String passwordGenerator(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char password[] = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = (passwordSet.charAt(rand));
        }

        return new String(password);
    }

}
