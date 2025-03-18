package buoi8.interfacedemo.demo3.userinterface;


import buoi8.interfacedemo.demo3.userinterface.impl.MysqlDatabase;
import buoi8.interfacedemo.demo3.userinterface.impl.OracleDatabase;

public class BackEnd2 {

    public void getAllUserFromDatabase(IDatabase database){
        database.getConnection();
        database.getAllUser();
    }
    // giả sử hàm main chính là font-end
    public static void main(String[] args) {

        IDatabase iDatabase = new OracleDatabase();
        BackEnd2 backEnd2 = new BackEnd2();
        backEnd2.getAllUserFromDatabase(iDatabase);

    }
}
