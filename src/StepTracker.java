import java.util.HashMap;

public class StepTracker {

    HashMap<Integer,int[]> monthToData = new HashMap<>();
    int goal = 10000;
    Converter converter = new Converter(0.00075,50,1000);

    void saveSteps(int months,int day,int step){ //Сохранение количества шагов
        int[] month = monthToData.get(months);
        if(month == null){
            month = new int[30];
            monthToData.put(months,month);
        }
        month[day-1]=step;
    }

    void statistics(int months){ //Вывод статистики
        double step = getSumSteps( months);
        System.out.println("Количество пройденных шагов по дням");
        printAllStepOnMonth(months);
        System.out.println("Общее количество шагов за месяц: " + step );
        System.out.println("Максимальное пройденное количество шагов в месяце: " + getMaxSteps( months) );
        System.out.println("Среднее количество шагов: " + getAverageOfSteps( months) );
        System.out.println("Пройденная дистанция (в км): " + converter.getStepLength(step));
        System.out.println("Количество сожжённых килокалорий: " + converter.getKkalInKal( step));
        System.out.println("Лучшая серия: максимальное количество подряд идущих" + "\n" +  "дней, когда количество шагов было выше целевого:  " + getBestSeries( months) );
    }

    int getMaxSteps(int months){ //Поиск максимального пройденного количества шагов в месяце
        int max = 0;
        int[] month = monthToData.get(months);
        if(month==null){
            month=new int[30];
        }
        for(int i=0;i<month.length;i++) {
            if(month[i]>max){
                max = month[i];
            }
        }
        return max;
    }

    void changeStepsGoal(int newGoal){ //Изменение целевого значения
        goal = newGoal;
    }

    void printAllStepOnMonth(int months){ //Вывод количества шагов по дням
        int[] month = monthToData.get(months);
        if(month==null){
            month=new int[30];
        }
        for(int i=0;i<month.length;i++) {
            System.out.print((i+1) + " день: " + month[i] + " шагов, ");
        }
        System.out.println("");
    }

    int getBestSeries(int months){ //Получение лучшей серии шагов
        int[] month = monthToData.get(months);
        if(month==null){
            month=new int[30];
        }
        int sum = 0;
        int series;
        int bestSeries = 0;
        for(int i=0;i<month.length;i++){
            if(month[i]>=goal){
                sum+=1;
                series = sum;
                if(series>bestSeries){
                    bestSeries=series;
                }
            }else{
                sum=0;
            }

        }
        return bestSeries;
    }

    public  int getSumSteps(int months) { //Подсчёт суммы шагов
        int[] month = monthToData.get(months);
        if(month==null){
            month=new int[30];
        }
        int sum = 0;
        for (int i = 0; i < month.length; i++) {
            sum += month[i];
        }
        return sum;
    }

    public  double getAverageOfSteps(int months){ //Подсчёт среднего значения
        int[] month = monthToData.get(months);
        if(month==null){
            month=new int[30];
        }
        double sum = 0;
        double average ;
        for(int i=0;i<month.length;i++){
            sum+=month[i];
        }
        average = sum/month.length;
        return average;
    }
}

