1# CodeGenerator
java后台mybatis-plus代码生成器

用于生成基本的CRUD操作

基于 mybatis-plus swagger2 lombok freemarker

templates 目录下的为各个文件的模板

com.zy.mybatisplus.Swagger2Config 此文件为swagger2的配置文件,可以参考

com.zy.mybatisplus.MybatisPlusCodeGenerator 执行里面的main方法生产代码,详情请阅读代码

使用方法:

1 拷贝模板文件夹,放于项目resources文件夹下

2. 拷贝MybatisPlusCodeGenerator 文件放到项目文件夹中,然后执行此文件main方法,生成代码
