package com.example.ejecicioClase_II_spring_jpa.controladores;

import com.example.ejecicioClase_II_spring_jpa.entidades.Cliente;
import com.example.ejecicioClase_II_spring_jpa.servicios.ClienteSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteCtrl {

    private ClienteSrvc clienteSrvc;

    public ClienteCtrl(ClienteSrvc clienteSrvc) {
        this.clienteSrvc = clienteSrvc;
    }

//    @GetMapping("/listado")
//    public String listado(Model model) {
//        List<Cliente> listaClientes = clienteSrvc.listarTodos();
//        model.addAttribute("titulo", "Listado de Clientes");
//        model.addAttribute("clientes", listaClientes);
//
//        return "vistaLista";
//    }

}
