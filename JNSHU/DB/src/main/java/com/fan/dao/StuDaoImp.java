package com.fan.dao;

import com.fan.pojo.Stu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;

public class StuDaoImp implements StuDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean doCreate(final Stu stu) throws Exception {
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "insert into stu(name,qq,major,graduate,reportlink,wish,create_at) values(?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,stu.getName());
                preparedStatement.setLong(2,stu.getQq());
                preparedStatement.setString(3,stu.getMajor());
                preparedStatement.setString(4,stu.getGraduate());
                preparedStatement.setString(5,stu.getReportlink());
                preparedStatement.setString(6,stu.getWish());
                preparedStatement.setLong(7,System.currentTimeMillis());
                return preparedStatement;
            }
        },keyHolder);
        int id=keyHolder.getKey().intValue();
        System.out.println(id);
        return true;

//        String sql = "insert into stu(name,qq,major,graduate,reportlink,wish,create_at) values(?,?,?,?,?,?,?)";
//        if(jdbcTemplate.update(sql, stu.getName(), stu.getQq(), stu.getMajor(),stu.getGraduate(), stu.getReportlink(), stu.getWish(),System.currentTimeMillis())==1?true:false){
//            System.out.println(stu.getId());
//            return true;
//        }return false;
    }


    public boolean doCreate1(List<Stu> stus) throws Exception {
        String sql="insert into stu (name,qq,major,graduate,reportlink,wish,create_at) values(?,?,?,?,?,?,?)";
        Connection connection = jdbcTemplate.getDataSource().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Stu stu : stus) {
                preparedStatement.setString(1, stu.getName());
                preparedStatement.setLong(2, stu.getQq());
                preparedStatement.setString(3, stu.getMajor());
                preparedStatement.setString(4, stu.getGraduate());
                preparedStatement.setString(5, stu.getReportlink());
                preparedStatement.setString(6, stu.getWish());
                preparedStatement.setLong(7, System.currentTimeMillis());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();
            preparedStatement.close();
            connection.commit();
        }catch(Exception e){
            try {
                e.printStackTrace();
                connection.rollback();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }finally {
            try{
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return true;
    }


    public boolean doUpdate(Stu stu) throws Exception {
        String sql="update stu set name=?,qq=?,major=?,graduate=?,reportlink=?,wish=?,update_at=? where id=?";
        return jdbcTemplate.update(sql,stu.getName(), stu.getQq(), stu.getMajor(),stu.getGraduate(), stu.getReportlink(), stu.getWish(),System.currentTimeMillis(),stu.getId())==1?true:false;
    }

    public boolean doRemove(int id) throws Exception {
        String sql="delete from stu where id=?";
        return jdbcTemplate.update(sql,id)==1?true:false;
    }

    public Stu queryById(int id) throws Exception {
        String sql="select * from stu where id=?";
        List<Stu> stus=jdbcTemplate.query(sql,new StuRowMapper(),id);
        for(Stu stu:stus){
            System.out.println(stu);
        }
        if(stus.size()>0){
            return stus.get(0);
        }
        System.out.println("未找到符合条件的学生！");
        return null;
    }

    public List<Stu> queryAll() throws Exception {
        String sql="select * from stu";
        List<Stu> stus=jdbcTemplate.query(sql,new StuRowMapper());
        for(Stu stu:stus){
            System.out.println(stu);
        }
        if(stus.size()>0){
            return stus;
        }
        System.out.println("未找到符合条件的学生！");
        return null;
    }
    class StuRowMapper implements RowMapper<Stu> {
        public Stu mapRow(ResultSet rs, int rowNum) throws SQLException {
            Stu stu = new Stu();
            stu.setId(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setQq(rs.getLong("qq"));
            stu.setMajor(rs.getString("major"));
            stu.setGraduate(rs.getString("graduate"));
            stu.setReportlink(rs.getString("reportlink"));
            stu.setWish(rs.getString("wish"));
            stu.setCreate_at(rs.getLong("create_at"));
            stu.setUpdate_at(rs.getLong("update_at"));
            return stu;
        }
    }
}
