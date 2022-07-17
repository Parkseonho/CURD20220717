package com.mysite.crud;
/*
데이터가 입력받아야 할때 해당 데이터의 유무 구분
 */
public class Ut {
    public static boolean empty(Object obj){
        if(obj == null){
            return true;
        }
        if(obj instanceof String == false){
            return true;
        }
        String str = (String) obj;
        
        return str.trim().length()==0;

    }
}

