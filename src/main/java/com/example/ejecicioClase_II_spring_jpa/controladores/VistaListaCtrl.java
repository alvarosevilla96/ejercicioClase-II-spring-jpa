package com.example.ejecicioClase_II_spring_jpa.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/lista")
public class VistaListaCtrl {

    private final FactoriaVistaLista factoriaVistaLista;

    public VistaListaCtrl(FactoriaVistaLista factoriaVistaLista) {
        this.factoriaVistaLista = factoriaVistaLista;
    }

    @GetMapping("/{nombreEntidad}")
    public String listarDatos(@PathVariable String nombreEntidad, Model model) {

        ProveedorDatosLista proveedor = factoriaVistaLista.getProveedorDatosLista(nombreEntidad)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entidad no encontrada: " + nombreEntidad));
        model.addAttribute("titulo", proveedor.getTitulo());
        model.addAttribute("cabeceras", proveedor.getCabeceras());
        model.addAttribute("filas", proveedor.getFilas());
        model.addAttribute("rutaEntidad", proveedor.getNombreEntidad());
//        model.addAttribute("cabecerasExtendidas", proveedor.getCabecerasExtendidas());

        return "vistaLista";
    }

}
