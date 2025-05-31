package Usuarios;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String nombre;
    protected int id;
    protected String login;
    protected String password;

    public Usuario(String nombre, int id, String login, String password) {
        this.nombre = nombre;
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public boolean autenticar(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
