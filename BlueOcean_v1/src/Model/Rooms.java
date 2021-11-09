package Model;

public class Rooms {
    private String roomNo;
    private String BedType;
    private String facilities;
    private String availability;
    private String price;

    public Rooms(String roomNo, String bedType, String facilities, String price, String availability) {
        this.roomNo = roomNo;
        this.BedType = bedType;
        this.facilities = facilities;
        this.availability = availability;
        this.price = price;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getBedType() {
        return BedType;
    }

    public void setBedType(String bedType) {
        this.BedType = bedType;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String roomNo) {
        this.price = price;
    }
}
