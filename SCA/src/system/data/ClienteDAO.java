package system.data;

/*
* (c) 2021
* @author Yoselin Rojas, Cinthya Murillo
* @version 1.0.0 2021-10-24
*
* -----------------------------------------------
* EIF206 Programación III
* 2do Ciclo 2021
* II Proyecto
*
* 207700499 Rojas Fuentes, Yoselin - Grupo 04
* 305260682 Murillo Hidalgo, Cinthya - Grupo 03
* -----------------------------------------------
*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema.logic.Cliente;

public class ClienteDAO {
    DataBase db;
    
    public ClienteDAO(){
        db = DataBase.instance();
    }

    public void create(Cliente c) throws Exception{
        String sql="insert into Cliente (user, password, balance) "+
                "values(?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getUsuario());
        stm.setString(2, c.getClave());
        stm.setString(3, String.valueOf(c.getSaldoCuenta()));
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente ya existe.");
        }
    }
    
    public Cliente login(Cliente user) throws Exception{
        String sql="select * from Cliente c where user=? and password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, user.getUsuario());
        stm.setString(2, user.getClave());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Cliente c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Cliente no existe.");
        }
    }
    
    public double balance(String cedula) throws Exception{
        String sql="select * from Cliente c where user=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Cliente c = from(rs, "c"); 
            return c.getSaldoCuenta();
        }
        else{
            throw new Exception ("Cliente no existe.");
        }
    }
    
     public void retiro(String cedula, int monto) throws Exception{
        String sql="update Cliente set balance=balance-?"+
                "where user=? and balance>=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, monto);
        stm.setString(2, cedula);
        stm.setInt(3, monto);
        ResultSet rs =  db.executeQuery(stm);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Saldo insuficiente.");
        }
    }
     
     public void cambioClave(String cedula, String nueva) throws Exception{
        String sql="update Cliente set password=?"+
                "where user=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        stm.setString(2, nueva);
        ResultSet rs =  db.executeQuery(stm);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Saldo insuficiente.");
        }
    }
    
    public Cliente read(String cedula) throws Exception{
        String sql="select * from Cliente c where usuario=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Cliente c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Cliente no existe.");
        }
    }
    public void update(Cliente c) throws Exception{
        String sql="update user set password=?, balance=? "+
                "where usuario=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getUsuario());
        stm.setString(2, c.getClave());
        stm.setString(3, String.valueOf(c.getSaldoCuenta()));       
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente no existe");
        }        
    }

    public void delete(Cliente c) throws Exception{
        String sql="delete from user where usuario=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getUsuario());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliebte no existe.");
        }
    }
    
    
    public List<Cliente> findAll(){
        List<Cliente> resultado=new ArrayList<>();
        try {
            String sql="select * from Cliente c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs =  db.executeQuery(stm);
            Cliente c;
            while (rs.next()) {
                c = from(rs, "c"); 
                resultado.add(c);
            }
        } catch (SQLException ex) { }
        return resultado;        
    }

    public List<Cliente> findByCedula(String cedula){
        List<Cliente> resultado = new ArrayList<>();
        try {
            String sql="select * from user c "+
                    "where c.usuario like ?";            
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, cedula+"%");
            ResultSet rs =  db.executeQuery(stm); 
            Cliente c;
            while (rs.next()) {
                c = from(rs, "c"); 
                resultado.add(c);
            }
        } catch (SQLException ex) {  }
        return resultado;
    }
    
    public Cliente from(ResultSet rs, String alias){
        try {
            Cliente c= new Cliente();
            c.setUsuario(rs.getString(alias+".user"));
            c.setClave(rs.getString(alias+".password"));
            c.setSaldoCuenta(Double.parseDouble(rs.getString(alias+".balance")));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }    
}
