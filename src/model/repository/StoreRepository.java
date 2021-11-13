package model.repository;

import common.JDBC;
import model.entity.StoreEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StoreRepository implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public StoreRepository() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(StoreEntity storeEntity)throws Exception
    {
        preparedStatement = connection.prepareStatement("insert into store (code,name) values (?,?)");
        preparedStatement.setLong(1,storeEntity.getCode());
        preparedStatement.setString(2,storeEntity.getName());
        preparedStatement.executeUpdate();
    }

    public String select()throws Exception
    {
        preparedStatement = connection.prepareStatement("select * from store");
        ResultSet resultSet = preparedStatement.executeQuery();
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",resultSet.getLong("code"));
            jsonObject.put("name",resultSet.getString("name"));
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }

    public void update(StoreEntity storeEntity)throws Exception
    {
        preparedStatement = connection.prepareStatement("update store set name=? where code=?");
        preparedStatement.setString(1,storeEntity.getName());
        preparedStatement.setLong(2,storeEntity.getCode());
        preparedStatement.executeUpdate();
    }

    public void delete(StoreEntity storeEntity)throws Exception
    {
        preparedStatement = connection.prepareStatement("delete from store where code=?");
        preparedStatement.setLong(1,storeEntity.getCode());
        preparedStatement.executeUpdate();
    }

    public void close()throws Exception
    {
        preparedStatement.close();
        connection.close();
    }
}
