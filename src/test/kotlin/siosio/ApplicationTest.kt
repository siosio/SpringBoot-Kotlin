package siosio

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.context.ContextConfiguration
import siosio.application.Application
import org.junit.Test
import org.springframework.test.web.servlet.MockMvc
import org.junit.Before
import org.mockito.MockitoAnnotations
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import kotlin.properties.Delegates
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.http.MediaType

[RunWith(javaClass<SpringJUnit4ClassRunner>())]
[ContextConfiguration(classes = array(javaClass<Application>()))]
[WebAppConfiguration]
public class ApplicationTest {

  private var mockMvc: MockMvc by  Delegates.notNull()

  Autowired val controller: Application? = null

  Before
  public fun setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  Test fun testHelloWorld() {
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("home/hello"))
        .andExpect(model().attribute("message", "Hello World!"))
  }
}