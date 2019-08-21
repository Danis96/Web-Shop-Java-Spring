package controller;

import model.proizvodi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class proizvodiController {

    @RequestMapping(value = "/proizvodi", method = RequestMethod.GET)
    public String prikazSadrzaja(ModelMap model) throws ClassNotFoundException {

        model.addAttribute("proizvodi", new proizvodi());
        model.addAttribute("sviProizvodi", proizvodi.prikazProizvoda());

        return "proizvodi";

    }

    @RequestMapping(value = "/proizvodi", params = "ubaci", method = RequestMethod.POST)
    public String dodajProizvod(@ModelAttribute("proizvodi") proizvodi odabraniProizvod, ModelMap model) throws ClassNotFoundException {

        odabraniProizvod.kreiranjeProizvoda();
        prikazSadrzaja(model);

        return "proizvodi";

    }

    @RequestMapping(value = "/proizvodi", params = "delete", method = RequestMethod.POST)
    public String obrisiProizvod(@ModelAttribute("proizvodi") proizvodi stariProizvod, ModelMap model) throws ClassNotFoundException {

        stariProizvod.brisanjeProizvoda();
        prikazSadrzaja(model);
        
        return "proizvodi";
        
    }

}
