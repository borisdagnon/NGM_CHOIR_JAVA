//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Evenement;
import com.graceetfoi.gf.data.DaoEvenement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvenementService {
    @Autowired
    private DaoEvenement daoEvenement;

    public EvenementService() {
    }

    public List<Evenement> listeEvenements() {
        return this.daoEvenement.findAll();
    }
}
