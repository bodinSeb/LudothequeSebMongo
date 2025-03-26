package com.eni.ludotheque2.bll;

import com.eni.ludotheque2.bo.Adresse;
import com.eni.ludotheque2.bo.Client;
import com.eni.ludotheque2.dal.IAdresseRepository;
import com.eni.ludotheque2.dal.IClientRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService implements IClientService{

    @NonNull
    private IClientRepository clientRepository;
    @NonNull
    private IAdresseRepository adresseRepository;


    @Override
    public void ajouterClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client findClientById(String id) {
        return clientRepository.findById(id).get();
    }
    @Override
    public List<Client> findClientByNom(String nom) {
        return clientRepository.findByNomContaining(nom);
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public void updateClient(Client client) {
        //TODO vérifier que client a un id
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(String idClient) {
        clientRepository.deleteById(idClient);
    }
}