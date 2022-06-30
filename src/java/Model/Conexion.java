
package Model;


public class Conexion {

    private String driver;
    private String url;
    private String usuario;
    private String clave;

    public Conexion() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/solemne1";
        this.usuario = "root";
        this.clave = "";
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
}
