public class Converter {
    double stepLength;
    double kalOfStep;
    double kkalInKal;

    Converter(double length,double kal,double kkal) {
        stepLength = length;
        kalOfStep = kal;
        kkalInKal = kkal;
    }



    public double getStepLength(double step) { //Конвертация общего количества шагов в км.
        return step*stepLength;
    }

    public double getKkalInKal(double step) { // Подсчёт общего значения количества килокалорий
        return step*kalOfStep/kkalInKal;
    }
}
