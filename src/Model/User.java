package Model;


public class User {
    private int id;
    private String name;
    private String last_name;
    private int age;
    private String email;
    private String photo;

    /**
     *Creates a user object with all the parameters
     * @param id the user id
     * @param name the user's name
     * @param last_name the user's last name
     * @param email the user's email
     * @param photo the path of the photo
     */
    public User(int id, String name, String last_name, String email, String photo){
        this.id = id;
        this.name = name;
        this.last_name = last_name;
//        this.age = age;
        this.email = email;
        this.photo = photo;
    }
    
    /**
     *Get the id
     * @return user id
     */
    public int getId() {
        return id;
    }

    /**
     *Set the id
     * @param id the user id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *Get the first name
     * @return first name
     */
    public String getName() {
        return name;
    }

    /**
     *Set the first name
     * @param name first name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Get the last name
     * @return the last name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     *Set the last name
     * @param last_name last name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     *NOT USED
     * @return NOT USED
     */
    public int getAge() {
        return age;
    }

    /**
     *NOT USED
     * @param age NOT USED
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *Get the email of the user
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     *Set the email of the user
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *Get the path of the photo
     * @return a string of the photo's path
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *NOT USED
     * @param email NOT USED
     */
    public void setPhoto(String email) {
        this.photo = photo;
    }
    
    
    
    
    
}
