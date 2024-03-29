package com.team.hospital.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorUtil {

	public static void main(String[] args) {
		try {
			System.out.println("start generator ...");
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			//File configFile = new File(MybatisGeneratorUtil.class.getResource("/generator.xml").getFile());
			File configFile = new File("D:\\北大青鸟学习\\U3\\Projects\\hospital\\src\\main\\resources\\generator.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			if (warnings.isEmpty()){
				System.out.println("文件生成成功!");
			}else {
				System.err.println(warnings);
			}
			System.out.println("end generator!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}