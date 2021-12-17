1. addrook V5.0.0 采用前后端分离开发方式
2. 后端项目框架
   (1) 核心框架 : spring boot + Mybatis plus
   (2) 分页插件 : Mybatis plus 分页插件
   (3) 交互接口文档框架: Swagger
        查看网址 http:localhost:80/swagger-ui/index.html
        (3.1) swagger 只能显示在控制层被
                @RequestBody    和   @ResponseBody
                注释的对象且该对象必须swagger的注解@ApiModel @ApiModelProperty
   (4) 日志功能 : logback
   (5) 数据库监控: druid
        查看网址:http:localhost:80/druid/
