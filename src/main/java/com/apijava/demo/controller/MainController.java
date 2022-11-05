package com.apijava.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {

    @GetMapping("/hello")
    public String hola(){
        return "Hola mi nombre es Vero y esta es mi primera API";
    }

    @GetMapping("/hello2/{nombre}")
    public String hola2(@PathVariable String nombre){
        return "Hola mi nombre es " + nombre;
    }

    @GetMapping("/hello3")
    public String hola3(@RequestParam String nombre){
        return "Hola soy " + nombre;
    }

   @PostMapping("/goodbye")
   public String chau(){
        return "Hasta luego!";
   }

    @PostMapping("/verpersona")
    public String persona(@RequestBody Persona persona) {
        Persona persona1 = new Persona(persona.getNombre(), persona.getApellido());
        return persona1.toString();
    }

}