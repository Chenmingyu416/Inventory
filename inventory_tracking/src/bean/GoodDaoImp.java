package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class GoodDaoImp implements GoodDao{
    private Connection connection;
    private PreparedStatement goodQuery;
    private ResultSet results;
    @Override
    public List<Good> getGoods() {
        List<Good> goodsList = new ArrayList<Good>();
        // connect to the db to get result
        try {
            connection = DBcon.getConnction();
            System.out.println("connect success!");
            goodQuery = connection.prepareStatement(
                    "select goodId,goodName,type,supplier,count,price from inventory_info order by goodId");
            ResultSet results = goodQuery.executeQuery();

            while (results.next()) {
                Good good = new Good();
                good.setGoodId(results.getString("goodId"));
                good.setGoodName(results.getString("goodName"));
                good.setType(results.getString("type"));
                good.setSupplier(results.getString("supplier"));
                good.setCount(results.getInt("count"));
                good.setPrice(results.getFloat("price"));
                goodsList.add(good);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            DBcon.closeResultSet(results);
            DBcon.closeStatement(goodQuery);
            DBcon.closeConnection(connection);
        }
        return goodsList;
    }

    @Override
    public int add(Good goodbean) {
        int result = 0;
        try {
            connection = DBcon.getConnction();
            String sql = "insert into inventory_info(goodId, goodName, type, supplier, count, price) values(?,?,?,?,?,?)";
            goodQuery = connection.prepareStatement(sql);
            goodQuery.setString(1, goodbean.getGoodId());
            goodQuery.setString(2, goodbean.getGoodName());
            goodQuery.setString(3, goodbean.getType());
            goodQuery.setString(4, goodbean.getSupplier());
            goodQuery.setInt(5, goodbean.getCount());
            goodQuery.setFloat(6, goodbean.getPrice());
            result = goodQuery.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBcon.closeResultSet(results);
            DBcon.closeStatement(goodQuery);
            DBcon.closeConnection(connection);
        }
        return result;

    }

    @Override
    public int delete(String goodId) {
        int result = 0;
        try {
            connection = DBcon.getConnction();
            String sql = "delete from inventory_info where goodId='" + goodId + "'";
            goodQuery = connection.prepareStatement(sql);
            result = goodQuery.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBcon.closeResultSet(results);
            DBcon.closeStatement(goodQuery);
            DBcon.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int update(Good goodbean) {
        int result = 0;
        try {
            connection = DBcon.getConnction();
            String sql = "update inventory_info set goodName=?, type=?,supplier=?, count=?, price=?where goodId=?";
            goodQuery = connection.prepareStatement(sql);

            goodQuery.setString(1, goodbean.getGoodName());
            goodQuery.setString(2, goodbean.getType());
            goodQuery.setString(3, goodbean.getSupplier());
            goodQuery.setInt(4, goodbean.getCount());
            goodQuery.setFloat(5, goodbean.getPrice());
            goodQuery.setString(6, goodbean.getGoodId());

            result = goodQuery.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBcon.closeResultSet(results);
            DBcon.closeStatement(goodQuery);
            DBcon.closeConnection(connection);
        }
        return result;
    }

    @Override
    public Good findById(String goodId) {

        Good good = null;
        try {
            connection = DBcon.getConnction();
            String sql = "SELECT * FROM inventory_info where goodId='" + goodId + "'";
            goodQuery = connection.prepareStatement(sql);
            results = goodQuery.executeQuery();
            if (results.next()) {

                good = new Good();
                good.setGoodId(results.getString("goodId"));
                good.setGoodName(results.getString("goodName"));
                good.setType(results.getString("type"));
                good.setSupplier(results.getString("supplier"));
                good.setCount(results.getInt("count"));
                good.setPrice(results.getFloat("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBcon.closeResultSet(results);
            DBcon.closeStatement(goodQuery);
            DBcon.closeConnection(connection);
        }
        return good;
    }

    public void export() {
        List<Good> goodsList = new ArrayList<Good>();
        File writeFile = new File("/Users/chenmingyu//Desktop/inventory_tracking/inventory_info.csv");
        //you change the output file path.

        try{
            BufferedWriter writeText = new BufferedWriter(new FileWriter(writeFile));
            writeText.write("goodId,goodName,type,supplier,count,price");
            try{
                connection = DBcon.getConnction();
                System.out.println("connect success!");
                goodQuery = connection.prepareStatement(
                        "select goodId,goodName,type,supplier,count,price from inventory_info order by goodId");
                ResultSet results = goodQuery.executeQuery();
                while (results.next()) {
                    writeText.newLine();
                    writeText.write(results.getString("goodId")+","+
                            results.getString("goodName")+","+
                            results.getString("type")+","+
                            results.getString("supplier")+","+
                            results.getInt("count")+","+
                            results.getFloat("price")
                    );
                    System.out.println(results.getString("goodId")+","+
                            results.getString("goodName")+","+
                            results.getString("type")+","+
                            results.getString("supplier")+","+
                            results.getInt("count")+","+
                            results.getFloat("price"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            writeText.flush();
            writeText.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }

    }
}
