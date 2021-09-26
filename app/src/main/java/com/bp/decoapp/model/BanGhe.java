package com.bp.decoapp.model;

import java.io.Serializable;

public class BanGhe implements Serializable {
     private String _soBan;
     private int _linkAnh;

     public BanGhe() { }

    public BanGhe(String _soBan, int _linkAnh) {
        this._soBan = _soBan;
        this._linkAnh = _linkAnh;
    }

    public String get_soBan() {
        return _soBan;
    }

    public void set_soBan(String _soBan) {
        this._soBan = _soBan;
    }

    public int get_linkAnh() {
        return _linkAnh;
    }

    public void set_linkAnh(int _linkAnh) {
        this._linkAnh = _linkAnh;
    }
}
