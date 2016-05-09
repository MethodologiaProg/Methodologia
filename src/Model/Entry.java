package Model;
import Controler.FindUser;
import Controler.Interest;

public class Entry {
    private int id;
    private int userid;
    private String address;
    private String city;
    private String country;
    private int price;
    private String title;
    private String description;
    private String photo;
    
    public Entry(int id, int userid, String address, String city, String country, int price, String title, String description, String photo){
        this.id = id;
        this.userid = userid;
        this.address = address;
        this.city = city;
        this.country = country;
        this.price = price;
        this.title = title;
        this.description = description;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }
    
    public String getUser(){
        FindUser fu = new FindUser(userid);
        return fu.GetUserName();
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
    public String getDescription() {
        return description;
    }
    public String getPhoto() {
        return photo;
    }
    public int getNumberOfPeopleInterested(int entryId){
        return Interest.getNumberOfPeopleInterested(entryId);
    }
    
}
