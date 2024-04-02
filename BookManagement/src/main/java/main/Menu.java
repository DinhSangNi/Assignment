package main;

import control.BookManagement;

public class Menu {

    public void menu() {
        BookManagement bm = new BookManagement();
        bm.setConn(connectToSQLServer.Connect.getConnection());

        int choice = 0;
        do {
            System.out.println("1. Create book.");
            System.out.println("2. Update info book.");
            System.out.println("3. Find");
            System.out.println("4. View all book.");
            System.out.println("5. Export data to excel file(xlsx).");
            System.out.println(" Press other to Exit.");

            System.out.println("");
            choice = Inputter.Inputter.GetInt("Enter your selection : ");

            switch (choice) {
                case 1:
                    bm.createBook();
                    break;
                case 2:
                    String code = Inputter.Inputter.GetString("Enter the book's code : ");
                    bm.updateBook(code);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Find the book : ");
                    int select = 0;
                    do {
                        System.out.println("1-Find with name.");
                        System.out.println("2-Find with title.");
                        System.out.println("Press other to Exit.");
                        System.out.println("");
                        select = Inputter.Inputter.GetInt("Enter your selection : ");

                        switch (select) {
                            case 1:
                                String name = Inputter.Inputter.GetString("Enter the book's name : ");
                                String result1 = bm.findBookWithName(name);
                                System.out.println("Book's code : " + result1);
                                System.out.println("");
                                break;
                            case 2:
                                String title = Inputter.Inputter.GetString("Enter the book's title : ");
                                String result2 = bm.findBookWithTitle(title);
                                System.out.println("Book's code : " + result2);
                                System.out.println("");
                                break;
                        }
                    } while (select > 0 && select < 3);
                    break;

                case 4:
                    System.out.println("");
                    System.out.println("View the book : ");
                    int selection = 0;
                    do {
                        System.out.println("1-View all book.");
                        System.out.println("2-View with paging.");
                        System.out.println("Press other to Exit.");
                        System.out.println("");
                        selection = Inputter.Inputter.GetInt("Enter your selection : ");

                        switch (selection) {
                            case 1:
                                bm.view();
                                System.out.println("");
                                break;
                            case 2:
                                int pageIndex = Inputter.Inputter.GetInt("Enter the page index that you wanna see :");
                                bm.viewWithPage(pageIndex, 2);
                                System.out.println("");
                                break;
                        }
                    } while (selection > 0 && selection < 3);
                    break;
                case 5:
                    String file = Inputter.Inputter.GetString("Enter the file's name : ");
                    bm.writeFileExcel(file);
                    System.out.println("");
                    break;
            }
        } while (choice > 0 && choice < 6);

    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
    }
}
