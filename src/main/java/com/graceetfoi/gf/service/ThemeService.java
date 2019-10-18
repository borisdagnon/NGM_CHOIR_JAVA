//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Theme;
import com.graceetfoi.gf.data.DaoTheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {
    @Autowired
    private DaoTheme daoTheme;

    public ThemeService() {
    }

    public List<Theme> listeTheme() {
        return this.daoTheme.findAll();
    }
}
