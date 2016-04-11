package Model;

public class Entry {
    private int id;
    private int userid;
    private String address;
    private String city;
    private String country;
    private int price;
    private String title;
    
    public Entry(int id, int userid, String address, String city, String country, int price, String title){
        this.id = id;
        this.userid = userid;
        this.address = address;
        this.city = city;
        this.country = country;
        this.price = price;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
    public int getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    
}
