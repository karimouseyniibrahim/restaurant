package com.clientui.controller;

import com.clientui.beans.Restaurant;
import com.clientui.proxies.RestaurantProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private RestaurantProxy restaurantProxy ;

    @RequestMapping("/")
    public String accueil(Model model) {
        return "index";
    }
    @RequestMapping("/restaurants")
    public String restaurant(Model model) {
        List<Restaurant> restaurants =  restaurantProxy.listeDesRestaurant(false);

        model.addAttribute("notorder", true);
        model.addAttribute("restaurants", restaurants);
        return "Restaurant";
    }
    @RequestMapping("/classements")
    public String classements(Model model) {
        List<Restaurant> restaurants =  restaurantProxy.listeDesRestaurant(true);
        model.addAttribute("isorder", true);
        model.addAttribute("restaurants", restaurants);
        return "Restaurant";
    }
    @RequestMapping("/restaurants/{id}")
    public String RestaurantDetail(@PathVariable int id, Model model){
        Restaurant restaurant = restaurantProxy.recupererUnRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        return "DetailRestaurant";
    }
    @GetMapping("/getOnRestaurantt/{id}")
    @ResponseBody
    public Restaurant getOnRestaurantt(@PathVariable int id){

        return restaurantProxy.recupererUnRestaurant(id);
    }
    @PostMapping("/addnote")
    public String addCommande(  Restaurant restaurant){

        restaurantProxy.Evaluation(restaurant);
        return "redirect:/restaurants/"+restaurant.getId();

    }


  /*  @RequestMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id, Model model){
        ProductBean produit = ProduitsProxy.recupererUnProduit(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }

    @GetMapping("/findOneProduit/{id}")
    @ResponseBody
    public ProductBean findOneProduit(@PathVariable int id){

        return ProduitsProxy.recupererUnProduit(id);
    }

    @GetMapping("/findOneCommande/{id}")
    @ResponseBody
    public CommandeBean findOneCommande(@PathVariable int id){
        return CommandesProxy.recupererUneCommande(id);
    }

    @RequestMapping("/details-produit/commander-produit/{id}")
    public String commanderProduit(@PathVariable int id, Model model){

        ProductBean produit = ProduitsProxy.recupererUnProduit(id);

        model.addAttribute("produit", produit);

        return "content/CommanderProduit";
    }

    @PostMapping("/addcommande")
    public String addCommande(  CommandeBean commandeBean){

        commandeBean.setCommandePayee(false);

        commandeBean.setDateCommande(new Date());
        CommandesProxy.ajouterCommande(commandeBean);


        return "redirect:/details-produit/"+commandeBean.getProductId();

    }

    @GetMapping("/commande-no-paye")
    public String commandeNoPaye(Model model) {
        List<CommandeBean> commandes =  CommandesProxy.listeDesCommandesNoPayes(false);
        model.addAttribute("Nopayes", true);
        model.addAttribute("all", false);
        model.addAttribute("commandes", commandes);
        return "CommandeNoPaye";
    }
    @GetMapping("/commande-paye")
    public String commandePaye(Model model) {
        model.addAttribute("Nopayes", false);
        model.addAttribute("all", false);
        List<CommandeBean> commandes =  CommandesProxy.listeDesCommandesNoPayes(true);

        model.addAttribute("commandes", commandes);
        return "CommandeNoPaye";
    }
    @GetMapping("/commandes")
    public String commandes(Model model) {
        model.addAttribute("Nopayes", false);
        model.addAttribute("all", true);
        List<CommandeBean> commandes =  CommandesProxy.listeDesCommandes();

        model.addAttribute("commandes", commandes);
        return "CommandeNoPaye";
    }
    @GetMapping("/findOneCommandes/{id}")
    @ResponseBody
    public CommandeBean recupererUneCommande(@PathVariable int id){
        return CommandesProxy.recupererUneCommande(id);
    }

    @PostMapping("/payement")
    public String paieemntComment(  PaiementBean paiementBean){
        PaiementProxy.payerUneCommande(paiementBean);
        CommandeBean c=CommandesProxy.recupererUneCommande(paiementBean.getIdCommande());
        c.setCommandePayee(true);
        CommandesProxy.ajouterCommande(c);

        return "redirect:/commande-no-paye";

    }*/
}