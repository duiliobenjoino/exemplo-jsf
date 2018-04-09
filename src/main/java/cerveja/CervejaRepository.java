
package cerveja;

import cerveja.model.Cerveja;
//import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.persistence.PersistenceContext;

/**
 *
 * @author Duilio Benjoino
 */
public class CervejaRepository {
    
    EntityManager entityManager;
    
//    @PersistenceContext
//    private EntityManager entityManager;
    
    public void salvar(Cerveja cerveja){
        entityManager =  Util.JpaEntityManager();
        if(cerveja.getId() == null){
            entityManager.persist(cerveja);
        }else{
            entityManager.merge(cerveja);
        }
    }
    
    public List<Cerveja> listarTodos(){
        entityManager =  Util.JpaEntityManager();
        Query query = entityManager.createQuery("Select obj from Cerveja obj order by obj.nome");
        
        @SuppressWarnings("unchecked")
        List<Cerveja> cervejas = (List<Cerveja>) query.getResultList();
        
        return cervejas;
    }
    
    public void delete(Cerveja cerveja){
        System.out.println("Cerveja: " + cerveja);
        entityManager =  Util.JpaEntityManager();
        entityManager.remove(entityManager.merge(cerveja));
    }
}
