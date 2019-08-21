package controller;

import model.kupci;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class kupciController {

    @RequestMapping(value = "/kupci", method = RequestMethod.GET)
    public String prikazSadrzaja(ModelMap model) throws ClassNotFoundException, ClassNotFoundException {
        
        model.addAttribute("kupci", new kupci());
        model.addAttribute("sviKupci", kupci.prikazKupaca());

        return "kupci";
    }

    @RequestMapping(value = "/kupci", params = "Dodaj", method = RequestMethod.POST)
    public String dodajKupca(@ModelAttribute("kupci") kupci odabraniKupac, ModelMap model) throws ClassNotFoundException {

        odabraniKupac.kreiranjeKupaca();
        prikazSadrzaja(model);

        return "kupci";

    }
    
    @RequestMapping(value = "/kupci", params = "Obrisi", method = RequestMethod.POST)
    public String obrisiKupca(@ModelAttribute("kupci") kupci stariKupac ,ModelMap model) throws ClassNotFoundException{
        
        stariKupac.brisanjeKupca();
        prikazSadrzaja(model);
        
        return "kupci";
        
    }

}
