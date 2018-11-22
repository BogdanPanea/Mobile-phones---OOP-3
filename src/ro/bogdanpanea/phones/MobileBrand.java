package ro.bogdanpanea.phones;

public abstract class MobileBrand extends MobilePhone {

    private String brandName;

    public MobileBrand(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

}
