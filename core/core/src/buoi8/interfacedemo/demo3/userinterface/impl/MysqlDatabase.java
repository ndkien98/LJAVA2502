package buoi8.interfacedemo.demo3.userinterface.impl;

import buoi8.interfacedemo.demo3.userinterface.IDatabase;

public class MysqlDatabase implements IDatabase {
    @Override
    public void getConnection() {
        System.out.println("get connection mysql");
    }

    @Override
    public void getAllUser() {
        System.out.println("get all user mysql");
    }
}
