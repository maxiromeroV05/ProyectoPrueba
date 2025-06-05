package org.example.eduechinnovators.model;

public class Soporte {
    private int id_soporte;
    private int id_usuario;
    private String mensaje;
    private String estado;

    public Soporte() {}

    public Soporte(int id_soporte, int id_usuario, String mensaje, String estado) {
        this.id_soporte = id_soporte;
        this.id_usuario = id_usuario;
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public int getId_soporte() {
        return id_soporte;
    }

    public void setId_soporte(int id_soporte) {
        this.id_soporte = id_soporte;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


