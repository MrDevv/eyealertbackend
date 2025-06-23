package com.mrdevv.utils;

public enum Roles {
    ADMINISTRADOR("administrador"),
    USUARIO("usuario");

    private final String rol;

    Roles(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return this.rol;
    }
}
