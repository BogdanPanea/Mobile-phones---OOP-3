package ro.bogdanpanea.phones;

public class Call {

    private String calledNumber;

    Call(String calledNumber) {

        this.calledNumber = calledNumber;
    }

    public String getCalledNumber() {
        return calledNumber;
    }

    @Override
    public String toString() {
        return "Call{" +
                "calledNumber='" + calledNumber + '\'' +
                '}';
    }
}
