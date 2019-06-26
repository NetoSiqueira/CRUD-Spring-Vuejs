package npi.ufc.autoestudo.service;

import npi.ufc.autoestudo.Repository.ContatoRepository;
import npi.ufc.autoestudo.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatorepository;

    public Contato salvar(Contato contato){
      return contatorepository.save(contato);
    }

    public List<Contato> Listar(){
        return  contatorepository.findAll();
    }

    public void deletar(Long id){
        contatorepository.delete(id);
    }

    public Contato buscarPorId(Long id) {

            return contatorepository.getOne(id);

    }

    public Contato EditarContato(Contato contato){
                    
            return  salvar(contato);  
	}
}
