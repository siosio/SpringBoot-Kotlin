package siosio.application

import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller
import kotlin.properties.Delegates
import org.springframework.ui.Model

fun main(args: Array<String>) {
  SpringApplication.run(array(javaClass<Application>()), args)
}

[EnableAutoConfiguration]
[ComponentScan]
[Controller]
open class Application[Autowired](val hello:HelloService) {

  [RequestMapping(array("/"))]
  fun home(model: Model): String {
    model.addAttribute("message", hello.getMessage())
    return "home/hello"
  }
}

[Component]
class HelloService {
  fun getMessage(): String = "Hello World!"
}