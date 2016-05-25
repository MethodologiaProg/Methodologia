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
    
    /**
     *Creates an object entry with all the parameters
     * @param id The id of the entry
     * @param userid The id of the entry's user
     * @param address The address of the entry
     * @param city The city of the entry
     * @param country The country of the entry
     * @param price The price of the entry
     * @param title The title of the entry
     * @param description The description of the entry
     * @param photo The photo of the entry as a String path
     */
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

    /**
     *Get the id
     * @return the id of the entry
     */
    public int getId() {
        return id;
    }

    /**
     *Get the user id
     * @return the user id
     */
    public int getUserid() {
        return userid;
    }
    
    /**
     *Returns the user's name and last name as a String
     * @return The user's full name
     */
    public String getUser(){
        FindUser fu = new FindUser(userid);
        return fu.GetUserName();
    }

    /**
     *Get the address of the entry
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     *Get the city of the entry
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     *Get the country of the entry
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     *Get the price of the entry
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     *Get the title of the entry
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     *Get the description of the entry
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     *Get the path of the photo as a String
     * @return the photo's path
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *Get the number of people interested in as specific entry
     * @param entryId the entry's id
     * @return the number of people interested as an integer
     */
    public int getNumberOfPeopleInterested(int entryId){
        return Interest.getNumberOfPeopleInterested(entryId);
    }
    
}
