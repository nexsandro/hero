package com.jlabs.hero;

import com.jlabs.hero.template.TemplateGenerator;
import com.jlabs.hero.template.TemplateGeneratorFactory;

public class Hero {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Hero <entity-name> [template-type]");
            return;
        }

        String entityName = args[0];
        String templateType = args.length > 1 ? args[1] : "html";

        TemplateGenerator tg = TemplateGeneratorFactory.getInstance(templateType);
        tg.generateTemplate(entityName);
    }

}
