package com.yakka.flex.generator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import com.yakka.basic.constant.Constants;
import com.yakka.flex.generator.enumeration.GenTypeEnum;
import com.yakka.flex.generator.enumeration.ProjectTypeEnum;
import com.yakka.flex.generator.enumeration.SuperClassEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取代码生成相关配置
 *
 * @author Jared
 * @date 2022年3月3日15:05:39
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = GeneratorConfig.PREFIX)
public class GeneratorConfig {
    public static final String PREFIX = Constants.PROJECT_PREFIX + ".generator";
    /**
     * 后端工程 yakka-datasource-max 代码生成跟路径
     */
    public String outputDir;
    /**
     * 前端工程yakka-web-pro 跟路径
     */
    public String frontOutputDir;
    /**
     * 前端工程yakka-web-pro-soybean 跟路径
     */
    public String frontSoyOutputDir;
    /**
     * 前端工程yakka-web-max-vben 跟路径
     */
    public String frontVben5OutputDir;


    /** 默认项目 */
    public ProjectTypeEnum projectType = ProjectTypeEnum.CLOUD;

    /**
     * 作者
     */
    public String author = "zuihou";
    /**
     * 去除表前缀(类名不会包含表前缀)
     */
    public List<String> tablePrefix = new ArrayList<>();
    /**
     * 去除字段前缀
     */
    public List<String> fieldPrefix = new ArrayList<>();
    /**
     * 去除字段后缀
     */
    public List<String> fieldSuffix = new ArrayList<>();
    /**
     * 后端项目前缀
     * 项目部分公共文件夹的名称
     * <p>
     * 如：后端 yakka-base、yakka-base-api、yakka-base-entity、yakka-base-biz、yakka-base-controller、yakka-base-server 等模块的前缀：yakka
     * 如：前端 src/api/yakka/xxx
     * 如：前端 src/utils/yakka/xxx
     * 如：前端 src/utils/yakka/xxx
     */
    private String projectPrefix = Constants.PROJECT_PREFIX;

    /**
     * 其他类的父类
     */
    private SuperClassEnum superClass = SuperClassEnum.SUPER_CLASS;

    /**
     * 生成方式
     */
    private GenTypeEnum genType = GenTypeEnum.GEN;

    /**
     * 包配置
     */
    @NestedConfigurationProperty
    private PackageInfoConfig packageInfoConfig = new PackageInfoConfig();

    /**
     * 实体 VO 配置
     */
    @NestedConfigurationProperty
    private EntityConfig entityConfig = new EntityConfig();
    /**
     * Mapper 配置
     */
    @NestedConfigurationProperty
    private MapperConfig mapperConfig = new MapperConfig();
    /**
     * Service 配置
     */
    @NestedConfigurationProperty
    private ServiceConfig serviceConfig = new ServiceConfig();
    /**
     * Manager 配置
     */
    @NestedConfigurationProperty
    private ManagerConfig managerConfig = new ManagerConfig();
    /**
     * Controller 配置
     */
    @NestedConfigurationProperty
    private ControllerConfig controllerConfig = new ControllerConfig();
    /**
     * Web 端配置
     */
    @NestedConfigurationProperty
    private WebProConfig webProConfig = new WebProConfig();
    /** 文件覆盖策略 */
    @NestedConfigurationProperty
    private FileOverrideStrategy fileOverrideStrategy = new FileOverrideStrategy();

    /**
     * 常用的常量、枚举包
     * 配置后，若生成代码时，枚举和常量名称与{constantsPackage.key}一致，就不会重复生成，而是采用{constantsPackage.value}的类
     */
    private Map<String, Class<?>> constantsPackage = new HashMap<>();

}
