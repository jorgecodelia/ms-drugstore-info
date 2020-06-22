package cl.code.ms.drugstore.info.common.model;

public class DrugstoreInfoModel {

    private String name;
    private String address;
    private String phone;
    private String latitude;
    private String longitude;

    public DrugstoreInfoModel() {
    }

    public DrugstoreInfoModel(String name, String address, String phone, String latitude, String longitude) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
