/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Taller5SanMiguelMateo.controller;

import com.example.Taller5SanMiguelMateo.model.Alumno;
import com.example.Taller5SanMiguelMateo.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Método para mostrar la página de login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Método para procesar el login
    @PostMapping("/login")
    public String loginSubmit(String username, String password, Model model) {
        // Validar las credenciales
        if ("root".equals(username) && "root".equals(password)) {
            return "redirect:/alumnos";  // Redirigir a la página de alumnos si las credenciales son correctas
        }
        // Si las credenciales son incorrectas
        model.addAttribute("error", "Credenciales incorrectas");
        return "login";  // Si es incorrecto, volver a la página de login
    }

    // Método para mostrar el listado de alumnos
    @GetMapping("/alumnos")
    public String showAlumnos(Model model) {
        // Obtener todos los alumnos de la base de datos
        model.addAttribute("alumnos", alumnoRepository.findAll());
        return "alumnos";  // Mostrar la vista de alumnos
    }
}