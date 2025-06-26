package com.example.ejecicioClase_II_spring_jpa.controladores;

import com.example.ejecicioClase_II_spring_jpa.entidades.Oficina;
import com.example.ejecicioClase_II_spring_jpa.servicios.OficinaSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/oficina")
public class OficinaCtrl {

    private final OficinaSrvc ofiSrvc;

    public OficinaCtrl(OficinaSrvc ofiSrvc) {
        this.ofiSrvc = ofiSrvc;
    }

    @GetMapping("/{ofi}")
    public String fichaOficina(@PathVariable String ofi, Model model) {
        // 1 - Obtener los datos de la oficina
        Oficina oficina = ofiSrvc.cargarOficina(ofi).orElseThrow();
        model.addAttribute("oficina", oficina);
        model.addAttribute("empleados", oficina.getEmpleados());
        return "fichaOficina";
    }

    @PostMapping("/guardar")
    public String guardarOficina(@ModelAttribute Oficina ofi) {

        ofiSrvc.grabarOficina(ofi);

        return "redirect:/lista/oficina";
    }
}
