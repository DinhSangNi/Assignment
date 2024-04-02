package model;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Book {
    
    private int id;
    private String book_code;
    private String book_name;
    private String book_title;
    private String decription;
    private String type;
    private double price;
    private LocalDateTime created_at;
    private LocalDateTime update_at;

    public Book() {
    }

    public Book(int id, String book_code, String book_name, String book_title, String decription, String type, double price, LocalDateTime created_at, LocalDateTime update_at) {
        this.id = id;
        this.book_code = book_code;
        this.book_name = book_name;
        this.book_title = book_title;
        this.decription = decription;
        this.type = type;
        this.price = price;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", book_code=" + book_code + ", book_name=" + book_name + ", book_title=" + book_title + ", decription=" + decription + ", type=" + type + ", price=" + price + ", created_at=" + created_at + ", update_at=" + update_at + '}';
    }
    
    public static void main(String[] args) {
        
    }
    
}
