package br.com.jlabs.core.orm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class HibernateDDLGenerator {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        new HibernateDDLGenerator().execute("org.hibernate.dialect.Oracle10gDialect");
        new HibernateDDLGenerator().execute("org.hibernate.dialect.SQLServerDialect");
//    	new HibernateDDLGenerator().execute("org.hibernate.dialect.MySQL5Dialect");
    }

    public void execute(String dialect) throws IOException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        // hibernate.hbm2ddl.auto
        configuration.setProperty("hibernate.dialect", dialect);

        addPackage(configuration, "br.com.jlabs.model");
        SchemaExport export = new SchemaExport(configuration);
        //EnversSchemaGenerator enversExport = new EnversSchemaGenerator(configuration);
        //enversExport.export();
        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.setDelimiter(";");
        schemaExport.setOutputFile(String.format("%s_%s.%s ", new Object[] { "ddl", dialect, "sql" }));
        boolean consolePrint = true;
        boolean exportInDatabase = false;
        schemaExport.create(consolePrint, exportInDatabase);
    }

    private void addPackage(Configuration configuration, String packageName) throws IOException, ClassNotFoundException {
        List<Class> classNames = getPackageContent(packageName);
        for (Class className : classNames) {
            configuration.addAnnotatedClass(className);
        }
    }

    public static List<Class> getPackageContent(String packageName) throws IOException {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(applicationContext, false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(javax.persistence.Entity.class));
        scanner.scan(packageName);
        applicationContext.refresh();
        Map<String, Object> result = applicationContext.getBeansWithAnnotation(javax.persistence.Entity.class);
        List<Class> classes = new ArrayList<Class>();
        for (Object bean : result.values()) {
            classes.add(bean.getClass());
        }
        return classes;
    }
}