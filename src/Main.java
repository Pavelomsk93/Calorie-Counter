import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while(true) {
            printMenu();
            int command = scanner.nextInt();
            if (command ==1) {
                System.out.println("Введите номер месяца:");
                int moths=  scanner.nextInt();
                while(true) {
                    if (moths > 12) {
                        System.out.println("В году 12 месяцев");
                        moths=  scanner.nextInt();
                    }else {
                        break;
                    }
                }
                System.out.println("Введите день");
                int days = scanner.nextInt();
                while(true) {
                    if (days > 30) {
                        System.out.println("В месяце 30 дней");
                        days=  scanner.nextInt();
                    }else {
                        break;
                    }
                }
                System.out.println("Введите количество шагов:");
                int stepNumbers=  scanner.nextInt();
                while(true) {
                    if (stepNumbers < 0) {
                        System.out.println("Введите положительное зачение");
                        stepNumbers=  scanner.nextInt();
                    }else {
                        break;
                    }
                }
                stepTracker.saveSteps(moths,days,stepNumbers);
                System.out.println("Значение сохранено.");
            }else if(command ==2){
                System.out.println("Введите номер месяца:");
                int moths=  scanner.nextInt();
                while(true) {
                    if (moths > 12) {
                        System.out.println("В году 12 месяцев");
                        moths=  scanner.nextInt();
                    }else {
                        break;
                    }
                }
                stepTracker.statistics(moths);
            }else if(command ==3){
                System.out.println("Введите новую цель");
                int newGoal=  scanner.nextInt();
                while(true) {
                    if (newGoal < 0) {
                        System.out.println("Введите положительное зачение");
                        newGoal=  scanner.nextInt();
                    }else {
                        break;
                    }
                }
                stepTracker.changeStepsGoal(newGoal);
                System.out.println("Значение сохранено.");
            }else if(command==0){
                System.out.println("Программа завершена.До новых встреч!");
                break;
            }else{
                System.out.println("Такой команды нет.Введите другую команду");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Введите команду:");
        System.out.println("1-Ввести количество шагов за определённый день");
        System.out.println("2-Напечатать статистику за определённый месяц");
        System.out.println("3-Изменить цель по количеству шагов в день");
        System.out.println("0-Выход");
    }
}

