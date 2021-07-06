package br.com.bootcamp.linktracker.dtos;

public class LinkDTO {

    private int linkId;
    private String url;
    private int qtdeRedirecionamentos;
    private boolean ativo;
    private String password;

    public LinkDTO(int linkId, String url, int qtdeRedirecionamentos, String password, boolean ativo) {
        this.linkId = linkId;
        this.url = url;
        this.qtdeRedirecionamentos = qtdeRedirecionamentos;
        this.password = password;
        this.ativo = true;
    }

    public LinkDTO(int linkId, String url) {
        this.linkId = linkId;
        this.url = url;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getQtdeRedirecionamentos() {
        return qtdeRedirecionamentos;
    }

    public void setQtdeRedirecionamentos(int qtdeRedirecionamentos) {
        this.qtdeRedirecionamentos = qtdeRedirecionamentos;
    }

    public boolean getIsAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
