package com.eni.ludotheque2.API;

import com.eni.ludotheque2.bll.IClientService;
import com.eni.ludotheque2.bo.Adresse;
import com.eni.ludotheque2.bo.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClients(@RequestParam(required = false) String nom) {
        List<Client> clients = null;
        if(nom == null || nom.trim().equals("")) {
            clients = clientService.findAllClient();
        }else {
            clients = clientService.findClientByNom(nom);
        }
        if(clients == null || clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        Client client = clientService.findClientById(id);
        if(client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping ("/client")
    public ResponseEntity<?> create(@RequestBody  Client client) {
        clientService.ajouterClient(client);
        if(client.getId_client().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de la création du client");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Le client a été créé avec succès");
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody  Client client) {
        Client clientBase = clientService.findClientById(id);
        if(clientBase == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //Pour éviter le mappage
        //BeanUtils.copyProperties(client, clientBase, "idClient");
        Client clientUpdate = MapClientToClient(clientBase, client);
        try {
            clientService.updateClient(clientUpdate);
            return ResponseEntity.status(HttpStatus.OK).body("modification réussie");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de la modification du client");
        }
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Client clientBase = clientService.findClientById(id);
        if(clientBase == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            clientService.deleteClient(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppression du client : " + clientBase.getNom());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de la suppression du client");
        }
    }

    private Client MapClientToClient(Client clientBase, Client client) {
        clientBase.setNom(client.getNom());
        clientBase.setPrenom(client.getPrenom());
        clientBase.setEmail(client.getEmail());
        clientBase.setNo_telephone(client.getNo_telephone());
        clientBase.setAdresse(client.getAdresse());
        return clientBase;
    }

}