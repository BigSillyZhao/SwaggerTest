package com.bimface.demo;



import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Language;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import springfox.documentation.swagger2.web.Swagger2Controller;

import java.net.URL;
import java.nio.file.Paths;

@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SwaggerApplicationTests {

    private String snippetDir = "target/generated-snippets";
    private String outputDir = "target/asciidoc";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void Test() throws Exception {
        // 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
        // 这个outputDir必须和插件里面<generated></generated>标签配置一致
       /* Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
        MarkupDocBuilder builder = MarkupDocBuilders.documentBuilder(MarkupLanguage.CONFLUENCE_MARKUP);
        builder.addFileExtension("");
        Swagger2MarkupConverter.from(outputDir + "/1.json")//new URL("http://localhost:8080/v2/api-docs")
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/confluence/generated"));*/


        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)// 格式MarkupLanguage.MARKDOWN
                .withExamples(snippetDir)
                .withOutputLanguage(Language.EN)
                .withPathsGroupedBy(GroupBy.TAGS)
                .build()
                .intoFolder("src/docs/asciidoc/generated/1");// 分开输出intoFolder
    }
}
