package ro.bogdanpanea.phones;

public interface Phone {

    void newContact(int pozitieAgenda, String name, String phoneNumber) throws ValidationException;

    void listContacts();

    void sendSMS(String bodyMessage, String recipient);

    void viewSMS();

    void viewSMS(String number);

    void call(String number);

    void viewCalls();

}
