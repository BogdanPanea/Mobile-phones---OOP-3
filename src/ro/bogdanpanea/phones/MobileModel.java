package ro.bogdanpanea.phones;

import java.util.*;

public class MobileModel extends MobileBrand {

    private String modelName;
    private String color;
    private String material;
    private int batteryLife;
    private final int imei;

    Map<String, Integer> batterisLifes = new HashMap<String, Integer>();

    private Contact contact;
    private Call call;
    private Message message;

    List<Contact> Contacts = new ArrayList<Contact>();
    List<Message> Messages = new ArrayList<Message>();
    List<Call> Calls = new ArrayList<Call>();

    public MobileModel(String brandName, String modelName, String color, String material, int imei) {
        super(brandName);

        batterisLifes.put("Note 1", 76);
        batterisLifes.put("Note 2", 89);
        batterisLifes.put("Xperia 1", 68);
        batterisLifes.put("Xperia 2", 98);

        this.modelName = modelName;
        this.color = color;
        this.material = material;
        this.batteryLife = batterisLifes.get(modelName);
        this.imei = imei;
    }

    public void newContact(int pozitieAgenda, String name, String phoneNumber) {

        contact = new Contact(name, phoneNumber);
        Contacts.add(pozitieAgenda, contact);
    }

    @Override
    public void listContacts() {

        for (Contact contacte : Contacts) {

            System.out.println(contacte);

        }

    }

    @Override
    public void sendSMS(String bodyMessage, String recipient) {

        if (bodyMessage.length() > 100) {
            System.out.println("Message too long. Only 100 characters are accepted.");
        } else {
            message = new Message(bodyMessage, recipient);
            Messages.add(message);
            batteryLife = batteryLife - 1;
        }
    }

    @Override
    public void viewSMS() {

        for (Message mesaj : Messages) {

            System.out.println(mesaj);
        }

    }

    public void viewSMS(String number) {

        for (Message mesaj : Messages) {

            if (mesaj.getRecipient() == number) {
                System.out.println(mesaj);
            }

        }
    }

    @Override
    public void call(String number) {

        call = new Call(number);
        Calls.add(call);
        batteryLife = batteryLife - 2;

    }

    @Override
    public void viewCalls() {

        for (Call apel : Calls) {

            System.out.println(apel);

        }

    }

    public List<Contact> getContacts() {
        return Contacts;
    }
}
