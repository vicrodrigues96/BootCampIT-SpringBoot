package br.com.bootcamp.linktracker.entities;

import br.com.bootcamp.linktracker.dtos.LinkDTO;
import lombok.Data;

@Data
public class Link {

    private int linkId;
    private String url;
    private int qtdeRedirecionamento = 0;
    private boolean ativo;
    private String password;

    public Link(int linkId, String url, String password) {
        this.linkId = linkId;
        this.url = url;
        this.password = password;
        this.ativo = true;
    }

    public LinkDTO toDTO() {
        return new LinkDTO(this.linkId, this.url, this.qtdeRedirecionamento, this.password, this.ativo);
    }

    public void contadorRedirect() {
        this.qtdeRedirecionamento++;
    }
}
