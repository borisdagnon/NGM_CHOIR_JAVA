//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Programme;
import com.graceetfoi.gf.data.DaoProgramme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammeService {
    @Autowired
    private DaoProgramme daoProgramme;

    public ProgrammeService() {
    }

    public List<Programme> listeProgrammes() {
        return this.daoProgramme.listeProgrammes();
    }
}
