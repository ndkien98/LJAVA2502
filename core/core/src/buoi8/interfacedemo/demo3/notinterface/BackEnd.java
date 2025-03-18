package buoi8.interfacedemo.demo3.notinterface;

public class BackEnd {


    public void getAllUserFromDatabase(MysqlDatabase mysql){
        mysql.getConnection();
        mysql.getAllUser();
    }

    // giả sử hàm main chính là font-end
    public static void main(String[] args) {
        MysqlDatabase oracleDatabase = new MysqlDatabase();
        BackEnd backEnd = new BackEnd();
        backEnd.getAllUserFromDatabase(oracleDatabase);
    }
}
