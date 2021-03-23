package com.mybatis;


import com.mybatis.pojo.MyUser;
import com.mybatis.pojo.SexEnum;
import com.mybatis.utils.CodeUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class myBatisTest {
    public static void main(String[] args) throws Exception {
        Logger log = Logger.getLogger(myBatisTest.class);
        try {
            String resource="mybatis-config.xml";
            InputStream inputstream;
            InputStream in=Resources.getResourceAsStream("db.properties");
            Properties props=new Properties();
            props.load(in);
            String username=props.getProperty("database.username");
            String password=props.getProperty("database.password");

            //解密用户和密码，并在属性中重置
            props.put("database.username", CodeUtils.base64(username));
            props.put ("database.password", CodeUtils.base64(password));
            inputstream = Resources.getResourceAsStream(resource);
            //使用程序传递的方式覆盖原有的properties属性参数
            SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(inputstream,props);

            // 通过 SqlSessionFactory 创建 SqlSession
            SqlSession ss = ssf.openSession();
            // SqlSession执行映射文件中定义的SQL，并返回映射结果
            /*
             * com.mybatis.mapper.UserMapper.selectUserById 为 UserMapper.xml
             * 中的命名空间+select 的 id
             */
            // 查询一个用户
            MyUser mu = ss.selectOne(
                    "com.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println(mu);
            // 添加一个用户
            MyUser addmu = new MyUser();
            addmu.setUname("赵六");
            addmu.setUsex(SexEnum.MALE);
            ss.insert("com.mybatis.dao.UserMapper.addUser", addmu);
//            // 修改一个用户
            MyUser updatemu = new MyUser();
            updatemu.setUid(1);
            updatemu.setUname("张三二");
            updatemu.setUsex(SexEnum.FEMALE);
            ss.update("com.mybatis.dao.UserMapper.updateUser", updatemu);
//            // 删除一个用户
            ss.delete("com.mybatis.dao.UserMapper.deleteUser", 3);
            // 查询所有用户
            List<MyUser> listMu = ss
                    .selectList("com.mybatis.dao.UserMapper.selectAllUser");
            for (MyUser myUser : listMu) {
                System.out.print(myUser.getUname());
                log.info(myUser.getUsex().getName());
            }
            // 提交事务
            ss.commit();
            // 关闭 SqlSession
            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
