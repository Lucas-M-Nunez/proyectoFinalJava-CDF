package com.CarritoDeCompra.Java.Controller;

import com.CarritoDeCompra.Java.Moduls.Producto.Comestible;
import com.CarritoDeCompra.Java.Moduls.Producto.Electronico;
import com.CarritoDeCompra.Java.Moduls.Producto.Ropa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TiendaController {
    public static List<Ropa> listaRopa;
    public static List<Electronico> listaElectronico;
    public static List<Comestible> listaComestibles ;
    public void inicializarListas() {


        if (listaRopa == null ) {
            listaRopa = new ArrayList<>();
            Ropa articulo1 = new Ropa("Remera", 10000, "L", "Tommy Hilfinger", "Nueva Edición - blanca");
            Ropa articulo2 = new Ropa("Zapatillas", 50000,"36", "Converse", "zapatillas negras con blanco");
            Ropa articulo3 = new Ropa("Buzo", 35000, "XL", "LaCoste", "Colaboracion LaCoste x Netflix");
            listaRopa.add(articulo1);
            listaRopa.add(articulo2);
            listaRopa.add(articulo3);
        }


        if (listaComestibles == null ) {
            listaComestibles = new ArrayList<>();
            Comestible comes1 = new Comestible("Tomate", 120);
            Comestible comes2 = new Comestible("Fideos", 700);
            Comestible comes3 = new Comestible("Pan", 200);
            listaComestibles.add(comes1);
            listaComestibles.add(comes2);
            listaComestibles.add(comes3);
        }


        if (listaElectronico == null ) {
            listaElectronico = new ArrayList<>();
            Electronico celular = new Electronico("Gabinete", 250000, "Hyperfury");
            Electronico teclado = new Electronico("Teclado ", 50000, "RedDragon");
            Electronico astrolabio = new Electronico("Parlante", 20000, "noga");
            listaElectronico.add(celular);
            listaElectronico.add(teclado);
            listaElectronico.add(astrolabio);
        }
    }

    @GetMapping("/")
    public String Inicio() {
        return "index.html";

    }

    @GetMapping("/ropa")
    public String ropa(Model model){
        inicializarListas();
        model.addAttribute("prendas", listaRopa);
        return "ropa";
    }
    @GetMapping("/comestible")
    public String mapComida(Model model){
        model.addAttribute("comidas", listaComestibles);
        return "comestible";
    }
    @GetMapping("/electronico")
    public String electronico(Model model){
        inicializarListas();
        model.addAttribute("electronicos", listaElectronico);
        return "electronico";
    }
}
