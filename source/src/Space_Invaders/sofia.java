package Space_Invaders;
import javax.sql.*;
import java.sql.*;
import java.awt.*;
import java.lang.ClassNotFoundException;
import java.io.*;

public class sofia {

    Connection conexion;

    public void connectDB(  ){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/spaceInvaders", "tales", "");
        }catch ( Exception e2 ){ System.out.println("Error in Connection to Database"); }
    }

    public void connectDB2(  ){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/spaceInvaders", "root", "");
        }catch ( Exception e2 ){ System.out.println("Error in Connection to Database"); }
    }

    public void insertar( int pnts, String jugador ){
        try{

            Statement st = conexion.createStatement();
            ResultSet rs; int id = 0, puntaje = 0;

            for( int i = 1; i < 12; ++i ){
                rs = st.executeQuery( "SELECT Num_Puntaje_Ranking FROM Tbl_Ranking WHERE Num_Pocision_Ranking=" + i );
                if ( rs.next() ){
                puntaje = rs.getInt("Num_Puntaje_Ranking");
                if( pnts > puntaje ){ id = i; break; }
                }else if( id == 0 ) id = i;
            }

            for( int a = 11; a >= id && id > 0; --a ){
                int h = a+1;
                st.executeUpdate("UPDATE Tbl_Ranking SET Num_Pocision_Ranking="+h+" WHERE Num_Pocision_Ranking="+a);
            }

            if( id != 0 ) st.executeUpdate("INSERT INTO Tbl_Ranking (Str_Jugador_Ranking, Num_Pocision_Ranking, Num_Puntaje_Ranking) VALUES ('"+jugador+"','"+id+"','"+pnts+"' )");
            st.execute("CALL limpiar()");
        }catch ( Exception e2 ){ System.out.println("Error in Connection to Database"); }

    }

    public String getIcono( ){
        return "src\\Space_Invaders\\Imagenes\\logo.png";
    }


    public String get_escenarioImagen( int id ){
        if( id == 1 ) return "src\\Space_Invaders\\Imagenes\\fondo.jpg";
        else return "Por ahora no hay mas";
    }

    public String get_invasorImagen( int id, int id2 ){
        try{

            Statement st = conexion.createStatement();
            long r = id + ( 3* (id2 -1));
            ResultSet rs = st.executeQuery( "SELECT Img_Imagen_Imagen FROM `Tbl_Tipo` as tipo, Tbl_Imagen as imagena where tipo.Num_Id_Tipo ="+r+" && tipo.Num_Id_Imagen = imagena.Num_Id_Imagen");
            rs.next();
            Blob imagen = rs.getBlob("Img_Imagen_Imagen");
            InputStream imagenRecuperada = imagen.getBinaryStream();
            String ruta = "src\\Space_Invaders/Imagenes/invasor" + r + ".gif";
            guardaImagenEnDisco( imagenRecuperada, ruta );
            return ruta;

        }catch ( Exception e2 ){ System.out.println("Error in Connection to Database"); }
        return "Error";
    }

    public int get_velocidadNivel( int id ){
        int velocidad = 500;
        try{
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery( "SELECT Num_Velocidad_Mundo FROM `Tbl_Mundo` as mundo WHERE mundo.Num_Id_Mundo = 1");
            rs.next();
            velocidad = rs.getInt( "Num_Velocidad_Mundo" );
            return velocidad;
        }catch( Exception e ){ System.out.println("Error to Get Velocity"); }
        return velocidad;
    }


    public int get_personajeVidas( int id ){
        int vidas = 1;
        try{
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery( "SELECT Num_Vidas_Personaje FROM `Tbl_Personaje` as personaje WHERE personaje.Num_Id_Personaje ="+id);
            rs.next();
            vidas = rs.getInt( "Num_Vidas_Personaje" );
            return vidas;
        }catch( Exception e ){ System.out.println("Error to Get Lives"); }
        return vidas;
    }


    public int get_poderesNivel( int id ){
        int cantidad = 0;
        try{
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery( "SELECT Num_Cantidad_Poderes FROM `Tbl_Poderes` as poderes WHERE poderes.Num_Id_Poderes = "+id);
            rs.next();
            cantidad = rs.getInt( "Num_Cantidad_Poderes" );
            return cantidad;
        }catch( Exception e ){ System.out.println("Error to Get the Powers"); }
        return cantidad;
    }

    public void reiniciar(){
        try{
            connectDB2( );
            Statement st = conexion.createStatement();
            st.executeQuery( "TRUNCATE TABLE `tbl_ranking`" );
        }catch( Exception e ){ System.out.println("Impossible Reset the tables"); }
    }


    public void borrarPosicion( int num ){
        try{
            connectDB2( );
            Statement st = conexion.createStatement();
            st.executeUpdate("DELETE FROM `spaceinvaders`.`tbl_ranking` WHERE `tbl_ranking`.`Num_Pocision_Ranking` ="+ num);
            for( int a = num+1; a <= 11; ++a ){
                int h = a-1;
                st.executeUpdate("UPDATE Tbl_Ranking SET Num_Pocision_Ranking="+h+" WHERE Num_Pocision_Ranking="+a);
            }
            st.execute("CALL limpiar()");
        }catch( Exception e ){ System.out.println("Impossible Reset the tables"); }
    }

    
    public void insertarPoder( int cantidad ){
        try{
            connectDB2( );
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(" SELECT count( * ) FROM Tbl_Poderes ");
            rs.next();
            int tales = rs.getInt(1); tales++;
            st.executeUpdate("INSERT INTO Tbl_Poderes (Num_Id_Poderes, Num_Cantidad_Poderes) VALUES ("+tales+","+cantidad+")");
        }catch( Exception e ){ System.out.println("Impossible insert power"); }
    }

    public void actualizarPoder( int mundo ){
        try{
            connectDB2();
            Statement st = conexion.createStatement();
            st.executeUpdate("UPDATE `spaceinvaders`.`tbl_mundo` SET `Num_Id_Poderes` = '2' WHERE `tbl_mundo`.`Num_Id_Mundo`="+mundo);
        }catch( Exception e ){  }
    }

    public void actualizarNombre( String nombre, int posicion  ){
        try{
            connectDB2();
            Statement st = conexion.createStatement();
            st.executeUpdate("UPDATE `spaceinvaders`.`tbl_ranking` SET `Str_Jugador_Ranking` = '"+nombre+"' WHERE `tbl_ranking`.`Num_Pocision_Ranking`="+posicion);
        }catch( Exception e ){  }
    }

    public void insertarPosicion( int pnts, String jugador ){
        try{
            connectDB2();
            Statement st = conexion.createStatement();
            ResultSet rs; int id = 0, puntaje = 0;

            for( int i = 1; i < 12; ++i ){
                rs = st.executeQuery( "SELECT Num_Puntaje_Ranking FROM Tbl_Ranking WHERE Num_Pocision_Ranking=" + i );
                if ( rs.next() ){
                puntaje = rs.getInt("Num_Puntaje_Ranking");
                if( pnts > puntaje ){ id = i; break; }
                }else if( id == 0 ) id = i;
            }

            for( int a = 11; a >= id && id > 0; --a ){
                int h = a+1;
                st.executeUpdate("UPDATE Tbl_Ranking SET Num_Pocision_Ranking="+h+" WHERE Num_Pocision_Ranking="+a);
            }

            if( id != 0 ) st.executeUpdate("INSERT INTO Tbl_Ranking (Str_Jugador_Ranking, Num_Pocision_Ranking, Num_Puntaje_Ranking) VALUES ('"+jugador+"','"+id+"','"+pnts+"' )");
            st.execute("CALL limpiar()");
        }catch ( Exception e2 ){ System.out.println("Error in Connection to Database"); }
    }

    public String get_poderesImagen( int id ){
        int r;
        if(id == 1) r = 1;
        else if ( id == 2 ) r = 2;
        else r = 5;

        try{

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery( "SELECT Img_Imagen_Imagen FROM `tbl_imagen` as imagena WHERE imagena.Num_Id_Imagen = "+r);
            rs.next();
            Blob imagen = rs.getBlob("Img_Imagen_Imagen");
            InputStream imagenRecuperada = imagen.getBinaryStream();
            String ruta = "src\\Space_Invaders/Imagenes/poder" + id + ".png";
            guardaImagenEnDisco( imagenRecuperada, ruta );
            return ruta;

        }catch ( Exception e2 ){ System.out.println("Error in Connection to Database"); }
        return "Error";
    }


    public String get_personajeImagen( int id ){
        try{

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery( "SELECT Img_Imagen_Imagen FROM `tbl_personaje` as `personaje`, `Tbl_Imagen` as imagena WHERE personaje.`Num_Id_Personaje` ="+id+" && personaje.Num_Id_Imagen = imagena.Num_Id_Imagen");
            rs.next();
            Blob imagen = rs.getBlob("Img_Imagen_Imagen");
            InputStream imagenRecuperada = imagen.getBinaryStream();
            String ruta = "src\\Space_Invaders/Imagenes/nave" + id + ".png";
            guardaImagenEnDisco( imagenRecuperada, ruta );
            return ruta;

        }catch ( Exception e2 ){ System.out.println("Error in Connection to Database"); }
        return "Error";
    }
    

    // This method was taken from http://www.adictosaltrabajo.com/
    public void guardaImagenEnDisco( InputStream imagenBuffer, String ruta ) {
            try {
                File fichero = new File(ruta);
                BufferedInputStream in = new BufferedInputStream(imagenBuffer);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichero));
                byte[] bytes = new byte[8096];
                int len = 0;
                while ( (len = in.read( bytes ))> 0 ) out.write( bytes, 0, len );
                out.flush();
                out.close();
                in.close();
            }
            catch(Exception e){ System.out.println("Error to Save the Image"); }
    }


    public void tales(){
        try {
            Statement st = conexion.createStatement();

            st.executeUpdate("CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY(id), nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");

            String nombres[]={"Juan","Pedro","Antonio"};
            String apellidos[]={"Gomez","Lopez","Alvarez"};
            String telefonos[]={"123","456","789"};

            for (int i=0;i<nombres.length;i++)
            st.executeUpdate("INSERT INTO contacto (nombre, apellidos, telefono) VALUES ('"+nombres[i]+"','"+apellidos[i]+"','"+telefonos[i]+"' )");

            ResultSet rs = st.executeQuery("SELECT * FROM contacto");
            while (rs.next()) {
                System.out.println("nombre="+rs.getObject(1)+
                ", apellidos="+rs.getObject(2)+
                ", telefono="+rs.getObject(3));
            }
            rs.close();

        }catch (Exception e) { e.printStackTrace(); }
    }

}
