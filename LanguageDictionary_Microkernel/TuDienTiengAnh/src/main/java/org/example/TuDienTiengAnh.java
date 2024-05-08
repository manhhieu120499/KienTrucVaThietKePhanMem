package org.example;

import org.example.core.TuDien;

public class TuDienTiengAnh implements TuDien {
    @Override
    public String name() {
        return "Tu dien tieng anh";
    }

    @Override
    public String traTuDien(String key) {
        if(key.equals("hello")){
            return "xin chào";
        } else if (key.equals("thanks")) {
            return "cảm ơn";
        }else {
            return "khong co";
        }
    }
}
