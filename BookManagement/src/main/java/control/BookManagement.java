package control;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BookManagement {

    Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    // Hàm tạo book
    public void createBook() {
        String book_code;
        book_code = Inputter.Inputter.GetString("Enter the book's code : ");
        if (!isDuplicated(book_code)) {
            String book_name = Inputter.Inputter.GetString("Enter the book's name : ");
            String book_title = Inputter.Inputter.GetString("Enter the book's title : ");
            String decription = Inputter.Inputter.GetString("Enter the decription : ");
            String Type = Inputter.Inputter.GetString("Enter the book's type : ");
            double price = Inputter.Inputter.GetDouble("Enter the book's price : ");

            try {
                Statement st = conn.createStatement();
                String sql = "INSERT INTO dbo.Book(book_code, book_name, book_title, decription, type, price, created_at, update_at)\n"
                        + "VALUES ( '" + book_code + "', '" + book_name + "', '" + book_title + "', '" + decription + "', '" + Type + "', " + price + ", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );";
                st.executeUpdate(sql);
                System.out.println("Successfully Created.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Hàm update book info bằng book_code
    public void updateBook(String code) {
        if (!isDuplicated(code)) {
            System.out.println("Not Found !");
            return;
        }

        try {
            Statement st = conn.createStatement();
            String book_name = Inputter.Inputter.GetString("Enter the book's name : ");
            String book_title = Inputter.Inputter.GetString("Enter the book's title : ");
            String decription = Inputter.Inputter.GetString("Enter the decription : ");
            String type = Inputter.Inputter.GetString("Enter the book's type : ");
            double price = Inputter.Inputter.GetDouble("Enter the book's price : ");
            String sql = "UPDATE dbo.Book\n"
                    + "SET book_name = '" + book_name + "',\n"
                    + "    book_title = '" + book_title + "',\n"
                    + "    decription = '" + decription + "',\n"
                    + "    type = '" + type + "',\n"
                    + "    price = " + price + ",\n"
                    + "    update_at = CURRENT_TIMESTAMP \n"
                    + "WHERE book_code = '" + code + "';";
            st.executeUpdate(sql);
            System.out.println("Successfully Update.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public String findBookWithName(String name){
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT book_code FROM Book WHERE book_name = '" + name + "';");
            if (rs.next()) {
                return rs.getString("book_code");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public String findBookWithTitle(String title){
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT book_code FROM Book WHERE book_title = '" + title + "';");
            if (rs.next()) {
                return rs.getString("book_code");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void view(){
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Book;");
            while(rs.next()){
                String s = rs.getInt("id") + " " + rs.getString("book_code") + " " + rs.getString("book_name")
                        + " " + rs.getString("book_title") + " " + rs.getString("decription") + " " + rs.getString("type") 
                        + " " + rs.getDouble("price") + " " + rs.getString("created_at") + " " + rs.getString("update_at");
                System.out.println(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void viewWithPage(int pageIndex, int pageNum){
        try {
            
            
            CallableStatement cs = conn.prepareCall("{CALL Paging(?, ?)}");
            
            cs.setInt(1, pageIndex);
            cs.setInt(2, pageNum);
            
            ResultSet rs = cs.executeQuery();
            
            while( rs.next()){
                String s = rs.getInt("id") + " " + rs.getString("book_code") + " " + rs.getString("book_name")
                        + " " + rs.getString("book_title") + " " + rs.getString("decription") + " " + rs.getString("type") 
                        + " " + rs.getDouble("price") + " " + rs.getString("created_at") + " " + rs.getString("update_at");
                System.out.println(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isDuplicated(String code) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Book WHERE book_code = '" + code + "';");
            if (rs.next() == false) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
    public void writeFileExcel(String file){
        try {
            FileOutputStream newFile = new FileOutputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet worksheet = workbook.createSheet("BookManagement");
            XSSFRow row = worksheet.createRow(0);
            Cell cell = null;
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("id");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("book_code");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("book_name");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("book_title");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("decription");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("type");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("price");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("created_at");
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("update_at");
            
            List<Book> list = getBookFromDataBase();
            for(int i = 0; i<list.size(); i++){
                Book book = list.get(i);
                
                row = worksheet.createRow(i+1);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(book.getId());
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(book.getBook_code());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(book.getBook_name());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(book.getBook_title());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(book.getDecription());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(book.getType());
                cell = row.createCell(6, CellType.NUMERIC);
                cell.setCellValue(book.getPrice());
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(book.getCreated_at().toString());
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(book.getUpdate_at().toString());
                
            }
            
            workbook.write(newFile);
            workbook.close();
            newFile.close();
            System.out.println("Successfully Write.");
            
         } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public List<Book> getBookFromDataBase(){
        List<Book> listBook = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM Book;";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String str = rs.getString("created_at");
                String[] s = str.split(" ");
                LocalDate date = LocalDate.parse(s[0]);
                LocalTime time = LocalTime.parse(s[1]);
                LocalDateTime dt = LocalDateTime.of(date, time);
                
                String str1 = rs.getString("update_at");
                String[] s1 = str1.split(" ");
                LocalDate date1 = LocalDate.parse(s1[0]);
                LocalTime time1 = LocalTime.parse(s1[1]);
                LocalDateTime dt1 = LocalDateTime.of(date1, time1);
                
                Book book = new Book(rs.getInt("id"),
                        rs.getString("book_code"),
                        rs.getString("book_name"),
                        rs.getString("book_title"),
                        rs.getString("decription"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        dt,
                        dt1);
                
                listBook.add(book);
            }
            System.out.println("Successfully Get.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listBook;
    }
    
    

    public static void main(String[] args) {
        BookManagement bm = new BookManagement();

        bm.conn = connectToSQLServer.Connect.getConnection();
    }
}
