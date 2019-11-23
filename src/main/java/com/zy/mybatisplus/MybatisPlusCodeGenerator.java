package com.zy.mybatisplus;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisPlusCodeGenerator {
    //模块所在的包名
    private static String pcName = "com.zy.mybatisplus";
    //模块名
    private static String modelName = "test";
    //表明，多个用逗号分隔
    private static String tableName = "person,students";
    private static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "asdfg1230";


    public static void main(String[] args) throws IOException, TemplateException {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zy");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);//设置是否覆盖原来的代码
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // dsc.setSchemaName("public");
        dsc.setUrl(url)
                .setDriverName(driverClassName)
                .setUsername(username)
                .setPassword(password);

        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(modelName);
        pc.setParent(pcName);
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(tableName.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.setTemplate(new TemplateConfig()
                //.setXml(null)//指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
                //注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                .setController("templates/controller.java")
                .setEntity("templates/entity.java")
                .setMapper("templates/mapper.java")
                .setXml("templates/mapper.xml")
                .setService("templates/service.java")
                .setServiceImpl("templates/serviceImpl.java"));

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "templates/baseResultMessage.java.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/java/" + pcName.replaceAll("\\." +
                        "", "/") + "/" + modelName + "/" + "message/BaseResultMessage.java";
            }
        });
        cfg.setFileOutConfigList(focList);
        Map<String, Object> map = new HashMap<>();
        map.put("packageName", pcName + "." + modelName + ".message");
        cfg.setMap(map);
        mpg.setCfg(cfg);


        mpg.execute();
/*


        Map<String, Object> map = new HashMap<>();
        map.put("packageName", pcName + "." + modelName + ".message");
        generatorEntity(map, "/src/main/resources/templates/baseResultMessage.java.ftl",
                projectPath + "/src/main/java/" + pcName.replaceAll("\\." +
                        "", "/") + "/" + modelName + "/" + "message/BaseResultMessage.java");
*/

    }

    public static void generatorEntity(Map<String, Object> rootMap, String templateFilePath, String outputFilePath) throws IOException,
            TemplateException {
        Configuration config = new Configuration();
        config.setObjectWrapper(new DefaultObjectWrapper());
        Template template = config.getTemplate(templateFilePath, "UTF-8");
        createFile(new File(outputFilePath));
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"));
        template.process(rootMap, out);
        out.flush();
        out.close();
    }

    public static void createFile(File file) throws IOException {
        System.out.println(file.getPath());
        //获取父目录
        File fileParent = file.getParentFile();
        //判断是否存在
        if (fileParent.exists()) {
            //创建父目录文件
            return;
        }
        createFile(fileParent);
        fileParent.mkdirs();
    }

}
