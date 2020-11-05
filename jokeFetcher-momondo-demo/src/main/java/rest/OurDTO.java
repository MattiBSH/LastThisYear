/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTOs.ChuckDTO;
import DTOs.DadDTO;

/**
 *
 * @author matti
 */
class OurDTO {
    DadDTO dadDTO;
    ChuckDTO chuck;

    public OurDTO(DadDTO dadDTO, ChuckDTO chuck) {
        this.dadDTO = dadDTO;
        this.chuck = chuck;
    }

    public DadDTO getDadDTO() {
        return dadDTO;
    }

    public void setDadDTO(DadDTO dadDTO) {
        this.dadDTO = dadDTO;
    }

    public ChuckDTO getChuck() {
        return chuck;
    }

    public void setChuck(ChuckDTO chuck) {
        this.chuck = chuck;
    }
    
    
}
