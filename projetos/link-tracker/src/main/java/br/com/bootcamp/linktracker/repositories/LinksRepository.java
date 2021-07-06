package br.com.bootcamp.linktracker.repositories;

import br.com.bootcamp.linktracker.dtos.LinkDTO;
import br.com.bootcamp.linktracker.entities.Link;
import br.com.bootcamp.linktracker.exceptions.InvalidPasswordException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinksRepository {

    private int codigo;

    Map<Integer, LinkDTO> listLinks = new HashMap<>();

    public LinkDTO criaLink(String url, String password) {
        int linkId = this.codigo++;
        listLinks.put(linkId, new Link(linkId, url, password).toDTO());
        return listLinks.get(linkId);
    }

    public List<LinkDTO> listarLinks() {

        List<LinkDTO> listaLinks = new ArrayList<>();
        List<Map.Entry<Integer, LinkDTO>> mapToList = new ArrayList<>(listLinks.entrySet());

        mapToList.forEach(l -> {
            listaLinks.add(l.getKey(), l.getValue());
        });

        return listaLinks;
    }

    public void redirecionar(int linkId, String password) {
        if (!this.listLinks.get(linkId).getIsAtivo()) {
            throw new IllegalArgumentException("Link invalido!");
        }
        this.matchPassword(password, this.listLinks.get(linkId).getPassword());

        int contador = this.listLinks.get(linkId).getQtdeRedirecionamentos();
        this.listLinks.get(linkId).setQtdeRedirecionamentos(contador + 1);
        this.listLinks.get(linkId);
    }

    public LinkDTO getQtdeAcessos(int linkId) {
        return this.listLinks.get(linkId);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void invalidateLink(int linkInd) {
        this.listLinks.get(linkInd).setAtivo(false);
    }

    public void matchPassword(String passwordReq, String passwordData) {
        if (!passwordReq.toLowerCase().equals(passwordData.toLowerCase())) {
            throw new InvalidPasswordException("Passwords dont match");
        }
    }
}
