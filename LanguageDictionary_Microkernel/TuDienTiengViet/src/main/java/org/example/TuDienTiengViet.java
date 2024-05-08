package org.example;

import org.example.core.TuDien;

public class TuDienTiengViet implements TuDien {
    @Override
    public String name() {
        return "Tu dien tieng viet";
    }

    @Override
    public String traTuDien(String key) {
        if(key.equals("xin chao")){
            return "la mot loi chao";
        } else if (key.equals("cam on")) {
            return "la mot loi noi mang tinh biet on";
        }else {
            return "khong co trong tu dien";
        }

    }
}
