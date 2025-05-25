package org.example.eduechinnovators.model;

public class Soporte {
    private int id;
    private int usuarioId;
    private String mensaje;
    private String estado;

    public Soporte() {}

    public Soporte(int id, int usuarioId, String mensaje, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

