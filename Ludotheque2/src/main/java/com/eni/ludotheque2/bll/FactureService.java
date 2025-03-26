package com.eni.ludotheque2.bll;

import com.eni.ludotheque2.bo.Facture;
import com.eni.ludotheque2.bo.Location;
import com.eni.ludotheque2.dal.IFactureRepository;
import com.eni.ludotheque2.dal.ILocationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FactureService implements IFactureService {

    @NonNull
    private ILocationRepository locRepository;
    @NonNull
    private IFactureRepository factureRepository;

    private Float montantFacture = 0.0f;

    @Override
    public Facture createFacture(List<String> idsLoc, String idClient) {
        Facture facture = new Facture();
        facture.setDate_paiement(new Date());
        List<Location> locations = new ArrayList<>();
        idsLoc.forEach(id -> {
            Location l = locRepository.findById(id).get();
            if(Objects.equals(l.getClient().getId_client(), idClient)){
                locations.add(l);
                MajMontantFacture(l);
            }
        });
        facture.setLocations(locations);
        facture.setMontantFacture(montantFacture);
        factureRepository.save(facture);
        if(facture.getId_facture().isEmpty()){
           throw new RuntimeException("La facture n'a pas été crée");
        }else {
            return facture;
        }
    }

    @Override
    public List<Facture> findFactureByIdClient(String idClient) {
        return findFactureByIdClientRecherche(idClient);
    }

    private void MajMontantFacture(Location loc) {
        long diffInMillies = loc.getDate_retour().getTime() - loc.getDate_debut().getTime();
        long nbJour = diffInMillies / (1000 * 60 * 60 * 24) + 1;
        Float montantLoc = loc.getTarif_jour() * nbJour;
        montantFacture = montantFacture + montantLoc;
    }

    @Autowired
    private MongoTemplate mongoTemplate;  // Utilisation de MongoTemplate pour les agrégations

    private List<Facture> findFactureByIdClientRecherche(String idClient) {
        // Agrégation pour trouver les livres par le nom de l'éditeur
        Aggregation agg = Aggregation.newAggregation(
                // $lookup pour faire la jointure avec la collection 'publishers'
                Aggregation.lookup("locations", "locations", "_id", "locationDetails"),

                //$unwind pour décomposer la liste de l'éditeur (s'il y en a plusieurs)
                Aggregation.unwind("locationDetails"),

                // $match pour filtrer par nom d'éditeur
                Aggregation.match(Criteria.where("locationDetails.client.id").is(idClient))
        );

        // Exécution de l'agrégation
        AggregationResults<Facture> results = mongoTemplate.aggregate(agg, Facture.class, Facture.class);

        // Retourner la liste des livres trouvés
        List<Facture> books = results.getMappedResults();
        return results.getMappedResults();
    }
}
