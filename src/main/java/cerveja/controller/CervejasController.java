
package cerveja.controller;

import cerveja.CervejaRepository;
import cerveja.model.Cerveja;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Duilio Benjoino
 */

@Named(value = "cervejasController")
@ViewScoped
public class CervejasController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    
    @Produces 
    private List<Cerveja> cervejas;
    
    @Inject transient
    private CervejaRepository repository;

    public List<Cerveja> getCervejas() {
        return cervejas;
    }

    public void setCervejas(List<Cerveja> cervejas) {
        this.cervejas = cervejas;
    }
    
    public void irParaEditar(Cerveja cerveja) throws IOException{
        context.getFlash().put("cerveja", cerveja);
        context.redirect("cadastroCerveja.xhtml");
    }
    
    public void remover(Cerveja cerveja){
        this.repository.delete(cerveja);
        this.cervejas.remove(cerveja);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Confirmação", "Registro excluido com sucesso!"));
    }
    
    @PostConstruct
    public void init(){
        this.cervejas = this.repository.listarTodos();
    }
}
