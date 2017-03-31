
package contole;

import entidades.Pincel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RA21553740
 */
@RestController
public class Controle {
    
       //Get Pinicel
    @RequestMapping("/pincel")
    public List<Pincel> buscarPincel(){
        ArrayList resultado = new ArrayList<Pincel>();
        
        Pincel p1 = new Pincel();
        p1.setCor("Azul");
        p1.setIdentificador(1);
        p1.setNum_serie(999);
        
        resultado.add(p1);
        
        return resultado;
                
        
                
    }
    
}
