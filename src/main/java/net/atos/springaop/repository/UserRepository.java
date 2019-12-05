package net.atos.springaop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {


    public  String getValue(){

        return "UserRepository value = 11";
    }

}
