/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductMaintenance.business;

import java.util.ArrayList;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eric
 */
public class ProductDB implements ProductDAO {

    private Connection getConnection(){
        Connection connection = null;
        try
        {
            String dbDirectory = "C:\\Program Files\\Java\\jdk-10.0.2\\db";
            System.setProperty("derby.system.home", dbDirectory);
            
            String url = "jdbc:derby:MurachDB";
            String username = "";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        catch(SQLException e){
            System.err.println(e);
            return null;
        }
    }
    
    
    @Override
    public boolean addProduct(Product p) {
        String sql = "insert into Products (ProductCode, Description, Price) "
                + "values (?, ?, ?)";
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, p.getCode());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product p) {
        String url = "update products set "
                + "Description = ?, " +
                "Price = ? " +
                "Where ProductCode = ? ";
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(url)){
                ps.setString(1, p.getDescription());
                ps.setDouble(2, p.getPrice());
                ps.setString(3, p.getCode());
                ps.executeUpdate();
                return true;
                        
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean deleteProduct(Product p) {
        String sql = "delete from products " +
                "where productCode = ? ";
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, p.getCode());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
        
    }

    @Override
    public boolean saveProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProduct(String code) {
        String sql = "select ProductCode, description, price "
                + "from products "
                + "where productcode = ?";
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
                ){
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                Product p = new Product(code, description, price);
                rs.close();
                return p;
            }
            else{
                rs.close();
                return null;
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<Product> getProducts() {
        String sql = "select ProductCode, Description, Price "
                + "from products order by productCode asc";
        ArrayList<Product> products = new ArrayList<>();
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                Product p = new Product(code, description, price);
                products.add(p);
            }
            return products;
            
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
//        finally{
//            rs.close();
//        }
    }

    @Override
    public String getProductsString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
