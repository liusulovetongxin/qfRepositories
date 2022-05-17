import com.qf.mapper.UserMapper;
import com.qf.pojo.TbUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatis2
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/5/17 12:33
 */

public class TestMain {

    @Test
    public void testFindById()throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        TbUser user = userMapper.findById(1L);
        System.err.println(user.toString());
    }
}
