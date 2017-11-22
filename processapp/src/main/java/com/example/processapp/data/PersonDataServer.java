package com.example.processapp.data;

import java.util.ArrayList;

/**
 * Created by zhangzhe on 2017/11/21.
 */

public class PersonDataServer {
    /**
     * 获取假数据list
     * @param size
     * @return
     */
    public static ArrayList<PersonBean> getSampleList(int size){
        ArrayList<PersonBean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            PersonBean person = new PersonBean();
            person.setName("ReRe"+i);
            person.setAvatar("http://7xi8d6.com1.z0.glb.clouddn.com/20171120074925_ZXDh6l_joanne_722_20_11_2017_7_49_16_336.jpeg");
            list.add(person);
        }
        return list;
    }
}
