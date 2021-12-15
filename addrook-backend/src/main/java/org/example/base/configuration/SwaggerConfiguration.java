package org.example.base.configuration;

import io.swagger.annotations.ApiOperation;
import org.example.base.util.SwaggerPropertiesUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <b>swagger 配置信息生成类</b>
 * @author 王晗
 * @version 5.0.0
 */
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket createRestAPI(){
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				//设置swqgger文档生成信息
				.apiInfo(apiInfo())
				//设置swagger扫描接口的基础包位置
				.select()
				//扫描所有注解是@ApiOperation的注解
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				//.apis(RequestHandlerSelectors.basePackage(SwaggerPropertiesUtil.getBasePackage()))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

	/**
	 * <b>获得swagger描述信息</b>
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				//设置交互文档标题
				.title(SwaggerPropertiesUtil.getTittle())
				//设置交互文档描述
				.description(SwaggerPropertiesUtil.getDescription())
				//设置联系人信息
				.contact(new Contact(SwaggerPropertiesUtil.getContactName()
						, SwaggerPropertiesUtil.getContactUrl()
						, SwaggerPropertiesUtil.getContactEmail()))
				//设置许可
				.license(SwaggerPropertiesUtil.getLicense())
				//设置许可网址
				.licenseUrl(SwaggerPropertiesUtil.getLicenseUrl())
			//设置服务条款
				.version(SwaggerPropertiesUtil.getVersion())
				.termsOfServiceUrl(SwaggerPropertiesUtil.getTermsOfServiceUrl())
				.build();
	}
}
