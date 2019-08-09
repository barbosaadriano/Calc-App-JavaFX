package calcapp.model;

/**
 *
 * @author drink
 */
public class Model {

    public double calcular(double n1, double n2, String oper) {
        switch (oper) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "MOD":
                return this.calcMod(n1, n2);
            case "POT":
                return this.calcPot(n1, n2);
            case "/":
                if (n2 == 0) {
                    return 0;
                }
                return n1 / n2;
            default:
                return 0;
        }
    }

    private double calcMod(double n1, double n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 % n2;
    }

    private double calcPot(double n1, double n2) {
        return  Math.pow( n1,  n2);
    }

}
