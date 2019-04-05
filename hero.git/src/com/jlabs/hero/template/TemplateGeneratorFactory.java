package com.jlabs.hero.template;

public class TemplateGeneratorFactory {


    public static TemplateGenerator getInstance(String templateType) {
        switch(templateType.toLowerCase()) {
            case "html" :
                return new HtmlTemplateGenerator();
                break;
            default: throw new RuntimeException("Invalid template type: " +  templateType);
        }
    }
}
