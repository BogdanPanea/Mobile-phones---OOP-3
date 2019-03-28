package ro.bogdanpanea.phones;

import java.util.*;

public class MobileModel extends MobileBrand {

    private static int lungimeSMS = 100;

    private String modelName;
    private String color;
    private String material;
    private int batteryLife;
    private final int imei;

    private Contact contact;
    private Call call;
    private Message message;

    private List<Contact> contacts = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private List<Call> calls = new ArrayList<>();

    MobileModel(String brandName, String modelName, String color, String material, int imei) {
        super(brandName);

        Map<String, Integer> batterisLife = new HashMap<>();
        batterisLife.put("Note 1", 76);
        batterisLife.put("Note 2", 75);
        batterisLife.put("Xperia 1", 68);
        batterisLife.put("Xperia 2", 98);

        this.modelName = modelName;
        this.color = color;
        this.material = material;
        this.batteryLife = batterisLife.get(modelName);
        this.imei = imei;
    }

    public void newContact(int pozitieAgenda, String name, String phoneNumber) throws ValidationException {

        validateContact(phoneNumber);
        contact = new Contact(name, phoneNumber);
        contacts.add(pozitieAgenda, contact);
    }

    public void validateContact(String phoneNumber) throws ValidationException {


        if (phoneNumber == null) {
            throw new ValidationException("Please try again! Enter a phone number.");
        } else if (phoneNumber.startsWith("0")) {
            if (phoneNumber.length() > 10) {
                throw new ValidationException("Please try again! The phone number " + phoneNumber + " exceeds 10 characters.");
            } else if (phoneNumber.matches("^(.*)(\\D)(.*)")) {
                throw new ValidationException("Please try again! The phone number " + phoneNumber + " contains letters!");
            }

        } else if (phoneNumber.startsWith("7")) {
            if (phoneNumber.length() > 9) {
                throw new ValidationException("Please try again! The phone number " + phoneNumber + " exceeds 9 characters.");
            } else if (phoneNumber.matches("^(.*)(\\D)(.*)")) {
                throw new ValidationException("Please try again! The phone number " + phoneNumber + " contains letters!");
            }
        } else {
            throw new ValidationException("Please try again! You've entered an invalid phone number.");
        }
    }

    @Override
    public void listContacts() {

        for (Contact contacte : contacts) {

            System.out.println(contacte);

        }

    }

    @Override
    public void sendSMS(String bodyMessage, String recipient) {

        if (batteryLife > 0) {
            if (bodyMessage.length() > lungimeSMS) {
                System.out.println("Message too long. Only 100 characters are accepted.");
            } else {
                message = new Message(bodyMessage, recipient);
                messages.add(message);
                batteryLife = batteryLife - 1;
            }
        } else {

            System.out.println("The battery is discharged. Please connect the charger. Message not sent !");
            System.out.println("----------------------------------");
        }

    }

    @Override
    public void viewSMS() {

        for (Message mesaj : messages) {

            System.out.println(mesaj);
        }

    }

    public void viewSMS(String number) {

        for (Message mesaj : messages) {

            if (mesaj.getRecipient().equals(number)) {
                System.out.println(mesaj);
            }

        }
    }

    @Override
    public void call(String number) {

        if (batteryLife > 1) {

            call = new Call(number);
            calls.add(call);
            batteryLife = batteryLife - 2;

        } else {

            System.out.println("Unable to call. The battery is discharged. Please connect the charger.");
            System.out.println("----------------------------------");
        }
    }

    @Override
    public void viewCalls() {

        for (Call apel : calls) {

            System.out.println(apel);

        }

    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
