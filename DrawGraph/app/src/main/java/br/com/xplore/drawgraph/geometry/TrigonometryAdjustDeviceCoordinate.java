package br.com.xplore.drawgraph.geometry;



import static java.lang.Math.atan2;
import static java.lang.Math.PI;

public class TrigonometryAdjustDeviceCoordinate {

    public static double circularAngleRadBetweenPoints(double cx, double cy, double px, double py) {
        /**
         * Lembrado que a formula
         * atan2(-(py2-cy1), -(px2-cx1))
         * eh usada para quandp lidamos com coordenada de dispositivo
         * onde os quadrantes sao diferentes
         *
         * A imagem da funcao atan2
         * -PI <= atan2(y, x) <= PI
         *
         * Para x > 0, lado direito do plano - quadrante 1 e 4
         * o intervalo da funcao eh [-PI/2, PI/2]
         *
         * Para y > 0 quandramte 1 e 3
         * o intervalor da funcao eh [-PI, PI]
         *
         * para x < 0
         * o intervalor da funcao eh [-PI, -PI/2]
         *
         * para x < 0 e y > 0 -> y positivo e x negativo
         * o intervalo da funcao eh [PI/2, PI]
         *
         *
         * para y < 0
         * o intervalor da funcao eh [PI, -PI/2]
         *
         *
         * para x < 0 e y < 0
         * [PI, 3PI/2]
         *
         * para x > 0 e y < 0 -> para x positivo e y negativo
         * o intervalor da funcao eh [3PI/2, PI*2]
         * */
        //return PI - atan2(-(py2-cy1), -(px2-cx1)) % (PI * 2);
        return PI - atan2((py-cy), (px-cx)) % PI;
    }

    public static double circularAngleDegBetweenPoints(double cx, double cy, double px, double py) {
        /**
         * https://en.wikipedia.org/wiki/Atan2
         * https://stackoverflow.com/questions/9970281/java-calculating-the-angle-between-two-points-in-degrees/28316570#28316570
         * quadrante 1
         * pora x e y
         * quadrante 2
         * pora -x e y
         * quadrante 3
         * para -x e -y
         * quadrante 4
         * para x e -y
         *
         * */
        //double angle = atan2(py-cy, px-cx) * 180.0f / PI;
        /**
         * Um teste para coordenadas de dispositivo
         * se py-cy < 0 o ponto escolhido esta acima do ponto
         * que foi denominado como centro
         * primeiro quadrante
         * -x, -y
         * segundo quadrante
         * x, -y
         * terceiro quadrante
         * -x, y
         * quarto quadrante
         * x, y
         * entao a formula atan2(-(py-cy), -(px-cx) transforma
         * os quadrantes da coordenada de dispositivo nos quadrantes
         * das coordenadas cartesianas que ja conhecemos, e
         *  180 - atan2(-(py-cy), -(px-cx)) * 180.0f / PI
         *  vai fazer os pontos variarem entre 0 e 360
         * */
        //
        return (180 - atan2(-(py-cy), -(px-cx)) * 180.0f / PI) % 360;
    }

    private static double dotProduct(double px1, double py1, double px2, double py2) {
        return px1 * px2 + py1 * py2;
    }

    private static double magnitude(double px, double py) {
        return Math.sqrt(px*px+py*py);
    }
    /**
     * https://math.stackexchange.com/questions/1201337/finding-the-angle-between-two-points
     * http://onlinemschool.com/math/assistance/vector/angl/
     * */
    public static double angleDegreeBetweenPointsUsingDotProduct(double px1, double py1, double px2, double py2) {
        return  dotProduct(px1, py1, px2, py2) / (magnitude(px1, py1) * magnitude(px2, py2));
    }
}
