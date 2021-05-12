package springdemo.jdbc;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyBatisGeneratorMain {

    public static void main(String[] args) throws Exception {
        MyBatisGeneratorMain main = new MyBatisGeneratorMain();
//        main.testConn();
        main.runGenerator();
    }

    /**
     * 执行MyBatis Generator
     *
     * @throws Exception _
     */
    void runGenerator() throws Exception {
        System.out.println("==============start running==============");
        List<String> warnings = new ArrayList<>();
        InputStream configFile = getClass().getResourceAsStream("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        // 如果已经存在生成过的文件是否进行覆盖
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
        generator.generate(null);
        System.out.println("==============end of run==============");
    }

    /**
     * Test the connection to the database
     *
     * @throws Exception _
     */
    void testConn() throws Exception {
        // get springdemo.jdbc.config info
        InputStream in = getClass().getResourceAsStream("db.properties");
        Properties config = new Properties();
        config.load(in);
        String url = config.getProperty("maria.connectionURL");
        String username = config.getProperty("maria.username");
        String pwd = config.getProperty("maria.password");
        String driverClass = config.getProperty("maria.driverClass");
        Class.forName(driverClass);
        in.close();
        // test connection
        final String testSql = "SELECT 1 FROM DUAL";
        try (
                Connection conn = DriverManager.getConnection(url, username, pwd);
                PreparedStatement ps = conn.prepareStatement(testSql);
                ResultSet rs = ps.executeQuery()
        ) {
            System.out.println("conn: " + conn);
            System.out.println("is conn valid: " + conn.isValid(5000));
            rs.next();
            System.out.println("is sql test succeed: " + (rs.getInt(1) == 1));
        }
    }

}


