package com.bimface.demo;

import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Language;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;
import springfox.documentation.staticdocs.SwaggerResultHandler;

import javax.servlet.ServletContext;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@RunWith(SpringRunner.class)
@SpringBootTest
public class Swagger2MarkupTest {

    @Autowired
    private WebApplicationContext context;

    /**
     *
     */
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
    @Test
    public void convertSwaggerToMarkdown() throws Exception {
        String outputDir = "src/docs/json";  //将api-docs的json数据写入文件
        MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8080/v2/api-docs") .accept("application/json;charset=utf-8"))
                .andExpect(status().isOk()) .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();
        Files.createDirectories(Paths.get(outputDir));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"), StandardCharsets.UTF_8)) {
            writer.write(swaggerJson);
        }
        mockMvc.perform(get("http://localhost:8080/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
                .andExpect(status().isOk())
                .andReturn();

        // 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir这个outputDir必须和插件里面<generated></generated>标签配置一致

        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
                .withOutputLanguage(Language.EN)
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
                //.withExamples(snippetDir)
                .build()
                .intoFolder(outputDir);// 输出

      /*
        this.mockMvc.perform(get("http://localhost:8080/v2/api-docs").accept(MediaType.APPLICATION_JSON)
                )
                .andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/markdown/generated")
                        .withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
                .andExpect(status().isOk());*/
    }
}