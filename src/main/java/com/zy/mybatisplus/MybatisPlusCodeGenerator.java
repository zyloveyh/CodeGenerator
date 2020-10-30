package com.zy.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
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
    private static String pcName = "com.chinastock.quickproject.backend";
    //模块名
    private static String modelName = "dict";
    //表明，多个用逗号分隔
    private static String tableName = "t_dict";
    private static String url = "jdbc:sqlite:X:\\db.sqlite";
    private static String driverClassName = "org.sqlite.JDBC";
    private static String username = "";
    private static String password = "";


    private static String projectPath;
    // 自定义配置
    private static InjectionConfig cfg = new InjectionConfig() {
        @Override
        public void initMap() {
            // to do nothing
        }
    };
    // 自定义输出配置
    private static List<FileOutConfig> focList = new ArrayList<>();

    public static void main(String[] args) throws IOException, TemplateException {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zy");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);//设置是否覆盖原来的代码
        gc.setBaseResultMap(true);
//        gc.setEntityName("%sDTO");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // dsc.setSchemaName("public");
        dsc.setUrl(url)
                .setDriverName(driverClassName)
                .setUsername(username)
                .setPassword(password);
        dsc.setDbType(DbType.SQLITE);
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
        /**
         * 前缀
         */
        strategy.setTablePrefix("t_");

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.setTemplate(new TemplateConfig()
                //.setXml(null)//指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
                //注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                .setController("templates2/controller.java")
                .setEntity("templates2/entity.java")
                .setMapper("templates2/mapper.java")
                .setXml("templates2/mapper.xml")
                .setService("templates2/service.java")
                .setServiceImpl("templates2/serviceImpl.java"));
/*
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
        mpg.setCfg(cfg);*/


//        addNowTemplate(mpg, "templates/baseResultMessage.java.ftl", "message", "BaseResultMessage");
//        addNowTemplate(mpg, "templates/resultBody.java.ftl", "entity", "ResultBody");
        addNowTemplate(mpg, "templates2/paramCheckUtil.java.ftl", "utils", "ParamCheckUtil");

        mpg.execute();
/*


        Map<String, Object> map = new HashMap<>();
        map.put("packageName", pcName + "." + modelName + ".message");
        generatorEntity(map, "/src/main/resources/templates/baseResultMessage.java.ftl",
                projectPath + "/src/main/java/" + pcName.replaceAll("\\." +
                        "", "/") + "/" + modelName + "/" + "message/BaseResultMessage.java");
*/

    }


    public static void addNowTemplate(AutoGenerator mpg, String templatePath, String prePackage, String className) {

        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/java/" + pcName.replaceAll("\\." +
                        "", "/") + "/" + modelName + "/" + prePackage + "/" + className + ".java";
            }
        });

        if (cfg.getFileOutConfigList() != null) {
            focList.addAll(cfg.getFileOutConfigList());
        }
        cfg.setFileOutConfigList(focList);

        Map<String, Object> map = new HashMap<>();
        map.put(className, pcName + "." + modelName + "." + prePackage);
        if (cfg.getMap() != null) {
            map.putAll(cfg.getMap());
        }
        cfg.setMap(map);

        mpg.setCfg(cfg);
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

    private final static String UNDERLINE = "_";

    /***
     * 下划线命名转为驼峰命名
     *
     * @param para
     *        下划线命名的字符串
     */

    public static String underlineToHump(String para) {
        StringBuilder result = new StringBuilder();
        String a[] = para.split(UNDERLINE);
        for (String s : a) {
            if (!para.contains(UNDERLINE)) {
                result.append(s);
                continue;
            }
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /***
     * 驼峰命名转为下划线命名
     *
     * @param para
     *        驼峰命名的字符串
     */

    public static String humpToUnderline(String para) {
        StringBuilder sb = new StringBuilder(para);
        int temp = 0;//定位
        if (!para.contains(UNDERLINE)) {
            for (int i = 0; i < para.length(); i++) {
                if (Character.isUpperCase(para.charAt(i))) {
                    sb.insert(i + temp, UNDERLINE);
                    temp += 1;
                }
            }
        }
        return sb.toString().toUpperCase();
    }
}
