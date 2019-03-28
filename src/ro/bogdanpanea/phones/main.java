package ro.bogdanpanea.phones;


public class main {

    public static void main(String args[]) {


        //Phone phone= new MobileBrand("Samsung");
        Phone Phone1 = new MobileModel("Samsung", "Note 2", "black", "plastic", 123456);
        try {
            Phone1.newContact(0, "Adi", "0743765768");
            Phone1.newContact(1, "Bogdan", "0737473658");
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        Phone1.listContacts();
        System.out.println("----------------------------------");
        Phone1.sendSMS("Te salut.Ce mai faci ?", "0743765768");
        Phone1.sendSMS("Buna dimineata. Ai terminat tema pentru azi ?", "0737473658");
        Phone1.viewSMS();
        System.out.println("----------------------------------");
        Phone1.viewSMS("0743765768");
        System.out.println("----------------------------------");
        Phone1.call("0737473658");
        Phone1.viewCalls();

    }
}
