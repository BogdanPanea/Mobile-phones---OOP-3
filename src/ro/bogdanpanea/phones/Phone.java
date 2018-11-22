package ro.bogdanpanea.phones;

public interface Phone {

    public void newContact(int pozitieAgenda, String name, String phoneNumber);

    public void listContacts();

    public void sendSMS(String bodyMessage, String recipient);

    public void viewSMS();

    public void viewSMS(String number);

    public void call(String number);

    public void viewCalls();

}
