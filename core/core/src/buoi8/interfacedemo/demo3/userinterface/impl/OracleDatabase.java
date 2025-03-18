package buoi8.interfacedemo.demo3.userinterface.impl;

import buoi8.interfacedemo.demo3.userinterface.IDatabase;

public class OracleDatabase implements IDatabase {
    @Override
    public void getConnection() {
        System.out.println("Connecting to Oracle");
    }

    @Override
    public void getAllUser() {
        System.out.println("Getting all users oracle");
    }
}
