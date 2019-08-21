package controller;

import java.sql.SQLException;
import model.kupci;
import model.prodaja;
import model.proizvodi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class prodajaController {
    
    @RequestMapping(value="/prodaja", method = RequestMethod.GET)
    public String prikazSadrzaja(ModelMap model) throws ClassNotFoundException {
        
        model.addAttribute("kupci", new kupci());
        model.addAttribute("sviKupci", kupci.prikazKupaca());
        model.addAttribute("proizvodi", new proizvodi());
        model.addAttribute("sviProizvodi", proizvodi.prikazProizvoda());
        model.addAttribute("prodaja", new prodaja());
        return "prodaja";
        
    }
    
    @RequestMapping(value="/prodaja", params="Prodaj" ,method = RequestMethod.POST)
    public String prodaja(@ModelAttribute("kupci") kupci kupci, @ModelAttribute("proizvodi") proizvodi proizvodi, 
            @ModelAttribute("prodaja") prodaja prodajas ,ModelMap model) throws ClassNotFoundException, SQLException {
        
        int proizvod = prodajas.getProizvod();
        int kupac = prodajas.getKupac();
        prodaja.prodaja(kupac, proizvod);
        prikazSadrzaja(model);
        return "prodaja";
        
        
    }
    
    
}
