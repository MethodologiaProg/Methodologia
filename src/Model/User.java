package Model;

import Controler.FindUser;


public class User {
    private int id;
    private String name;
    private String last_name;
    private int age;
    private String email;
    private String photo;


    
    public User(int id, String name, String last_name, String email, String photo){
        this.id = id;
        this.name = name;
        this.last_name = last_name;
//        this.age = age;
        this.email = email;
        this.photo = photo;
    }
    

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLast_name() {
        return last_name;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String email) {
        this.photo = photo;
    }
    
    
    
    
    
}
