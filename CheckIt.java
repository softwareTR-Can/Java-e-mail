public class CheckIt {

    public boolean nameCheckIt(String name) {

        String istenmeyenler[]={"%","/","?","1","q","w","2","3","4","5","6","7","8","9"};

        boolean bulundu=false;

        for(int i = 0 ; i< name.length();i++)
        {
            for(int j = 0; j< istenmeyenler.length ; j++)
            {
                if(istenmeyenler[j].charAt(0)==name.charAt(i))
                {
                    bulundu = true;
                }
            }
        }
        if(bulundu)
        {
            System.out.println("istenmeyen harf bulundu.");
            return false;

        }else return true;

    }

    public Boolean passwordCheckIt(String kSifre) {
        String buyukHarf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String kucukHarf = "abcdefghijklmnopqrstuvwxyz";
        String rakam = "0123456789";
        String sembol = "!'^+%&/()=?-_£#$½{[]}|*é";

        boolean buyukHarfVar = false;
        boolean kucukHarfVar = false;
        boolean rakamVar = false;
        boolean sembolVar = false;

        for (int i=0; i < kSifre.length(); i++)
            if (buyukHarf.indexOf(kSifre.charAt(i)) == -1) {
                buyukHarfVar = true;
                break;
            }

        for (int i=0; i < kSifre.length(); i++)
            if (kucukHarf.indexOf(kSifre.charAt(i)) == -1) {
                kucukHarfVar = true;
                break;
            }

        for (int i=0; i < kSifre.length(); i++)
            if (rakam.indexOf(kSifre.charAt(i)) == -1) {
                rakamVar = true;
                break;
            }

        for (int i=0; i < kSifre.length(); i++)
            if (sembol.indexOf(kSifre.charAt(i)) == -1) {
                sembolVar = true;
                break;
            }


        if(buyukHarfVar == false){
            System.out.println("Lütfen büyük harf kullanın.");
        }

        if(kucukHarfVar == false){
            System.out.println("Lütfen küçük harf kullanın.");
        }

        if(rakamVar == false){
            System.out.println("Lütfen rakam kullanın.");
        }

        if(sembolVar == false){
            System.out.println("Lütfen sembol kullanın.");
        }

        if(buyukHarfVar && kucukHarfVar && rakamVar && sembolVar){
            return true;
        }

        return false;
    }
}
