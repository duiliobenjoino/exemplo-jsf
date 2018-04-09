
package cerveja.controller;

import cerveja.CervejaRepository;
import cerveja.Util;
import cerveja.model.Sabor;
import cerveja.model.Cerveja;
import cerveja.model.Origem;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Duilio Benjoino
 */

@Named(value = "cadastroCervejaController")
@RequestScoped
public class CadastroCervejaController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    
    private String titulo = "Cadastro de cerveja";
    
    private Cerveja cerveja;
    
    @Inject
    private CervejaRepository repository;

    public Cerveja getCerveja() {
        return this.cerveja;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public Origem[] getOrigens(){
        return Origem.values();
    }
    
    public Sabor[] getSabores(){
        return Sabor.values();
    }
    
    @PostConstruct
    public void init() {
        this.cerveja = (Cerveja) context.getFlash().get("cerveja");
        if(this.cerveja == null){
            this.cerveja = new Cerveja();
        }else{
            this.titulo = "Edição da cerveja #" + this.cerveja.getId();
        }
    }
    
    public void salvar() throws IOException{
        boolean isEditando = this.cerveja.getId()!=null;
        this.repository.salvar(this.cerveja);
        Util.msgInfo(this.cerveja.getNome() + " foi salva com sucesso");
        if(isEditando){
            context.redirect("index.xhtml");
        }else{
            this.cerveja = new Cerveja();
        }
    }
}
