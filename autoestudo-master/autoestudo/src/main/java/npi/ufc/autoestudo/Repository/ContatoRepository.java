package npi.ufc.autoestudo.Repository;

import npi.ufc.autoestudo.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository  extends JpaRepository<Contato, Long>{

}
