
package calcapp.model;

/**
 *
 * @author drink
 */
public class Model {
    
    public float calcular(Long n1, Long n2, String oper){
        switch (oper){
            case "+": return n1 + n2;
            case "-": return n1 - n2;
            case "*": return n1 * n2;
            case "/":
                if (n2 == 0)
                    return 0;
                return n1 / n2;
            default: return 0;
        }
    }
    
}
