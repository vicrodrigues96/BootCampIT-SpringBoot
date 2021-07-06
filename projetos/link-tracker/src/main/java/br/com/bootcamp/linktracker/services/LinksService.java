package br.com.bootcamp.linktracker.services;

import br.com.bootcamp.linktracker.dtos.LinkDTO;
import br.com.bootcamp.linktracker.repositories.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LinksService {

    private final LinksRepository linksRepository;

    @Autowired
    public LinksService(LinksRepository linksRepository) {
        this.linksRepository = linksRepository;
    }

    public LinkDTO adicionarLink(String url, String password) {
        return this.linksRepository.criaLink(url, password);
    }

    public List<LinkDTO> retornaListaLinks() {
        return this.linksRepository.listarLinks();
    }

    public void redirecionar(int linkId, String password) {
        this.linksRepository.redirecionar(linkId, password);
    }

    public LinkDTO getQtdeAcessos(int linkId) {
        return this.linksRepository.getQtdeAcessos(linkId);
    }

    public void invalidarLin(int linkId) {
        LinkDTO link = this.linksRepository.listarLinks().get(linkId);

        if (Objects.isNull(link)) {
            throw new IllegalArgumentException("Link is not valid");
        }

        this.linksRepository.invalidateLink(linkId);
    }
}
