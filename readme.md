# Blog

spring boot로 만드는 blog 프로젝트

### 1일차



----

### 2일차


---

### 3일차 - WebMvcTest 사용 방법

```java
@AutoConfigureMybatis //Mybatis설정을 로드하는 annotation(mapper로드를 위한)
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest // MVC 객체를 테스트하는 annotation
public class BoardControllerTest {

    ...
    
    @Autowired
    private MockMvc mvc;
    
    ...

    @Test
    public void getBoardInfo(){
        ...
        try{
            MvcResult mr = mvc.perform(get("/board/write/1")).andExpectAll(status().isOk()).andReturn(); // /board/write/1 url에 요청하여 리턴 값으로 MvcResult를 받음;
            ...
        } catch(Exception e){
            e.getMessage();
        }
    }

    @Test
    public void writeRequestTest(){
        ...
        try{
            MvcResult mr = mvc.perform(post("/board/write")
                            .param("title", boardDTO1.getTitle()).param("content", boardDTO1.getContent()).param("category", String.valueOf(boardDTO1.getCategory()))) // param 메서드를 통해서 formData나 값을 넣어서 요청할 수 있음
                    .andExpectAll(status().isOk(), content().contentType("application/json")).andReturn();
            ...
        } catch(Exception e){
            e.getMessage();
        }
    }
}


```