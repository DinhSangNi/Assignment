package ExcelServices;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.LogManager;
import model.ExcelModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Import {

    private static Workbook getWorkbook(String path, FileInputStream file) {
        Workbook workbook = null;
        try {
            if (path.endsWith("xlsx")) {
                workbook = new XSSFWorkbook(file);
            } else if (path.endsWith("xls")) {
                workbook = new HSSFWorkbook(file);
            } else {
                throw new IllegalArgumentException("The specified file is not Excel file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static List<ExcelModel> readFile(String path) throws IOException {
        System.out.println("File Reading : " + path);
        FileInputStream file = new FileInputStream(path);

        Workbook workbook = getWorkbook(path, file);
        Sheet sheet = workbook.getSheetAt(0);

        List<ExcelModel> list = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) {
                continue;
            }
            ExcelModel model = new ExcelModel();
            model.setId(String.valueOf((int) row.getCell(0).getNumericCellValue()));
            model.setName(row.getCell(1).getStringCellValue());
            model.setAddress(row.getCell(2).getStringCellValue());
            model.setProduct_id(String.valueOf(row.getCell(3).getNumericCellValue()));
            model.setTotal(row.getCell(4).getNumericCellValue());
            list.add(model);
        }

        System.out.println("File finished reading.");
        workbook.close();
        file.close();
        return list;
    }

    public static void importToDB(Connection conn, List<ExcelModel> list) {
        try {
            Iterator<ExcelModel> modelIterator = list.iterator();
            while (modelIterator.hasNext()) {
                ExcelModel model = modelIterator.next();
                Statement st = conn.createStatement();
                String sqlUser = "INSERT INTO tb_user \n"
                        + "VALUES ('" + model.getId() + "', '" +
                        model.getName() + "', '" +
                        model.getAddress() +
                        "')";
                st.executeUpdate(sqlUser);
                
                String sqlProduct = "INSERT INTO tb_products \n"
                        + "(id, product_id) \n"
                        + "VALUES ('" + model.getId() + "', '"
                        + model.getProduct_id() +
                        "')";
                st.executeUpdate(sqlProduct);
                
                String sqlHistory = "INSERT INTO tb_history \n"
                        + "(user_id, product_id, total) \n"
                        + "VALUES ('" + model.getId() +
                        "', '" + model.getProduct_id() +
                        "', " + model.getTotal() +
                        ")";
                st.executeUpdate(sqlHistory);
                
                System.out.println("Successfull. ");
                
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        Connection conn = connectToSQLServer.Connect.getConnection();
        List list = readFile("EX.xlsx");
        importToDB(conn, list);
    }   
}
